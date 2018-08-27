package com.procedures.service.impl;

import com.procedures.dao.entity.*;
import com.procedures.dao.repository.DoctorRepository;
import com.procedures.dao.repository.PatientRepository;
import com.procedures.dao.repository.RoomRepository;
import com.procedures.dao.repository.StudyRepository;
import com.procedures.model.StudyModel;
import com.procedures.service.StudyService;
import com.procedures.service.mapper.EntityMapper;
import com.procedures.service.mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudyServiceImpl implements StudyService {

    private final StudyRepository studyRepository;

    private final DoctorRepository doctorRepository;

    private final PatientRepository patientRepository;

    private final RoomRepository roomRepository;

    @Autowired
    public StudyServiceImpl(StudyRepository studyRepository, DoctorRepository doctorRepository, PatientRepository patientRepository, RoomRepository roomRepository) {
        this.studyRepository = studyRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.roomRepository = roomRepository;
    }


    @Override
    public StudyModel getStudy(String description) {
        Optional<StudyEntity> optional = studyRepository.findByDescription(description);
        return optional.map(ModelMapper::toStudyModel).orElseThrow(() -> new RuntimeException("no study"));
    }

    @Override
    public List<StudyModel> getAll() {
        List<StudyEntity> studyEntities = studyRepository.findAll();
        return studyEntities.stream().map(ModelMapper::toStudyModel).collect(Collectors.toList());
    }

    @Override
    public StudyModel saveStudy(StudyModel study) {
        DoctorEntity doctor = doctorRepository.findById(study.getDoctor().getId()).orElseThrow(() -> new RuntimeException("no doctor with id: " + study.getDoctor().getId()));
        PatientEntity patient = patientRepository.findById(study.getPatient().getId()).orElseThrow(() -> new RuntimeException("no patient with id: " + study.getPatient().getId()));
        RoomEntity room = roomRepository.findById(study.getRoom().getId()).orElseThrow(() -> new RuntimeException("no room with id: " + study.getRoom().getId()));
        StudyEntity studyEntity = EntityMapper.toStudyEntity(study.getDescription(), Status.PLANNED, study.getPlannedStartTime(), study.getEstimatedEndTime(), room, patient, doctor);
        StudyEntity result = studyRepository.save(studyEntity);
        return ModelMapper.toStudyModel(result);
    }

    @Override
    public StudyModel getById(Long id) {
        Optional<StudyEntity> optional = studyRepository.findById(id);
        return optional.map(ModelMapper::toStudyModel).orElseThrow(() -> new RuntimeException("no study with id: " + id));
    }
}
