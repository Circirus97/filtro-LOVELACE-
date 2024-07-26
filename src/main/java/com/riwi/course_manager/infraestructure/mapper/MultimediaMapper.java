package com.riwi.course_manager.infraestructure.mapper;

import com.riwi.course_manager.api.dto.request.MultimediaRequest;
import com.riwi.course_manager.api.dto.response.MultimediaResponse;
import com.riwi.course_manager.domain.entities.Multimedia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MultimediaMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lesson", ignore = true)
    Multimedia multimdediaRequestToMultimedia(MultimediaRequest request);

    MultimediaResponse multimediaToMultimediaResponse(Multimedia multimedia);

}
