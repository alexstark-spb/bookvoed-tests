package com.alexstark.domain;

public enum MenuItem {
    BONUSES("Бонусы"),
    BOOKS("Книги"),
    OFFICE("Канцелярия"),
    GOODS_FOR_KIDS("Товары для детей"),
    HELLO_FROM_PETERSBURG("Привет из Петербурга"),
    SALES("Акции");

    private String description;

    MenuItem(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
