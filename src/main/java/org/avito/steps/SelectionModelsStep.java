package org.avito.steps;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;
import org.avito.pages.AudiSelectionPage;

import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class SelectionModelsStep {

    AudiSelectionPage audiSelectionPage = new AudiSelectionPage();

    public void clickOnModelOfCar(){
        log.info("Click on model of car");
        audiSelectionPage.modelOfCar
                .scrollTo()
                .click();
    }

    public void clickOnCheckBoxModel(){
        log.info("Click on check box model");
        audiSelectionPage.checkBoxModel
                .scrollTo()
                .click();
    }

    public void verifyContainerWithModelsVisible(){
        log.info("Verify container with models visible");
        audiSelectionPage.containerWithModels
                .shouldBe(visible);
    }
}
