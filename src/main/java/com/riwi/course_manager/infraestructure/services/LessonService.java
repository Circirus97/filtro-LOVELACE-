package com.riwi.course_manager.infraestructure.services;

import com.riwi.course_manager.api.dto.request.LessonRequest;
import com.riwi.course_manager.api.dto.response.LessonCompleteResponse;
import com.riwi.course_manager.api.dto.response.MultimediaResponse;
import com.riwi.course_manager.domain.entities.Class;
import com.riwi.course_manager.domain.entities.Lesson;
import com.riwi.course_manager.domain.entities.Multimedia;
import com.riwi.course_manager.domain.entities.Student;
import com.riwi.course_manager.domain.repositories.ClassRepository;
import com.riwi.course_manager.domain.repositories.LessonRepository;
import com.riwi.course_manager.domain.repositories.MultimediaRepository;
import com.riwi.course_manager.infraestructure.abstractService.ILessonService;
import com.riwi.course_manager.infraestructure.mapper.LessonMapper;
import com.riwi.course_manager.infraestructure.mapper.MultimediaMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class LessonService implements ILessonService {

    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;
    private final MultimediaRepository multimediaRepository;
    private final MultimediaMapper multimediaMapper;
    private final ClassRepository classRepository;


    @Override
    public LessonCompleteResponse create(LessonRequest request) {

        Lesson lesson = lessonMapper.lessonRequestToLesson(request);
        Lesson lessonSave = lessonRepository.save(lesson);
        List<MultimediaResponse> multimediaResponses = request.getMultimediaRequests()
                .stream()
                .map(multimediaRequest -> multimediaMapper.multimdediaRequestToMultimedia(multimediaRequest, lessonSave.getId()))
                .map(multimediaRepository::save)
                .map(multimediaMapper::multimediaToMultimediaResponse)
                .toList();

        Class aClass = classRepository
                .findById(request.getClassId())
                .orElseThrow(() -> new RuntimeException("ID not found"));

        lessonSave.setClassEntity(aClass);


        return  lessonMapper.lessonToLessonCompleteResponse(lessonSave, multimediaResponses);
    }

    /*@Override
    public void delete(Long id) {

        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));

        if (!lesson.getIsActive()) {
            throw new RuntimeException("The lesson is inactive ");
        }

        lesson.setIsActive(false);
        lessonRepository.save(lesson);
    }*/

    @Override
    public Optional<LessonCompleteResponse> getById(Long id) {

        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));

        if (!lesson.getIsActive()) {
            throw new RuntimeException("The lesson is inactive ");
        }

        List<MultimediaResponse> multimediaResponses = multimediaRepository.findByLessonId(id)
                .stream()
                .map(multimediaMapper::multimediaToMultimediaResponse)
                .toList();

        LessonCompleteResponse lessonCompleteResponse = lessonMapper.lessonToLessonCompleteResponse(lesson, multimediaResponses);

        return Optional.of(lessonCompleteResponse);
    }

    /*@Override
    public LessonCompleteResponse update(Long id, LessonRequest request) {
        // Buscar la lección existente por su ID
        Lesson existingLesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));

        // Actualizar la lección existente con los datos del request
        lessonMapper.updateLessonFromRequest(request, existingLesson);

        // Eliminar las multimedia existentes asociadas con la lección
        List<Multimedia> existingMultimedia = multimediaRepository.findByLessonId(id);
        multimediaRepository.deleteAll(existingMultimedia);

        // Guardar las nuevas multimedia asociadas con la lección
        List<MultimediaResponse> multimediaResponses = request.getMultimediaRequests()
                .stream()
                .map(multimediaRequest -> multimediaMapper.multimdediaRequestToMultimedia(multimediaRequest, existingLesson.getId()))
                .map(multimediaRepository::save)
                .map(multimediaMapper::multimediaToMultimediaResponse)
                .toList();

        // Guardar la lección actualizada
        Lesson updatedLesson = lessonRepository.save(existingLesson);

        // Devolver la respuesta completa de la lección
        return lessonMapper.lessonToLessonCompleteResponse(updatedLesson, multimediaResponses);
    }*/

    /*@Override
    public LessonCompleteResponse update(Long id, LessonRequest request) {

        lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found"));

        Lesson lesson = lessonMapper.lessonRequestToLesson(request);

        List<MultimediaResponse> multimediaResponses = multimediaRepository.findByLessonId(id)
                .stream()
                .map(multimediaMapper::multimediaToMultimediaResponse)
                .toList();

        LessonCompleteResponse lessonCompleteResponse =
                lessonMapper.lessonToLessonCompleteResponse(lesson, multimediaResponses);


        return this.lessonRepository.save(lessonCompleteResponse);
    }*/
}
