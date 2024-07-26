package com.riwi.course_manager.infraestructure.abstractService.generic;

public interface CreateService<Request, Response> {
    Response create(Request request);
}
