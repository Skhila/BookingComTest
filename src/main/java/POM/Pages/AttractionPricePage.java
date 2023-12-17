package POM.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AttractionPricePage {
    public SelenideElement
            getNameOfAttractionElement2 =
                    $x("//h2[@class='af8fbdf136']"),
            totalPrice =
                    $x("//div[@data-testid='price-breakdown-total']");


}
