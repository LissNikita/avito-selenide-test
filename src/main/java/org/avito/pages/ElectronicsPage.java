package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ElectronicsPage {

    private final String iPhone = "iPhone 11";

    public SelenideElement iPhone11 = $x("//span[text() = '" + iPhone + "']");
}
