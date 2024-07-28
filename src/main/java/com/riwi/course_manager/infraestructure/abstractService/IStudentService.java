package com.riwi.course_manager.infraestructure.abstractService;

import com.riwi.course_manager.api.dto.request.StudentRequest;
import com.riwi.course_manager.api.dto.request.StudentUpdateRequest;
import com.riwi.course_manager.api.dto.response.StudentAllInfoResponse;
import com.riwi.course_manager.api.dto.response.StudentResponse;
import com.riwi.course_manager.infraestructure.abstractService.generic.CreateService;
import com.riwi.course_manager.infraestructure.abstractService.generic.DeleteService;
import com.riwi.course_manager.infraestructure.abstractService.generic.ReadAllService;
import com.riwi.course_manager.infraestructure.abstractService.generic.ReadService;

public interface IStudentService extends
        CreateService<StudentRequest, StudentResponse>,
        ReadService<StudentResponse, Long>,
        ReadAllService<StudentResponse>,
        DeleteService<Long>
{

    StudentAllInfoResponse updateService(StudentUpdateRequest request, Long id);
}
