package com.alexstark.domain;

public enum MenuItem {
    BONUSES("Бонусы"),
    BOOKS("Книги"),
    OFFICE("Канцелярия"),
    GOODSFORKIDS("Товары для детей"),
    HELLOFROMPETERSBURG("Привет из Петербурга"),
    SALES("Акции");


    private String description;

    MenuItem(String description) {

        this.description = description;
    }

    public String getDescription() {

        return description;
    }
}
