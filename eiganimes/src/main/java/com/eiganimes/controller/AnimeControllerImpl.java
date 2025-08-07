package com.eiganimes.controller;

import com.eiganimes.controller.request.AnimeRequest;
import com.eiganimes.controller.response.AnimeResponse;
import com.eiganimes.entity.Anime;
import com.eiganimes.mapper.AnimeMapper;
import com.eiganimes.service.AnimeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController()
@RequestMapping("/eiganimes/anime")
@RequiredArgsConstructor
public class AnimeControllerImpl implements AnimeController{

    private final AnimeService animeService;

    @PostMapping
    public ResponseEntity<AnimeResponse> save(@Valid @RequestBody AnimeRequest request) {
        Anime savedAnime = animeService.save(AnimeMapper.toAnime(request));
        return ResponseEntity.ok(AnimeMapper.toAnimeResponse(savedAnime));
    }

    @GetMapping
    public ResponseEntity<List<AnimeResponse>> findAll() {
        return ResponseEntity.ok(animeService.findAll()
                .stream()
                .map(AnimeMapper::toAnimeResponse)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimeResponse> findById(@PathVariable Long id) {
        return animeService.findById(id)
                .map(anime -> ResponseEntity.ok(AnimeMapper.toAnimeResponse(anime)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimeResponse> update(@Valid @PathVariable Long id, @RequestBody AnimeRequest request) {
        return animeService.update(id, AnimeMapper.toAnime(request))
                .map(anime -> ResponseEntity.ok(AnimeMapper.toAnimeResponse(anime)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<AnimeResponse>> findByCategory(@RequestParam Long category) {
        return ResponseEntity.ok(animeService.findByCategory(category)
                .stream()
                .map(AnimeMapper::toAnimeResponse)
                .toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Anime> optionalAnime = animeService.findById(id);
        if(optionalAnime.isPresent()) {
            animeService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
