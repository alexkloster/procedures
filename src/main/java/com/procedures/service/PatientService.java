package com.procedures.service;

import com.procedures.model.PatientModel;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface PatientService {

    PatientModel getPatient(String name);
}
