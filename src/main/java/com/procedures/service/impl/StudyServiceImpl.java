package com.procedures.service.impl;

import com.procedures.dao.repository.StudyRepository;

import com.procedures.dao.entity.StudyEntity;
import com.procedures.model.StudyDto;
import com.procedures.service.StudyService;
import com.procedures.service.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;

    @Autowired
    public StudyServiceImpl(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    @Override
    public StudyDto getStudy(String description) {
        Optional<StudyEntity> optional = studyRepository.findByDescription(description);
        return optional.map(DtoMapper::toStudyDto).orElseThrow(()->new RuntimeException("no study"));
    }
}
