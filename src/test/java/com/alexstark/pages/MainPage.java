package com.alexstark.pages;

import com.alexstark.domain.MenuItem;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.alexstark.helpers.TestData.*;
import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement
            checkPageTitle = $("#ml2_footer"),
            checkDisplayedPopUp = $("#cityDetect").$(".Xw"),
            closePopUpRegion = $("#cityDetect").$(".Xw"),
            typeShopsTab = $("#up .wib").$(byText(shopsButton)),
            goToShopListTab = $("#shops").$(byText(storeListTab)),
            checkListShops = $("#shops_addresses_content");

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
    public MainPage closePopUpRegion() {
        closePopUpRegion.click();
        return this;
    }

    @Step("Открыть вкладку на таб-баре")
    public MainPage openHeaderTabs(MenuItem menuItem) {
        $$(".Qib a").find(Condition.text(menuItem.getDescription())).click();
        return this;
    }

    @Step("Нажать на вкладку 'Магазины'")
    public MainPage typeShopsTab() {
        typeShopsTab.click();
        return this;
    }

    @Step("Перейти во вкладку 'Список магазинов'")
    public MainPage goToShopListTab() {
        goToShopListTab.click();
        return this;
    }

    @Step("Проверить что название вкладки совпадает с названием из класса 'MenuItem'")
    public void checkNameTab(MenuItem menuItem) {

        $$(".Qib a").shouldHave(itemWithText(menuItem.getDescription()));
    }

    @Step("Проверить что на странице появились адреса магазинов")
    public void checkListShops() {

        checkListShops.shouldBe(visible);
    }
}
