package com.riwi.course_manager.infraestructure.abstractService.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadAllService<Response> {
    Page<Response> getAll(Pageable pageable); 
}
