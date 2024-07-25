package com.riwi.course_manager.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRequest {


    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Content is required")
    private String description;

}
