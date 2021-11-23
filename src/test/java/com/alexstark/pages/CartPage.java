package com.alexstark.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.alexstark.helpers.TestData.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {

    private SelenideElement
            checkPageTitleBoardGames = $(".od .ny"),
            checkDisplayedPopUp = $("#cityDetect").$(".Xw"),
            closePopUpRegion = $("#cityDetect").$(".Xw"),
            typeFirstProduct = $("#retailrocket").$("ul li", 0),
            typeCartButton = $("#book_buttons").$("[itemprop='offers']"),
            typeCartButtonPLP = $("#books .KD .ks a"),
            typeButton = $("#bottom_action-bac").$(byText(goToCartButton)),
            typeButtonClear = $("#order2").$(byText(clearCartButton)),
            checkNameCart = $("#CabMenu").$("ul li a"),
            checkCartEmpty = $("#order2"),
            checkAreaGoods = $("#order2-cart");

    @Step("Открыть страницу 'www.bookvoed.ru/books?genre=453' с тематикой 'Настольные игры'")
    public void openPage() {
        open("/books?genre=453");
        checkPageTitleBoardGames.shouldHave(text(pageTitleBoardGames));
    }

    @Step("Проверить отображение поп-ап окна 'Где вы находитесь?'")
    public boolean checkDisplayedRegion() {
        checkDisplayedPopUp.isDisplayed();
        return true;
    }

    @Step("Закрыть поп-ап окно 'Где вы находитесь?'")
    public CartPage closePopUpRegion() {
        closePopUpRegion.click();
        return this;
    }

    @Step("На странице выбрать первый товар в разделе 'Популярные товары в категории'")
    public CartPage typeFirstProduct() {
        typeFirstProduct.click();
        return this;
    }

    @Step("Перейти во вторую вкладку браузера и остаться на ней")
    public CartPage switchToSecondTabBrowser() {
        Selenide.switchTo().window(1);
        return this;
    }

    @Step("Нажать на кнопку 'Купить'")
    public CartPage typeCartButton() {
        typeCartButton.click();
        return this;
    }

    @Step("Нажать на кнопку 'Купить'")
    public CartPage typeCartButtonPLP() {
        typeCartButtonPLP.click();
        return this;
    }

    @Step("Нажать кнопку 'Перейти в корзину' во всплывающем окне 'Товар в корзине'")
    public CartPage typeButtonInPopUP() {
        typeButton.click();
        return this;
    }

    @Step("Нажать на кнопку 'Очистить корзину'")
    public CartPage typeButtonClear() {
        typeButtonClear.click();
        return this;
    }

    @Step("Проверить что на странице в левом меню есть название 'Корзина'")
    public CartPage checkNameCart() {
        checkNameCart.shouldHave(text(namePageCart));
        return this;
    }

    @Step("Проверить что на странице есть текст 'Ваша корзина пуста.'")
    public void checkCartEmpty() {
        checkCartEmpty.shouldHave(text(textCartEmpty));
    }

    @Step("Проверить что на странице есть список с добавленными товарами")
    public void checkAreaGoods() {
        checkAreaGoods.shouldBe(visible);
    }
}
