package com.procedures.service;

import com.procedures.model.DoctorDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DoctorService {

    DoctorDto getDoctor(String name);

    List<DoctorDto> getAll();
}
