package com.eiganimes.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;


public record CategoryRequest(@Schema(type = "string", description = "Category name request")
                              @NotEmpty(message = "Category name is required") String name) {
}
