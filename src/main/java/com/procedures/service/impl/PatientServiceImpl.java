package com.procedures.service.impl;

import com.procedures.dao.entity.PatientEntity;
import com.procedures.dao.repository.PatientRepository;
import com.procedures.model.PatientModel;
import com.procedures.service.PatientService;
import com.procedures.service.mapper.DtoMapper;
import com.procedures.service.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientModel getPatient(String name) {
        Optional<PatientEntity> optional = patientRepository.findByName(name);
        return optional.map(DtoMapper::toPatientDto).orElseThrow(() -> new RuntimeException("no patient"));
    }

    @Override
    public List<PatientModel> getAll() {
        List<PatientEntity> patients = patientRepository.findAll();
        return patients.stream().map(DtoMapper::toPatientDto).collect(Collectors.toList());
    }

    @Override
    public PatientModel addPatient(PatientModel patient) {
        return DtoMapper.toPatientDto(patientRepository.save(EntityMapper.toPatientEntity(patient.getName(), patient.getSex(), patient.getDayOfBirth())));

    }
}
