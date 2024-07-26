package com.riwi.course_manager.domain.repositories;

import com.riwi.course_manager.domain.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long>{
}
