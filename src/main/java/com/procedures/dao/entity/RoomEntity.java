package com.procedures.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public RoomEntity() {
    }

    public RoomEntity(String name, List<StudyEntity> studies) {
        this.name = name;
    }

    public RoomEntity(String name) {
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
}
