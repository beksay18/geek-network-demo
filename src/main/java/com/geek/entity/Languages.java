package com.geek.entity;

public enum Languages {
   ENGLISH("English"),
    FRENCH("French"),
    TURKISH("Turkish"),
    SPANISH("Spanish"),
    RUSSIAN("Russian"),
    ITALIAN("Italian"),
    JAPANESE("Japanese"),
    CHINESE("Chinese");

    private final String displayValue;

    private Languages(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
