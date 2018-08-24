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

    private final PatientShortModel patient;

    private final DoctorShortModel doctor;

    private final RoomShortModel room;

    @JsonCreator
    public StudyDto(@JsonProperty("id") Long id, @JsonProperty("description") String description,
                    @JsonProperty("status") String status, @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date plannedStartTime,
                    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date estimatedEndTime, @JsonProperty("patient") PatientShortModel patient,
                    @JsonProperty("doctor") DoctorShortModel doctor, @JsonProperty("room") RoomShortModel room) {
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

    public PatientShortModel getPatient() {
        return patient;
    }

    public DoctorShortModel getDoctor() {
        return doctor;
    }

    public RoomShortModel getRoom() {
        return room;
    }
}


