package com.procedures.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "doctor_id")
    private List<StudyEntity> studies;

    public DoctorEntity() {
    }

    public DoctorEntity(String name, List<StudyEntity> studies) {
        this.name = name;
        this.studies = studies;
    }

    public DoctorEntity(String name) {
        this.name = name;
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

    public List<StudyEntity> getStudies() {
        return studies;
    }

    public void setStudies(List<StudyEntity> studies) {
        this.studies = studies;
    }
}
