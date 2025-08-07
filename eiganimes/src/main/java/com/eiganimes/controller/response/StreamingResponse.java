package com.eiganimes.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record StreamingResponse(@Schema(type = "long", description = "Streaming id response")
                                Long id,
                                @Schema(type = "string", description = "Streaming name response")
                                String name) {
}
