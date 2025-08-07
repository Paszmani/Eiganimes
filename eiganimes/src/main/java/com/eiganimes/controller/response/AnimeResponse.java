package com.eiganimes.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record AnimeResponse(@Schema(type = "long", description = "Anime id")
                            Long id,
                            @Schema(type = "string", description = "Anime name")
                            String title,
                            @Schema(type = "string", description = "Anime description")
                            String description,
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            @Schema(type = "date", description = "Anime release date")
                            LocalDate releaseDate,
                            @Schema(type = "double", description = "Anime rating. ex: 8.9")
                            double rating,
                            @Schema(type = "array", description = "Category codes list")
                            List<CategoryResponse> categories,
                            @Schema(type = "string", description = "Streaming service codes list")
                            List<StreamingResponse> streamings) {
}
