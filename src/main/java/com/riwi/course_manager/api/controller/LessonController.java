package com.riwi.course_manager.api.controller;

import com.riwi.course_manager.api.dto.request.LessonRequest;
import com.riwi.course_manager.api.dto.request.StudentUpdateRequest;
import com.riwi.course_manager.api.dto.response.LessonCompleteResponse;
import com.riwi.course_manager.api.dto.response.StudentAllInfoResponse;
import com.riwi.course_manager.api.dto.response.StudentResponse;
import com.riwi.course_manager.infraestructure.abstractService.ILessonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/lessons")
@AllArgsConstructor
public class LessonController {

    private final ILessonService iLessonService;


    /*
   --------------------
    GET BY ID
   -------------------
    */
    @Operation(summary = "Get lesson by ID", description = "Retrieves a lesson by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<LessonCompleteResponse>> get(@PathVariable Long id){
        return ResponseEntity.ok(this.iLessonService.getById(id));
    }


    /*
        --------------------
         CREATE LESSON
        -------------------
     */
    @Operation(summary = "creates a new lesson", description = "create a new lesson by entering the required data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PostMapping
    public ResponseEntity<LessonCompleteResponse> create(
            @Validated @RequestBody LessonRequest request) {
        return ResponseEntity.ok(this.iLessonService.create(request));
    }

    /*
    ----------------------
      UPDATE LESSON
    ---------------------
     */
    // SWAGGER
    @Operation(summary = "update  lesson by ID",
            description = "updates a previously created lesson and the ID and the new modified parameters must be sent through the Path, " +
                    "value cannot be less than 1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<LessonCompleteResponse> update(
            @Validated
            @RequestBody LessonRequest request,
            @PathVariable Long id)
    {
        return ResponseEntity.ok(this.iLessonService.update(id, request));
    }

    /*
    -------------------------------------------
     DELETE LESSON (DISABLE LESSON - SOFT DELETE)
    --------------------------------------------
     */

    @Operation(summary = "Disable lesson by ID", description = "Disables a previously created lesson identified by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iLessonService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
