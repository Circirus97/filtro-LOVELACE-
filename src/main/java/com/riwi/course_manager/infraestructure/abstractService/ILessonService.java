package com.riwi.course_manager.infraestructure.abstractService;

import com.riwi.course_manager.api.dto.request.LessonRequest;
import com.riwi.course_manager.api.dto.response.LessonResponse;
import com.riwi.course_manager.infraestructure.abstractService.generic.*;

public interface ILessonService extends
        CreateService<LessonRequest, LessonResponse>,
        ReadService<LessonRequest, Long>,
        ReadAllService<LessonResponse>,
        UpdateService<LessonRequest, LessonResponse, Long>,
        DeleteService<Long>
{
}
