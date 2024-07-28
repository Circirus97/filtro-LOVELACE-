package com.riwi.course_manager.infraestructure.mapper;

import com.riwi.course_manager.api.dto.request.StudentRequest;
import com.riwi.course_manager.api.dto.request.StudentUpdateRequest;
import com.riwi.course_manager.api.dto.response.StudentAllInfoResponse;
import com.riwi.course_manager.api.dto.response.StudentResponse;
import com.riwi.course_manager.domain.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "classEntity", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    Student studentRequestToStudent(StudentRequest request);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "classEntity.id", source = "request.classId")
    Student studentUpdateRequestToStudent(StudentUpdateRequest request, Long id);

    StudentResponse studentToStudentResponse(Student student);
    StudentAllInfoResponse studentToStudentAllInfoResponse(Student student);
}
