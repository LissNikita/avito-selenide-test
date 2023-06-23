package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {

    private final String LOGIN = "login";
    private final String PASSWORD = "password";
    public SelenideElement accountLogin = $x("//input[@name = '" + LOGIN + "']");
    public SelenideElement accountPassword = $x("//input[@name = '" + PASSWORD + "']");
    public SelenideElement buttonEnter = $x("//button[@class = 'css-1wq2h5i']");
    public SelenideElement messageError = $x("//p[@data-marker = 'field/error']");
}
