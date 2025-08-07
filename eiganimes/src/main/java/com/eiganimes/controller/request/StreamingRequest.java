package com.eiganimes.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(@NotEmpty(message = "Streaming name is required")
                               @Schema(type = "string", description = "Streaming name request.")
                               String name) {
}
