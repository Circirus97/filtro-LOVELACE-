package com.riwi.course_manager.api.dto.response;

import com.riwi.course_manager.utils.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaResponse {

    private Long id;
    private Type type;
    private String url;
    private LocalDateTime created_at;
    private Boolean isActive;
}
