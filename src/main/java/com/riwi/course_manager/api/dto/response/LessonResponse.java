package com.riwi.course_manager.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private Boolean isActive;
}
