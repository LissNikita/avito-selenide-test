package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StoriesPage {

    public SelenideElement basketballStory(String helpLizaAlert) {
        return $x("//h1[contains(text(), '" + helpLizaAlert + "')]");
    }

    public SelenideElement footballStory(String whoIsLookingForNearYou) {
        return $x("//h1[contains(text(), '" + whoIsLookingForNearYou + "')]");
    }
}
