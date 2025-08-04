package com.eiganimes.repository;

import com.eiganimes.entity.Anime;
import com.eiganimes.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    List<Anime> findAnimeByCategories(List<Category> categories);
}
