package com.riwi.course_manager.api.controller;


import com.riwi.course_manager.api.dto.request.StudentRequest;
import com.riwi.course_manager.api.dto.request.StudentUpdateRequest;
import com.riwi.course_manager.api.dto.response.StudentAllInfoResponse;
import com.riwi.course_manager.api.dto.response.StudentResponse;
import com.riwi.course_manager.infraestructure.abstractService.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/students")
@AllArgsConstructor
public class StudentController{

    private final IStudentService iStudentService;


    /*
    --------------------
     GET BY ID
    -------------------
     */
    @Operation(summary = "Get student by ID", description = "Retrieves a student by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<StudentResponse>> get(@PathVariable Long id){
        return ResponseEntity.ok(this.iStudentService.getById(id));
    }


    /*
    ----------------------
     GET ALL ROLES
    ---------------------
     */
    @Operation(
            summary = "Get all students",
            description = "Retrieve a paginated list of all students",
            parameters = {
                    @Parameter(name = "page",
                            description = "Page number",
                            schema = @Schema(
                                    type = "integer",
                                    defaultValue = "1")),
                    @Parameter(name = "size",
                            description = "Page size",
                            schema = @Schema(
                                    type = "integer",
                                    defaultValue = "10"))
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "SUCCESSFUL"),
                    @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
                    @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
                    @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
                    @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
            })
    @GetMapping
    public ResponseEntity<Page<StudentResponse>> getAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size){

        Page<StudentResponse> responses = this.iStudentService.getAll(page -1, size);
        return ResponseEntity.ok(responses);
    }

    /*
    --------------------
     CREATE STUDENT
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
    public ResponseEntity<StudentResponse> create(
            @Validated @RequestBody StudentRequest request) {
        return ResponseEntity.ok(this.iStudentService.create(request));
    }

    /*
    ----------------------
      UPDATE STUDENT
    ---------------------
     */
    // SWAGGER
    @Operation(summary = "update  student by ID",
            description = "updates a previously created student and the ID and the new modified parameters must be sent through the Path, " +
                    "value cannot be less than 1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SUCCESSFUL"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PutMapping(path = "/{id}")
    public ResponseEntity<StudentAllInfoResponse> update(
            @Validated
            @RequestBody StudentUpdateRequest request,
            @PathVariable Long id)
    {
        return ResponseEntity.ok(this.iStudentService.updateService(request, id));
    }

    /*
    -------------------------------------------
     DELETE STUDENT (DISABLE STUDENT - SOFT DELETE)
    --------------------------------------------
     */

    @Operation(summary = "Disable student by ID", description = "Disables a previously created student identified by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "401", description = "NOT AUTHORIZED"),
            @ApiResponse(responseCode = "403", description = "FORBIDDEN ACCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iStudentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
