package com.eiganimes.repository;

import com.eiganimes.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {


}
