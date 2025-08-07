package com.eiganimes.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(@Schema(type = "string", description = "Login response token")
                            String token) {
}
