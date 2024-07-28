package com.riwi.course_manager.domain.repositories;

import com.riwi.course_manager.domain.entities.Lesson;
import com.riwi.course_manager.domain.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Page<Lesson> findAllByIsActiveTrue(Pageable pageable);
}
