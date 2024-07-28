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
public class StudentAllInfoResponse {

    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private Boolean isActive;
    private ClassResponse classEntity;

}
