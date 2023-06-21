package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {

    public SelenideElement accountLogin = $x("//input[@name = 'login']");

    public SelenideElement accountPassword = $x("//input[@name = 'password']");

    public SelenideElement buttonEnter = $x("//button[@class = 'css-1wq2h5i']");

    public SelenideElement messageError = $x("//p[@data-marker = 'field/error']");
}
