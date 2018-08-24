package com.procedures.service;

import com.procedures.model.DoctorModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DoctorService {

    DoctorModel getDoctor(String name);

    List<DoctorModel> getAll();
}
