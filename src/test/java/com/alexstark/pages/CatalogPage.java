package com.alexstark.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.alexstark.helpers.TestData.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CatalogPage {

    private SelenideElement
            checkPageTitle = $("#ml2_footer"),
            checkDisplayedPopUp = $("#cityDetect").$(".Fdb"),
            closePopUpRegion = $("#cityDetect").$(".Xw"),
            typeCatalog = $(".Qib").$(byText(catalog)),
            typeSubdirectory = $("#c_sidebar").$("#c_sidebar-catalog").$(byText(categoryName)),
            typeSubcategory = $(byText(category)).parent().$("ul li", 4).$("a"),
            typeFirstProduct = $("#retailrocket").$("ul li", 0),
            checkBuyButton = $("#book_buttons").$("[itemprop='offers']");

    @Step("Открыть страницу www.bookvoed.ru")
    public void openPage() {
        open("/");
        checkPageTitle.shouldHave(text(pageTitle));
    }

    @Step("Проверить отображение поп-ап окна 'Где вы находитесь?'")
    public boolean checkDisplayedRegion() {
        checkDisplayedPopUp.isDisplayed();
        return true;
    }

    @Step("Закрыть поп-ап окно 'Где вы находитесь?'")
    public CatalogPage closePopUpRegion() {
        closePopUpRegion.click();
        return this;
    }

    @Step("Нажать на вкладку 'Каталог'")
    public CatalogPage typeCatalogTab() {
        typeCatalog.click();
        return this;
    }

    @Step("Нажать на подвкладку 'Творчество и Хобби'")
    public CatalogPage typeSubdirectoryTab() {
        typeSubdirectory.click();
        return this;
    }

    @Step("В меню выбрать подкатегорию 'Товары для хобби'")
    public CatalogPage typeSubcategory() {
        typeSubcategory.click();
        return this;
    }

    @Step("На странице выбрать первый товар в разделе 'Популярные товары в категории'")
    public CatalogPage typeFirstPopularGoods() {
        typeFirstProduct.click();
        return this;
    }

    @Step("Перейти во вторую вкладку браузера и остаться на ней")
    public CatalogPage switchToSecondTabBrowser() {
        Selenide.switchTo().window(1);
        return this;
    }

    @Step("Проверить что на странице в правом меню есть кнопка 'Купить'")
    public void checkBuyButtonInMenu() {
        checkBuyButton.shouldHave(text(buyButton), Duration.ofSeconds(10));
    }
}

