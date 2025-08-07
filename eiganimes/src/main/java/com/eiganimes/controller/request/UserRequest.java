package com.eiganimes.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRequest(@Schema(type = "string", description = "User name request")
                          String name,
                          @Schema(type = "string", description = "User email request")
                          String email,
                          @Schema(type = "string", description = "User password request")
                          String password) {
}
