package com.riwi.course_manager.infraestructure.abstractService.generic;

import java.util.Optional;

public interface ReadService<Response, Id> {
    Optional<Response> getById(Id id);
}
