package com.procedures.dao.repository;

import com.procedures.dao.entity.StudyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudyRepository extends JpaRepository<StudyEntity, Long> {

    @Override
    Optional<StudyEntity> findById(Long aLong);

    Optional<StudyEntity> findByDescription(String description);
}
