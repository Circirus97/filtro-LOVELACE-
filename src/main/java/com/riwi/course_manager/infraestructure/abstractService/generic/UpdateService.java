package com.riwi.course_manager.infraestructure.abstractService.generic;

public interface UpdateService<Request, Response, Id> {
    Response update(Id id, Request request);
}