package com.eiganimes.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRequest(String name,
                          String email,
                          String password) {
}
