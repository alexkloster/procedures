package com.procedures.dao.repository;

import com.procedures.dao.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository <DoctorEntity, Long> {

    @Override
    Optional<DoctorEntity> findById(Long aLong);

    Optional<DoctorEntity> findByName(String name);
}
