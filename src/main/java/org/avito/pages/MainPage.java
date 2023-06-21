package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public SelenideElement title = $x("//h1[@class='page-title-text-tSffu page-title-inline-zBPFx']");

    public SelenideElement searchForm = $x("//label");

    public SelenideElement buttonAllCategories = $x("//button[@data-marker = 'top-rubricator/all-categories']");

    public SelenideElement columnPersonalThings = $x("//p[text() = 'Личные вещи']");

    public SelenideElement buttonManShoes = $x("//a[@data-name = 'Мужская обувь']");

    public SelenideElement loginButton = $x("//a[@class = 'index-nav-link-muv1u index-login-NV2z_']");

    public SelenideElement buttonStories = $x("//div[@data-id = '984']");

    public SelenideElement buttonElectronics = $x("//img[@alt = 'Электроника']");
}
