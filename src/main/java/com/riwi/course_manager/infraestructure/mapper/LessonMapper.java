package com.riwi.course_manager.infraestructure.mapper;



import com.riwi.course_manager.api.dto.request.LessonRequest;
import com.riwi.course_manager.api.dto.response.LessonCompleteResponse;
import com.riwi.course_manager.api.dto.response.MultimediaResponse;
import com.riwi.course_manager.domain.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "multimedia", ignore = true)
    @Mapping(target = "classEntity", ignore = true)
    Lesson lessonRequestToLesson(LessonRequest request);

    @Mapping(target = "classId", source = "lesson.classEntity.id")
    LessonCompleteResponse lessonToLessonCompleteResponse(Lesson lesson, List<MultimediaResponse> multimediaResponse);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateLessonFromRequest(LessonRequest request, @MappingTarget Lesson lesson);
}
