package com.eiganimes.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponse(@Schema(type = "long", description = "User response id")
                           Long id,
                           @Schema(type = "string", description = "User response name")
                           String name,
                           @Schema(type = "string", description = "User response email")
                           String email) {
}
