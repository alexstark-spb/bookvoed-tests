package com.alexstark.tests;

import com.alexstark.domain.MenuItem;
import com.alexstark.pages.*;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

public class BookvoedTest extends TestBase {

    private AuthorizationPage authorizationPage = new AuthorizationPage();
    private SearchPage searchPage = new SearchPage();
    private CartPage cartPage = new CartPage();
    private CatalogPage catalogPage = new CatalogPage();
    private MainPage mainPage = new MainPage();

    @Test
    @Feature("Authorization")
    @AllureId("5900")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "bookvoed", url = "https://www.bookvoed.ru/")
    @DisplayName("Авторизация с корректными данными")
    @Tag("Authorization")
    @Description("Данный UI-тест падает из-за появления капчи, при запуске на удаленном сервере")
    @Disabled()
    void authorization() {
        authorizationPage
                .openPage()
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .typeSubmit()
                .checkProfileName();
    }

    @Test
    @Feature("Authorization")
    @AllureId("5901")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "bookvoed", url = "https://www.bookvoed.ru/")
    @DisplayName("Авторизация с некорректными полями Email и Password")
    @Tag("Authorization")
    void authorizationWithIncorrectData() {
        authorizationPage
                .openPage()
                .openLoginPage()
                .typeEmailWithFaker()
                .typePasswordWithFaker()
                .typeSubmit()
                .checkProfileName();
    }

    @Feature("Search")
    @AllureId("5911")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "bookvoed", url = "https://www.bookvoed.ru/")
    @DisplayName("Поиск товаров и применение фильтрации по цене")
    @CsvSource(value = {
            "451 градус по фаренгейту, 350",
            "Дюна, 200",
            "Над пропастью во ржи, 200"

    })
    @ParameterizedTest(name = "Найти товар : {0}")
    @Tag("SearchAndCatalog")
    void findProductInSearch(String product, String price) {
        searchPage.openPage();
        if (searchPage.checkDisplayedRegion()) {
            searchPage.closePopUpRegion()
                    .typeSearchField(product)
                    .typeMinPriceField(price)
                    .checkTitlePageFilter();
        } else {
            searchPage
                    .typeSearchField(product)
                    .typeMinPriceField(price)
                    .checkTitlePageFilter();
        }
    }

    @Test
    @Feature("Catalog")
    @AllureId("5908")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.CRITICAL)

    @Link(name = "bookvoed", url = "https://www.bookvoed.ru/")
    @DisplayName("Переход по каталогу и открытие PDP-карточки товара")
    @Tag("SearchAndCatalog")
    void openCatalogAndPDP() {
        catalogPage.openPage();
        if (catalogPage.checkDisplayedRegion()) {
            catalogPage.closePopUpRegion()
                    .typeCatalogTab()
                    .typeSubdirectoryTab()
                    .typeSubcategory()
                    .typeFirstPopularGoods()
                    .switchToSecondTabBrowser()
                    .checkBuyButtonInMenu();
        } else {
            catalogPage
                    .typeCatalogTab()
                    .typeSubdirectoryTab()
                    .typeSubcategory()
                    .typeFirstPopularGoods()
                    .switchToSecondTabBrowser()
                    .checkBuyButtonInMenu();
        }
    }

    @Test
    @Feature("Cart")
    @AllureId("5903")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "bookvoed", url = "https://www.bookvoed.ru/")
    @DisplayName("Добавление товара в корзину со страницы PDP")
    @Tag("Cart")
    void addToCartFromPDP() {
        cartPage.openPage();
        if (cartPage.checkDisplayedRegion()) {
            cartPage.closePopUpRegion()
                    .typeFirstProduct()
                    .switchToSecondTabBrowser()
                    .typeCartButton()
                    .typeButtonInPopUP()
                    .checkNameCart()
                    .checkAreaGoods();
        } else {
            cartPage
                    .typeFirstProduct()
                    .switchToSecondTabBrowser()
                    .typeCartButton()
                    .typeButtonInPopUP()
                    .checkNameCart()
                    .checkAreaGoods();
        }
    }

    @Test
    @Feature("Cart")
    @AllureId("5904")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "bookvoed", url = "https://www.bookvoed.ru/")
    @DisplayName("Добавление товара в корзину со страницы PLP")
    @Tag("Cart")
    void addToCartFromPLP() {
        cartPage.openPage();
        if (cartPage.checkDisplayedRegion()) {
            cartPage.closePopUpRegion()
                    .typeCartButtonPLP()
                    .typeButtonInPopUP()
                    .checkNameCart()
                    .checkAreaGoods();
        } else {
            cartPage
                    .typeCartButtonPLP()
                    .typeButtonInPopUP()
                    .checkNameCart()
                    .checkAreaGoods();
        }
    }

    @Test
    @Feature("Cart")
    @AllureId("5905")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "bookvoed", url = "https://www.bookvoed.ru/")
    @DisplayName("Очистка корзины после добавления в неё товара")
    @Tag("Cart")
    void clearCart() {
        cartPage.openPage();
        if (cartPage.checkDisplayedRegion()) {
            cartPage.closePopUpRegion()
                    .typeFirstProduct()
                    .switchToSecondTabBrowser()
                    .typeCartButton()
                    .typeButtonInPopUP()
                    .typeButtonClear()
                    .checkCartEmpty();
        } else {
            cartPage
                    .typeFirstProduct()
                    .switchToSecondTabBrowser()
                    .typeCartButton()
                    .typeButtonInPopUP()
                    .typeButtonClear()
                    .checkCartEmpty();
        }
    }

    @Feature("MainPage")
    @AllureId("5909")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "bookvoed", url = "https://www.bookvoed.ru/")
    @DisplayName("Переход между вкладками на тапбаре главной страницы")
    @Tag("MainPage")
    @EnumSource(value = MenuItem.class)
    @ParameterizedTest(name = "Открыть вкладку : {0}")
    void openTabs(MenuItem menuItem) {
        mainPage.openPage();
        if (mainPage.checkDisplayedRegion()) {
            mainPage.closePopUpRegion()
                    .openHeaderTabs(menuItem)
                    .checkNameTab(menuItem);
        } else {
            mainPage
                    .openHeaderTabs(menuItem)
                    .checkNameTab(menuItem);
        }
    }

    @Test
    @Feature("Shops")
    @AllureId("5913")
    @Owner("Alexander Derevyanko")
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "bookvoed", url = "https://www.bookvoed.ru/")
    @DisplayName("Просмотр списка магазинов")
    @Tag("MainPage")
    void viewListOfStores() {
        mainPage.openPage();
        if (mainPage.checkDisplayedRegion()) {
            mainPage.closePopUpRegion()
                    .typeShopsTab()
                    .goToShopListTab()
                    .checkListShops();
        } else {
            mainPage
                    .typeShopsTab()
                    .goToShopListTab()
                    .checkListShops();
        }
    }
}
