package org.avito.utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class FindPrice {

    public static SelenideElement findCheapestPrise() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ElementsCollection productPrices = $$(By.xpath("//strong[@class = 'styles-module-root-LIAav']"));

        double lowestPrice = Double.MAX_VALUE;
        SelenideElement cheapestProduct = null;

        for (SelenideElement productPrice : productPrices) {
            SelenideElement product = productPrice.closest("h3[contains(@itemprop, 'name')]");
            System.out.println(product.getText());
            String priceText = productPrice.getText().replace(" ₽", "").replace(" ", "");
            System.out.println(priceText);
            double price = Double.parseDouble(priceText);

            if (price < lowestPrice) {
                lowestPrice = price;
                cheapestProduct = product;
            }
        }
        return cheapestProduct;
    }
}
