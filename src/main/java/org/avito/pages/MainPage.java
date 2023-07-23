package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public SelenideElement columnPersonalThings(String ownThings) {
        return $x("//p[text() = '" + ownThings + "']");
    }

    public SelenideElement buttonManShoes(String manShoes) {
        return $x("//a[@data-name = '" + manShoes + "']");
    }

    public SelenideElement title = $x("//h1[@class='page-title-text-tSffu page-title-inline-zBPFx']");
    public SelenideElement searchForm = $x("//label");
    public SelenideElement buttonAllCategories = $x("//button[@data-marker = 'top-rubricator/all-categories']");
    public SelenideElement loginButton = $x("//a[@class = 'index-nav-link-muv1u index-login-NV2z_']");
    public SelenideElement buttonStories = $x("//div[contains(text(), 'Помогаем «ЛизаАлерт»')]");
}
