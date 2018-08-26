package com.procedures.dao.entity;

public enum Sex {
    MALE("male"), FEMALE("female");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
