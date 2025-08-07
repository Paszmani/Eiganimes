package com.eiganimes.controller;

import com.eiganimes.controller.request.AnimeRequest;
import com.eiganimes.controller.response.AnimeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Anime", description = "Resource responsible for anime management.")
public interface AnimeController {

    @Operation(summary = "Save anime", description = "Method responsible to save a new Anime.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Anime saved with success",
            content = @Content(schema = @Schema(implementation = AnimeResponse.class)))
    ResponseEntity<AnimeResponse> save(@Valid @RequestBody AnimeRequest request);

    @Operation(summary = "Search animes", description = "Method responsible to return all registered animes.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Return all registered animes",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = AnimeResponse.class))))
    ResponseEntity<List<AnimeResponse>> findAll();

    @Operation(summary = "Search anime by id", description = "Method responsible to search animes by id.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Anime found with success",
            content = @Content(schema = @Schema(implementation = AnimeResponse.class)))
    @ApiResponse(responseCode = "404", description = "Anime not found", content = @Content())
    ResponseEntity<AnimeResponse> findById(@PathVariable Long id);

    @Operation(summary = "Update animes", description = "Method responsible to update animes.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Anime updated with success",
            content = @Content(schema = @Schema(implementation = AnimeResponse.class)))
    @ApiResponse(responseCode = "404", description = "Anime not found", content = @Content())
    ResponseEntity<AnimeResponse> update(@Valid @PathVariable Long id, @RequestBody AnimeRequest request);

    @Operation(summary = "Search animes by category", description = "Method responsible to return animes by category",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Return animes by category",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = AnimeResponse.class))))
    ResponseEntity<List<AnimeResponse>> findByCategory(@RequestParam Long category);

    @Operation(summary = "Delete animes", description = "Method responsible to delete animes.",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Anime deleted with success", content = @Content())
    @ApiResponse(responseCode = "404", description = "Anime not found", content = @Content())
    ResponseEntity<Void> delete(@PathVariable Long id);
}
