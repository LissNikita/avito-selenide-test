package org.avito.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement title = $(By.xpath("//h1[@class='page-title-text-tSffu page-title-inline-zBPFx']"));

    public SelenideElement searchForm = $(By.xpath("//label"));

    public SelenideElement buttonAllCategories = $(By.xpath("//button[@data-marker = 'top-rubricator/all-categories']"));

    public SelenideElement columnPersonalThings = $(By.xpath("//p[text() = 'Личные вещи']"));

    public SelenideElement buttonManShoes = $(By.xpath("//a[@data-name = 'Мужская обувь']"));
}
