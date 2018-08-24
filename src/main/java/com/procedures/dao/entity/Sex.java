package com.procedures.dao.entity;

public enum Sex {
    MEN("men"), WOM("woman");

    private final String sex;

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
