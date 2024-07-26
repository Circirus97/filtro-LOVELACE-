package com.riwi.course_manager.infraestructure.abstractService;

import com.riwi.course_manager.api.dto.request.MultimediaRequest;
import com.riwi.course_manager.api.dto.response.MultimediaResponse;
import com.riwi.course_manager.infraestructure.abstractService.generic.*;

public interface IMultimediaService extends
        CreateService<MultimediaRequest, MultimediaResponse>,
        ReadService<MultimediaRequest, Long>,
        ReadAllService<MultimediaResponse>,
        UpdateService<MultimediaRequest, MultimediaResponse, Long>,
        DeleteService<Long>

{
}
