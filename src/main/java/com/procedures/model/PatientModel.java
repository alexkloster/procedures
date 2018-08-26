package com.procedures.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class PatientModel {

    private final Long id;

    private final String name;

    private final String sex;

    private final Date dayOfBirth;


    @JsonCreator
    public PatientModel(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("sex") String sex,
                        @JsonProperty("dayOfBirth") Date dayOfBirth) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dayOfBirth = dayOfBirth;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

}
