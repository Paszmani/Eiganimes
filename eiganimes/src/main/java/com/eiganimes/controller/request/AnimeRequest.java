package com.eiganimes.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record AnimeRequest(@Schema(type = "string", description = "Anime name")
                           @NotEmpty(message = "Anime title is required")
                           String title,
                           @Schema(type = "string", description = "Anime description")
                           String description,
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           @Schema(type = "date", description = "Anime release date. ex: '24/09/2003'")
                           LocalDate releaseDate,
                           @Schema(type = "double", description = "Anime rating. ex: 8.9")
                           double rating,
                           @Schema(type = "array", description = "Category codes list")
                           List<Long> categories,
                           @Schema(type = "array", description = "Streaming service codes list")
                           List<Long> streamings) {
}
