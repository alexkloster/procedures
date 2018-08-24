package com.procedures.service;

import com.procedures.model.PatientDto;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface PatientService {

    PatientDto getPatient(String name);
}
