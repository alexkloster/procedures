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

    public static DoctorDto toDoctorDto(DoctorEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        List<StudyEntity> studies = Optional.ofNullable(entity.getStudies()).orElseGet(ArrayList::new);
        List<StudyDto> studyDtos = studies.stream().map(DtoMapper::toStudyDto).collect(Collectors.toList());

        return new DoctorDto(entity.getId(), entity.getName(), studyDtos);
    }

    public static DoctorShortDto toDoctorShortDto(DoctorEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        return new DoctorShortDto(entity.getId(), entity.getName());
    }

    public static RoomDto toRoomDto(RoomEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        List<StudyEntity> studies = Optional.ofNullable(entity.getStudies()).orElseGet(ArrayList::new);
        List<StudyDto> studyDtos = studies.stream().map(DtoMapper::toStudyDto).collect(Collectors.toList());

        return new RoomDto(entity.getId(), entity.getName(), studyDtos);
    }

    public static RoomShortDto toRoomShortDto(RoomEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        return new RoomShortDto(entity.getId(), entity.getName());
    }

    public static PatientDto toPatientDto(PatientEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }
        List<StudyEntity> studies = Optional.ofNullable(entity.getStudies()).orElseGet(ArrayList::new);
        List<StudyDto> studyDtos = studies.stream().map(DtoMapper::toStudyDto).collect(Collectors.toList());

        return new PatientDto(entity.getId(), entity.getName(), entity.getSex().getSex(), entity.getDayOfBirth(), studyDtos);
    }

    public static PatientShortDto toPatientShortDto(PatientEntity entity) {
        if(Objects.isNull(entity)) {
            return null;
        }

        return new PatientShortDto(entity.getId(), entity.getName(), entity.getSex().getSex(), entity.getDayOfBirth());
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
