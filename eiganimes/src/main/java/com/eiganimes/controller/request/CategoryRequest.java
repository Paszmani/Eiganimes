package com.eiganimes.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;


public record CategoryRequest(@NotEmpty(message = "Category name is required") String name) {
}
