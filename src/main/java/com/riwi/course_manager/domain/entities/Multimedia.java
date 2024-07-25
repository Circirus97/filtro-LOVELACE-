package com.riwi.course_manager.domain.entities;

import com.riwi.course_manager.utils.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "multimedia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Type type;

    @Lob
    private String url;

    private LocalDateTime created_at = LocalDateTime.now();

    private Boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lessonId", referencedColumnName = "id")
    private Lesson lesson;
}
