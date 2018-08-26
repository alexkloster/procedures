package com.procedures.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class StudyDto {

    private final Long id;

    private final String description;

    private final String status;

    private final Date plannedStartTime;

    private final Date estimatedEndTime;

    private final PatientModel patient;

    private final DoctorModel doctor;

    private final RoomModel room;

    @JsonCreator
    public StudyDto(@JsonProperty("id") Long id, @JsonProperty("description") String description,
                    @JsonProperty("status") String status, @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date plannedStartTime,
                    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date estimatedEndTime, @JsonProperty("patient") PatientModel patient,
                    @JsonProperty("doctor") DoctorModel doctor, @JsonProperty("room") RoomModel room) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.plannedStartTime = plannedStartTime;
        this.estimatedEndTime = estimatedEndTime;
        this.patient = patient;
        this.doctor = doctor;
        this.room = room;
    }


    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public Date getPlannedStartTime() {
        return plannedStartTime;
    }

    public Date getEstimatedEndTime() {
        return estimatedEndTime;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public RoomModel getRoom() {
        return room;
    }
}


