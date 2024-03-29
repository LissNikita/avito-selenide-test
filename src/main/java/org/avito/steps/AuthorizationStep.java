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

    private final String INVALID_PHONE_MESSAGE = "Укажите мобильный телефон";
    private final String LOGIN = "login";
    private final String PASSWORD = "password";

    @Step("Set login")
    public void setLogin(String login) {
        log.info("Set login");
        authorizationPage.accountLogin(LOGIN)
                .sendKeys(login);
    }

    @Step("Set password(unsuccessful)")
    public void setPassword(String password) {
        log.info("Set password(unsuccessful)");
        authorizationPage.accountPassword(PASSWORD)
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
