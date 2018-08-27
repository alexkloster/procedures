package com.procedures.service.mapper;

import com.procedures.dao.entity.*;
import com.procedures.model.DoctorModel;
import com.procedures.model.PatientModel;
import com.procedures.model.RoomModel;
import com.procedures.model.StudyModel;

import java.util.Objects;

public class DtoMapper {

    public static DoctorModel toDoctorDto(DoctorEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        return new DoctorModel(entity.getId(), entity.getName());
    }



    public static RoomModel toRoomDto(RoomEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        return new RoomModel(entity.getId(), entity.getName());
    }



    public static PatientModel toPatientDto(PatientEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }

        return new PatientModel(entity.getId(), entity.getName(), Sex.getByName(entity.getSex().getSex()), entity.getDayOfBirth());
    }


    public static StudyModel toStudyDto(StudyEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        return new StudyModel(entity.getId(), entity.getDescription(), entity.getStatus().toString(), entity.getPlannedStartTime(),
                entity.getEstimatedEndTime(), toPatientDto(entity.getPatient()), toDoctorDto(entity.getDoctor()),
                toRoomDto(entity.getRoom()));
    }


}
