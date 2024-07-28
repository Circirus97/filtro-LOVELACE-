package com.riwi.course_manager.infraestructure.abstractService.generic;

import org.springframework.data.domain.Page;

public interface ReadAllService<Response> {
    Page<Response> getAll(int page, int size);
}
