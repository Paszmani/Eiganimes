package com.eiganimes.mapper;

import com.eiganimes.controller.request.AnimeRequest;
import com.eiganimes.controller.response.AnimeResponse;
import com.eiganimes.controller.response.CategoryResponse;
import com.eiganimes.controller.response.StreamingResponse;
import com.eiganimes.entity.Anime;
import com.eiganimes.entity.Category;
import com.eiganimes.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class AnimeMapper {

    public static Anime toAnime(AnimeRequest request) {
        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Anime.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating((request.rating()))
                .categories(categories)
                .streamings(streamings)
                .build();

    }

    public static AnimeResponse toAnimeResponse(Anime anime) {

        List<CategoryResponse> categories = anime.getCategories()
                .stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamings = anime.getStreamings()
                .stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();


        return AnimeResponse.builder()
                .id(anime.getId())
                .title(anime.getTitle())
                .description(anime.getDescription())
                .releaseDate(anime.getReleaseDate())
                .rating(anime.getRating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}
