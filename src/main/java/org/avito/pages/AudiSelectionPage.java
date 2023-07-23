package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AudiSelectionPage {

    public SelenideElement checkBoxModel(String modelA4) {
        return $x("//p[text() = '" + modelA4 + "']");
    }

    public SelenideElement buttonDriveOfCar(String modelOfDrive) {
        return $x("//li[@title = '" + modelOfDrive + "']");
    }

    public SelenideElement modelOfCar(String anyModel) {
        return $x("//span[contains(text(), 'Модель')]//following::span[contains(text(), '" + anyModel + "')]");
    }

    public SelenideElement filterButton = $x("//div[@class = 'styles-box-Up_E3']");

    public SelenideElement containerWithModels = $x("//div[@class = 'styles-gapContainer-_bE0D']");
}
