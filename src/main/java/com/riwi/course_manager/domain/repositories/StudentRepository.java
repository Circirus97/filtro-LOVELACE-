package com.riwi.course_manager.domain.repositories;

import com.riwi.course_manager.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
