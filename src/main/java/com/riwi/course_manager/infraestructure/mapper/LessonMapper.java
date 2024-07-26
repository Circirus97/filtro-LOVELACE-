package com.riwi.course_manager.infraestructure.mapper;



import com.riwi.course_manager.api.dto.request.LessonRequest;
import com.riwi.course_manager.api.dto.response.LessonResponse;
import com.riwi.course_manager.domain.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "multimedia", ignore = true)
    @Mapping(target = "classEntity", ignore = true)
    Lesson lessonRequestToLesson(LessonRequest request);

    LessonResponse lessonToLessonResponse(Lesson lesson);

}
