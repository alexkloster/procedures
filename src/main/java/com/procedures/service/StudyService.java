package com.procedures.service;

import com.procedures.model.StudyDto;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudyService {

    StudyDto getStudy(String description);
}
