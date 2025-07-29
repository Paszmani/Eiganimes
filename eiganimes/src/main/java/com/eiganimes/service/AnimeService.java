package com.eiganimes.service;

import com.eiganimes.entity.Anime;
import com.eiganimes.entity.Category;
import com.eiganimes.entity.Streaming;
import com.eiganimes.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;


    public Anime save(Anime anime) {
        anime.setCategories(this.findCategories(anime.getCategories()));
        anime.setStreamings(this.findStreamings(anime.getStreamings()));
        return animeRepository.save(anime);
    }

    public List<Anime> findAll() {
        return animeRepository.findAll();
    }

    public Optional<Anime> findById(Long id) {
        return animeRepository.findById(id);
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.findById(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings) {
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.findById(streaming.getId()).ifPresent(streamingsFound::add));
        return streamingsFound;
    }
}
