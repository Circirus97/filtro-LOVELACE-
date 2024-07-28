package com.riwi.course_manager.api.controller;

import com.riwi.course_manager.api.dto.request.LessonRequest;
import com.riwi.course_manager.api.dto.request.StudentRequest;
import com.riwi.course_manager.api.dto.response.LessonResponse;
import com.riwi.course_manager.api.dto.response.StudentResponse;
import com.riwi.course_manager.infraestructure.abstractService.ILessonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/lessons")
@AllArgsConstructor
public class LessonController {

    private final ILessonService iLessonService;


    /*
        --------------------
         CREATE LESSON
        -------------------
     */
    @Operation(summary = "creates a new student", description = "create a new student by entering the required data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<LessonResponse> create(
            @Validated @RequestBody LessonRequest request) {
        return ResponseEntity.ok(this.iLessonService.create(request));
    }

}
