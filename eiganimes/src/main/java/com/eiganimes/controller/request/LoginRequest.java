package com.eiganimes.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(@Schema(type = "string", description = "Login email request")
                           String email,
                           @Schema(type = "string", description = "Login password")
                           String password) {
}
