package com.procedures.service.mapper;

import com.procedures.dao.entity.*;



import java.util.Date;

public class EntityMapper {

    public static PatientEntity toPatientEntity(String name, Sex sex, Date dateOfBirth) {
        return new PatientEntity(name, sex, dateOfBirth);
    }

    public static DoctorEntity toDoctorEntity(String doctorName) {
        return new DoctorEntity(doctorName);
    }

    public static RoomEntity toRoomEntity(String name) {
        return new RoomEntity(name);
    }

//    public static StudyEntity toStudyEntity(String description, Status status, Date startTime, Date estimatedTime,
//                                            PatientEntity patient, DoctorEntity doctor, RoomEntity roo) {
//        return new StudyEntity(description, status, startTime, estimatedTime, patient, doctor);
//    }

}


