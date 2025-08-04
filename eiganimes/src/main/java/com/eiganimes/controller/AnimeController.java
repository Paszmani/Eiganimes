package com.eiganimes.controller;

import com.eiganimes.controller.request.AnimeRequest;
import com.eiganimes.controller.response.AnimeResponse;
import com.eiganimes.entity.Anime;
import com.eiganimes.mapper.AnimeMapper;
import com.eiganimes.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/eiganimes/anime")
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService animeService;


    @PostMapping
    public ResponseEntity<AnimeResponse> save(@RequestBody AnimeRequest request) {
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
    public ResponseEntity<AnimeResponse> update(@PathVariable Long id, @RequestBody AnimeRequest request) {
        return animeService.update(id, AnimeMapper.toAnime(request))
                .map(anime -> ResponseEntity.ok(AnimeMapper.toAnimeResponse(anime)))
                .orElse(ResponseEntity.notFound().build());
    }

}
