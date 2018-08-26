package com.procedures.service;

import com.procedures.model.StudyDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StudyService {

    StudyDto getStudy(String description);

    List<StudyDto> getAll();

    StudyDto saveStudy(StudyDto study);
}
