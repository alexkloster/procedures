package com.procedures.service.mapper;

import com.procedures.dao.entity.DoctorEntity;
import com.procedures.dao.entity.PatientEntity;
import com.procedures.dao.entity.RoomEntity;
import com.procedures.dao.entity.StudyEntity;
import com.procedures.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class DtoMapper {

    public static DoctorModel toDoctorDto(DoctorEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        List<StudyEntity> studies = Optional.ofNullable(entity.getStudies()).orElseGet(ArrayList::new);
        List<StudyDto> studyDtos = studies.stream().map(DtoMapper::toStudyDto).collect(Collectors.toList());

        return new DoctorModel(entity.getId(), entity.getName(), studyDtos);
    }

    public static DoctorShortModel toDoctorShortDto(DoctorEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        return new DoctorShortModel(entity.getId(), entity.getName());
    }

    public static RoomModel toRoomDto(RoomEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        List<StudyEntity> studies = Optional.ofNullable(entity.getStudies()).orElseGet(ArrayList::new);
        List<StudyDto> studyDtos = studies.stream().map(DtoMapper::toStudyDto).collect(Collectors.toList());

        return new RoomModel(entity.getId(), entity.getName(), studyDtos);
    }

    public static RoomShortModel toRoomShortDto(RoomEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        return new RoomShortModel(entity.getId(), entity.getName());
    }

    public static PatientModel toPatientDto(PatientEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        List<StudyEntity> studies = Optional.ofNullable(entity.getStudies()).orElseGet(ArrayList::new);
        List<StudyDto> studyDtos = studies.stream().map(DtoMapper::toStudyDto).collect(Collectors.toList());

        return new PatientModel(entity.getId(), entity.getName(), entity.getSex().getSex(), entity.getDayOfBirth(), studyDtos);
    }

    public static PatientShortModel toPatientShortDto(PatientEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }

        return new PatientShortModel(entity.getId(), entity.getName(), entity.getSex().getSex(), entity.getDayOfBirth());
    }

    public static StudyDto toStudyDto(StudyEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        return new StudyDto(entity.getId(), entity.getDescription(), entity.getStatus().toString(), entity.getPlannedStartTime(),
                entity.getEstimatedEndTime(), toPatientShortDto(entity.getPatient()), toDoctorShortDto(entity.getDoctor()),
                toRoomShortDto(entity.getRoom()));
    }


}
