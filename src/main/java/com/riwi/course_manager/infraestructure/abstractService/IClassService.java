package com.riwi.course_manager.infraestructure.abstractService;

import com.riwi.course_manager.api.dto.request.ClassRequest;
import com.riwi.course_manager.api.dto.response.ClassResponse;
import com.riwi.course_manager.infraestructure.abstractService.generic.*;

public interface IClassService extends
        CreateService<ClassRequest, ClassResponse>,
        ReadService<ClassRequest, Long>,
        ReadAllService<ClassResponse>,
        UpdateService<ClassRequest, ClassResponse, Long>,
        DeleteService<Long>
{
}
