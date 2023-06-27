package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StoriesPage {

    public SelenideElement basketballStory(String ballForBasketball) {
        return $x("//a[contains(text(), '" + ballForBasketball + "')]");
    }

    public SelenideElement footballStory(String ballForFootball) {
        return $x("//a[contains(text(), '" + ballForFootball + "')]");
    }
}
