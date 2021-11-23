package com.alexstark.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import java.time.Duration;

import static com.alexstark.helpers.TestData.pageTitle;
import static com.alexstark.helpers.TestData.searchResults;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {

    private SelenideElement
            checkPageTitle = $("#ml2_footer"),
            checkDisplayedPopUp = $("#cityDetect").$(".Fdb"),
            closePopUpRegion = $("#cityDetect").$(".Xw"),
            searchInput = $("#searchBar").$(".Qt input"),
            minPriceInput = $("#idFilterPrice-priceMin-input"),
            checkTitlePage = $("#books");

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
    public SearchPage closePopUpRegion() {
        closePopUpRegion.click();
        return this;
    }

    @Step("В поле поиска ввести значение и нажать 'Enter'")
    public SearchPage typeSearchField(String product) {
        searchInput.setValue(product).pressEnter();
        return this;
    }

    @Step("В блоке фильтров в поле с ценой min ввести значение")
    public SearchPage typeMinPriceField(String price) {
        minPriceInput.setValue(price).pressEnter();
        return this;
    }

    @Step("Проверить заголовок страницы с примененными фильтрами")
    public void checkTitlePageFilter() {
        checkTitlePage.shouldHave(text(searchResults), Duration.ofSeconds(10));
    }

}
