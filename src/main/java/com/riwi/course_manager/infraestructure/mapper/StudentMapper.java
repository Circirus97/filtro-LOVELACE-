package com.riwi.course_manager.infraestructure.mapper;

import com.riwi.course_manager.api.dto.request.StudentRequest;
import com.riwi.course_manager.api.dto.response.StudentResponse;
import com.riwi.course_manager.domain.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "classEntity", ignore = true)
    Student studentRequestToStudent(StudentRequest request);

    StudentResponse studentToStudentResponse(Student student);
}
