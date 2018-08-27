package com.procedures.dao.entity;

import java.util.Arrays;

public enum Sex {
    MALE("male"), FEMALE("female");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public static Sex getByName(String name) {
        return Arrays.stream(values()).filter(s -> s.getSex().equalsIgnoreCase(name)).findAny().get();
    }
}
