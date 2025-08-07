package com.eiganimes.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CategoryResponse(@Schema(type = "long", description = "Category id response")
                               Long id,
                               @Schema(type = "string", description = "Category name response")
                               String name) {

}
