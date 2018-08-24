package com.procedures.service.impl;

import com.procedures.dao.repository.PatientRepository;
import com.procedures.dao.entity.PatientEntity;
import com.procedures.model.PatientDto;
import com.procedures.service.PatientService;
import com.procedures.service.mapper.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto getPatient(String name) {
        Optional<PatientEntity> optional = patientRepository.findByName(name);
        return optional.map(DtoMapper::toPatientDto).orElseThrow(() -> new RuntimeException("no patient"));
    }
}
