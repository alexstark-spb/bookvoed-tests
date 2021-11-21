package com.alexstark.helpers;

import com.github.javafaker.Faker;

public class TestData extends DriverSettings {

    public static Faker faker = new Faker();

    public static String email = credentials.email();
    public static String password = credentials.passwordForEmail();

    public static String

            //For test
            loginButton = "Войти",
            catalog = "Каталог",
            category = "Категория",
            categoryName = "Творчество и хобби",
            goToCartButton = "Перейти в корзину",
            clearCartButton = "Очистить корзину",
            shopsButton  = "Магазины",
            storeListTab = "Список магазинов",

            //For check
            pageTitle = "О «Буквоеде»",
            pageTitleBoardGames = "Настольные игры",
            authorizationText = "Зарегистрируйтесь или авторизуйтесь,",
            profileName = "Алекс",
            searchResults = "Результаты поиска с фильтрами",
            buyButton = "Купить",
            namePageCart = "Корзина",
            textCartEmpty = "Ваша корзина пуста.";
}
