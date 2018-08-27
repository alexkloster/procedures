package com.procedures.service.impl;

import com.procedures.dao.entity.DoctorEntity;
import com.procedures.dao.repository.DoctorRepository;
import com.procedures.model.DoctorModel;
import com.procedures.service.DoctorService;
import com.procedures.service.mapper.EntityMapper;
import com.procedures.service.mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorModel getDoctor(String name) {
        Optional<DoctorEntity> optional = doctorRepository.findByName(name);
        return optional.map(ModelMapper::toDoctorModel).orElseThrow(() -> new RuntimeException("no doctor"));
    }

    @Override
    public List<DoctorModel> getAll() {
        List<DoctorEntity> doctors = doctorRepository.findAll();
        return doctors.stream().map(ModelMapper::toDoctorModel).collect(Collectors.toList());
    }

    @Override
    public DoctorModel addDoctor(DoctorModel doctor) {
        return ModelMapper.toDoctorModel(doctorRepository.save(EntityMapper.toDoctorEntity(doctor.getName())));
    }
}
