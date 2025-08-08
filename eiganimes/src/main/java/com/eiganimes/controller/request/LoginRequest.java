package com.eiganimes.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(String email,
                           String password) {
}
