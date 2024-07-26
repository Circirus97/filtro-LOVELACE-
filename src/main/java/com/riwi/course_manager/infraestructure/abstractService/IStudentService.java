package com.riwi.course_manager.infraestructure.abstractService;

import com.riwi.course_manager.api.dto.request.StudentRequest;
import com.riwi.course_manager.api.dto.response.StudentResponse;
import com.riwi.course_manager.infraestructure.abstractService.generic.*;

public interface IStudentService extends
        CreateService<StudentRequest, StudentResponse>,
        ReadService<StudentRequest, Long>,
        ReadAllService<StudentResponse>,
        UpdateService<StudentRequest, StudentResponse, Long>,
        DeleteService<Long>
{

}
