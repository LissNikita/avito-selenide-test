package org.avito.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AudiSelectionPage {

    public SelenideElement title = $(By.xpath("//h1[@class='page-title-text-tSffu page-title-inline-zBPFx']"));

    public SelenideElement modelOfCar = $(By.xpath("//span[contains(text(), 'Модель')]//following::span[contains(text(), 'Любая')]"));

    public SelenideElement checkBoxModel = $(By.xpath("//p[text() = 'A4']"));

    public SelenideElement containerWithModels = $(By.xpath("//div[@class = 'styles-gapContainer-_bE0D']"));

    public SelenideElement buttonDriveOfCar = $(By.xpath("//li[@title = 'полный']"));

    public SelenideElement buttonFilterSearch = $(By.xpath("//button[@data-marker = 'search-filters/submit-button']"));
}
