package com.riwi.course_manager.api.dto.request;

import com.riwi.course_manager.utils.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaRequest {

    private Type type;

    @NotBlank(message = "URL is required")
    private String url;

}
