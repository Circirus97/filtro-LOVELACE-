package com.riwi.course_manager.infraestructure.services;

import com.riwi.course_manager.api.dto.request.StudentRequest;
import com.riwi.course_manager.api.dto.request.StudentUpdateRequest;
import com.riwi.course_manager.api.dto.response.StudentAllInfoResponse;
import com.riwi.course_manager.api.dto.response.StudentResponse;
import com.riwi.course_manager.domain.entities.Class;
import com.riwi.course_manager.domain.entities.Student;
import com.riwi.course_manager.domain.repositories.ClassRepository;
import com.riwi.course_manager.domain.repositories.StudentRepository;
import com.riwi.course_manager.infraestructure.abstractService.IStudentService;
import com.riwi.course_manager.infraestructure.mapper.StudentMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class StudentService implements IStudentService {

    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;

    private final ClassRepository classRepository;


    @Override
    public StudentResponse create(StudentRequest request) {

        Student student = studentMapper.studentRequestToStudent(request);
        Class aClass = classRepository
                .findById(request.getClassId())
                .orElseThrow(() -> new RuntimeException("ID not found"));

        student.setClassEntity(aClass);
        return studentMapper.studentToStudentResponse(studentRepository.save(student));

    }

    @Override
    public void delete(Long id) {

        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));

        if (!student.getIsActive()) {
            throw new RuntimeException("The student is inactive ");
        }

        student.setIsActive(false);
        studentRepository.save(student);
    }

    @Override
    public Page<StudentResponse> getAll(int page, int size) {

        if (page < 0) page = 0;
        PageRequest pagination = PageRequest.of(page, size);

        return studentRepository.findAllByIsActiveTrue(pagination)
                .map(studentMapper::studentToStudentResponse);
    }

    @Override
    public Optional<StudentResponse> getById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));

        if (!student.getIsActive()) {
           throw new RuntimeException("The student is inactive ");
        }
        return studentRepository.findById(id)
                .map(studentMapper::studentToStudentResponse);
    }

    @Override
    public StudentAllInfoResponse updateService(StudentUpdateRequest request, Long id) {

        studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));

        Student student = studentMapper.studentUpdateRequestToStudent(request, id);

        return studentMapper.studentToStudentAllInfoResponse(this.studentRepository.save(student));
    }
}
