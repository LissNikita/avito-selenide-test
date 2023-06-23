package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AudiSelectionPage {

    private final String A4 = "A4";
    private final String DRIVE = "FULL";
    private final String ANY = "Любая";
    public SelenideElement modelOfCar = $x("//span[contains(text(), 'Модель')]//following::span[contains(text(), '" + ANY + "')]");
    public SelenideElement checkBoxModel = $x("//p[text() = '"+ A4 + "']");
    public SelenideElement containerWithModels = $x("//div[@class = 'styles-gapContainer-_bE0D']");
    public SelenideElement buttonDriveOfCar = $x("//li[@title = '" + DRIVE + "']");
    public SelenideElement buttonFilterSearch = $x("//button[@data-marker = 'search-filters/submit-button']");
}
