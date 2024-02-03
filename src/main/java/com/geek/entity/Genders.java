package com.geek.entity;

public enum Genders {
   MALE("Male"),
    FEMALE("Female");

    private final String displayValue;

    private Genders(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
