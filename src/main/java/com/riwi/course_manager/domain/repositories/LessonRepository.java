package com.riwi.course_manager.domain.repositories;

import com.riwi.course_manager.domain.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
