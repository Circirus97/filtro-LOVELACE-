package com.riwi.course_manager.infraestructure.services;

import com.riwi.course_manager.api.dto.request.LessonRequest;
import com.riwi.course_manager.api.dto.response.LessonResponse;
import com.riwi.course_manager.api.dto.response.MultimediaResponse;
import com.riwi.course_manager.domain.entities.Class;
import com.riwi.course_manager.domain.entities.Lesson;
import com.riwi.course_manager.domain.entities.Multimedia;
import com.riwi.course_manager.domain.entities.Student;
import com.riwi.course_manager.domain.repositories.LessonRepository;
import com.riwi.course_manager.domain.repositories.MultimediaRepository;
import com.riwi.course_manager.infraestructure.abstractService.ILessonService;
import com.riwi.course_manager.infraestructure.mapper.LessonMapper;
import com.riwi.course_manager.infraestructure.mapper.MultimediaMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class LessonService implements ILessonService {

    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;
    private final MultimediaRepository multimediaRepository;
    private final MultimediaMapper multimediaMapper;

    @Override
    public LessonResponse create(LessonRequest request) {

        Lesson lesson = lessonMapper.lessonRequestToLesson(request);
        Lesson lessonSave = lessonRepository.save(lesson);
        List<MultimediaResponse> multimediaResponses = request.getMultimediaRequests()
                .stream()
                .map(multimediaRequest -> multimediaMapper.multimdediaRequestToMultimedia(multimediaRequest, lessonSave.getId()))
                .map(multimediaRepository::save)
                .map(multimediaMapper::multimediaToMultimediaResponse)
                .toList();


        return  lessonMapper.lessonToLessonResponse(lessonSave, multimediaResponses);
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Page<LessonResponse> getAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<LessonRequest> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public LessonResponse update(Long aLong, LessonRequest request) {
        return null;
    }
}
