package POM.Pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AttractionsContentPage {

    public SelenideElement
            mostPopularBtn =
                $x("//span[text() = 'Most popular']");


    public ElementsCollection
             offeredAttractionList =
                $x("//div[@data-testid ='sr-list']")
                    .$$x(".//div[contains(@class,'b817090550')]");


}
