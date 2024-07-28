package com.riwi.course_manager.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonCompleteResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Boolean isActive;
    private Long classId;
    private List<MultimediaResponse> multimediaResponse;
}
