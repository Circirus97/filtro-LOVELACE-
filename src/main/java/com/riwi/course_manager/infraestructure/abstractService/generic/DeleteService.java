package com.riwi.course_manager.infraestructure.abstractService.generic;

public interface DeleteService<Id> {
    void delete(Id id);
}
