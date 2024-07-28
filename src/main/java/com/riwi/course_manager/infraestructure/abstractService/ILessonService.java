package com.riwi.course_manager.infraestructure.abstractService;

import com.riwi.course_manager.api.dto.request.LessonRequest;
import com.riwi.course_manager.api.dto.response.LessonCompleteResponse;
import com.riwi.course_manager.infraestructure.abstractService.generic.*;

public interface ILessonService extends
        CreateService<LessonRequest, LessonCompleteResponse>,
        ReadService<LessonCompleteResponse, Long>
{

}
