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

    private final PatientShortDto patient;

    private final DoctorShortDto doctor;

    private final RoomShortDto room;

    @JsonCreator
    public StudyDto(@JsonProperty("id") Long id, @JsonProperty("description") String description,
                    @JsonProperty("status") String status, @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date plannedStartTime,
                    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date estimatedEndTime, @JsonProperty("patient") PatientShortDto patient,
                    @JsonProperty("doctor") DoctorShortDto doctor, @JsonProperty("room") RoomShortDto room) {
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

    public PatientShortDto getPatient() {
        return patient;
    }

    public DoctorShortDto getDoctor() {
        return doctor;
    }

    public RoomShortDto getRoom() {
        return room;
    }
}


