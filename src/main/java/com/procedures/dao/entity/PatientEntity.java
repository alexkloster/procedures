package com.procedures.dao.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private Date dayOfBirth;

    public PatientEntity() {
    }

    public PatientEntity(String name, Sex sex, Date dayOfBirth) {
        this.name = name;
        this.sex = sex;
        this.dayOfBirth = dayOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
}
