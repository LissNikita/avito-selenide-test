package org.avito.steps;

import io.qameta.allure.Step;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.avito.pages.AuthorizationPage;

import static com.codeborne.selenide.Condition.text;

@Data
@Log4j2
public class AuthorizationStep {

    AuthorizationPage authorizationPage = new AuthorizationPage();

    private final String ERROR_MESSAGE = "Укажите мобильный телефон";

    @Step("Set login(unsuccessful)")
    public void setLogin(String login) {
        log.info("Set login(unsuccessful)");
        authorizationPage.accountLogin
                .sendKeys(login);
    }

    @Step("Set password(unsuccessful)")
    public void setPassword(String password) {
        log.info("Set password(unsuccessful)");
        authorizationPage.accountPassword
                .sendKeys(password);
    }

    @Step("Click on button enter")
    public void clickOnButtonEnter() {
        log.info("Click on button enter");
        authorizationPage.buttonEnter
                .click();
    }

    @Step("Check bot protection")
    public void verifyMessageError(String message) {
        log.info("Verify error message");
        authorizationPage.messageError
                .shouldHave(text(message));
    }
}
