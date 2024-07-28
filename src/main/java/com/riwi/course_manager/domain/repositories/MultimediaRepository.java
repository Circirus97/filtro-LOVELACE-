package com.riwi.course_manager.domain.repositories;

import com.riwi.course_manager.domain.entities.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {

    List<Multimedia> findByLessonId(Long lessonId);
}
