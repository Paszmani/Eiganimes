package com.eiganimes.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponse(Long id,
                           String name,
                           String email) {
}
