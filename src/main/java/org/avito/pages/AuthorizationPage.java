package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {

    public SelenideElement accountLogin(String login) {
        return $x("//input[@name = '" + login + "']");
    }

    public SelenideElement accountPassword(String password) {
        return $x("//input[@name = '" + password + "']");
    }

    public SelenideElement buttonEnter = $x("//button[@class = 'css-1wq2h5i']");
    public SelenideElement messageError = $x("//p[@data-marker = 'field/error']");
}
