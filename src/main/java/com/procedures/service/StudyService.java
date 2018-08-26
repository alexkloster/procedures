package com.procedures.service;

import com.procedures.model.StudyModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StudyService {

    StudyModel getStudy(String description);

    List<StudyModel> getAll();

    StudyModel saveStudy(StudyModel study);

    StudyModel getById(Long id);
}
