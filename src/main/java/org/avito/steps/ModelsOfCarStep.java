package org.avito.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.avito.pages.AudiSelectionPage;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class ModelsOfCarStep {

    AudiSelectionPage audiSelectionPage = new AudiSelectionPage();

    private final String A4 = "A4";
    private final String DRIVE = "полный";
    private final String ANY = "Любая";

    @Step("Click on model of car")
    public void clickOnModelOfCar() {
        log.info("Click on model of car");
        audiSelectionPage.modelOfCar(ANY)
                .scrollTo()
                .click();
    }

    @Step("Click on check box model 'A4'")
    public void clickOnCheckBoxModel() {
        log.info("Click on check box model 'A4'");
        audiSelectionPage.checkBoxModel(A4)
                .scrollTo()
                .click();
    }

    @Step("Verify container with models visible")
    public void verifyContainerWithModelsVisible() {
        log.info("Verify container with models visible");
        audiSelectionPage.containerWithModels
                .shouldBe(visible);
    }

    @Step("Click on button driver of car 'FULL'")
    public void clickOnButtonDriverOfCar() {
        log.info("Click on button driver of car 'FULL'");
        audiSelectionPage.buttonDriveOfCar(DRIVE)
                .scrollTo()
                .click();
    }

    @Step("Click on button filter search")
    public void clickOnButtonFilterSearch() {
        log.info("Click on button filter search");
        audiSelectionPage.buttonDriveOfCar(DRIVE)
                .click();
    }
}
