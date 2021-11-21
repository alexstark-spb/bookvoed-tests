package com.alexstark.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.alexstark.helpers.TestData.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationPage {

    private SelenideElement
            checkPageTitle = $("#ml2_footer"),
            topProfile = $("#h_cab"),
            checkAuthorizationText = $(".eV"),
            emailInput = $("#auth_form-login-input"),
            passwordInput = $("#auth_form-password-input"),
            enterButton = $("#auth_form").$(byText(loginButton)),
            checkProfileName = $("[data-gtm='top_menu_cab']");

    @Step("Открыть страницу www.bookvoed.ru")
    public AuthorizationPage openPage() {
        open("/");
        checkPageTitle.shouldHave(text(pageTitle));
        return this;
    }

    @Step("Открыть страницу авторизации")
    public AuthorizationPage openLoginPage() {
        topProfile.click();
        checkAuthorizationText.shouldHave(text(authorizationText));
        return this;
    }

    @Step("В поле 'Логин / E-mail / Телефон' ввести корректный e-mail")
    public AuthorizationPage typeEmail() {
        emailInput.setValue(email);
        return this;
    }

    @Step("В поле 'Логин / E-mail / Телефон' ввести некорректный e-mail")
    public AuthorizationPage typeEmailWithFaker() {
        emailInput.setValue(faker.internet().emailAddress());
        return this;
    }

    @Step("В поле 'Пароль' ввести корректный пароль")
    public AuthorizationPage typePassword() {
        passwordInput.setValue(password);
        return this;
    }

    @Step("В поле 'Пароль' ввести некорректный пароль")
    public AuthorizationPage typePasswordWithFaker() {
        passwordInput.setValue(faker.internet().password());
        return this;
    }

    @Step("Нажать на кнопку 'Войти'")
    public AuthorizationPage typeSubmit() {
        enterButton.click();
        return this;
    }

    @Step("Проверить имя авторизованного пользователя")
    public void checkProfileName() {

        checkProfileName.shouldHave(text(profileName), Duration.ofSeconds(10));
    }
}
