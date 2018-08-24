package com.procedures.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DoctorModel {

    private final Long id;

    private final String name;

    private final List<StudyDto> studies;

    @JsonCreator
    public DoctorModel(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("studies") List<StudyDto> studies) {
        this.id = id;
        this.name = name;
        this.studies = studies;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<StudyDto> getStudies() {
        return studies;
    }
}
