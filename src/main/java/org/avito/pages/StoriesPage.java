package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StoriesPage {

    private final String BALLS_FOR_BASKETBALL = "Мячи для баскетбола";
    private final String BALLS_FOR_FOOTBALL = "Мячи для футбола";

    public SelenideElement basketballStory = $x("//a[contains(text(), '" + BALLS_FOR_BASKETBALL + "')]");
    public SelenideElement footballStory = $x("//a[contains(text(), '" + BALLS_FOR_FOOTBALL + "')]");
}
