package com.procedures.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.procedures.dao.entity.Sex;

import java.util.Date;

public class PatientModel {

    private final Long id;

    private final String name;

    private final Sex sex;

    private final Date dayOfBirth;


    @JsonCreator
    public PatientModel(@JsonProperty("id") Long id, @JsonProperty("name") String name, @JsonProperty("sex") Sex sex,
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

    public Sex getSex() {
        return sex;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

}
