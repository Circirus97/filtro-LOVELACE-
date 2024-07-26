package com.riwi.course_manager.infraestructure.mapper;

import com.riwi.course_manager.api.dto.request.ClassRequest;
import com.riwi.course_manager.api.dto.response.ClassResponse;
import com.riwi.course_manager.domain.entities.Class;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    Class classRequestToClass(ClassRequest request);

    ClassResponse classToClassResponse(Class Class);

}
