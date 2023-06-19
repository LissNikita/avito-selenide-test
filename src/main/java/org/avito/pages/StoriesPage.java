package org.avito.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StoriesPage {

    public SelenideElement basketballStory = $x("//a[contains(text(), 'Мячи для баскетбола')]");

    public SelenideElement footballStory = $x("//a[contains(text(), 'Мячи для футбола')]");
}
