package com.procedures.service.mapper;

import com.procedures.dao.entity.PatientEntity;
import com.procedures.dao.entity.Sex;
import com.procedures.dao.entity.StudyEntity;


import java.util.Date;
import java.util.List;

public class EntityMapper {

    public static PatientEntity toPatientEntity(String name, Sex sex, Date dateOfBirth, List<StudyEntity> studies) {
        return new PatientEntity(name, sex, dateOfBirth, studies);
    }

//    public static StudyEntity toStudyEntity(String de)
}


