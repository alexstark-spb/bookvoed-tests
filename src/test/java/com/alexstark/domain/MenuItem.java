package com.alexstark.domain;

public enum MenuItem {
    BOOKS("Книги"),
    OFFICE("Канцелярия"),
    SALES("Акции");

    private String description;

    MenuItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
