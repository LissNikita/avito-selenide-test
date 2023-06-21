package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AudiSelectionPage {

    public SelenideElement modelOfCar = $x("//span[contains(text(), 'Модель')]//following::span[contains(text(), 'Любая')]");

    public SelenideElement checkBoxModel = $x("//p[text() = 'A4']");

    public SelenideElement containerWithModels = $x("//div[@class = 'styles-gapContainer-_bE0D']");

    public SelenideElement buttonDriveOfCar = $x("//li[@title = 'полный']");

    public SelenideElement buttonFilterSearch = $x("//button[@data-marker = 'search-filters/submit-button']");
}
