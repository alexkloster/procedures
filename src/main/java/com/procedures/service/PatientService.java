package com.procedures.service;

import com.procedures.model.PatientModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface PatientService {

    PatientModel getPatient(String name);

    List<PatientModel> getAll();
}
