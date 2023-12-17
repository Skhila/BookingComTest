package POM.Steps;

import POM.Pages.AttractionPricePage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

public class AttractionPricePageSteps {
    AttractionPricePage attractionPricePage = new AttractionPricePage();
    public SoftAssert softAssert = new SoftAssert();

    @Step("validate name of attraction")
    public AttractionPricePageSteps validateNameOfAttraction(String expectedNameOfAttraction) {
        softAssert.assertEquals(expectedNameOfAttraction, attractionPricePage.getNameOfAttractionElement2.getText());
        return this;
    }

    @Step("validate Price of Tickets")
    public AttractionPricePageSteps validatePrice(Double expectedPriceOfAttraction) {
        String numericPart = attractionPricePage.totalPrice.getText().split(" ")[1];
        double result = Double.parseDouble(numericPart);
        softAssert.assertEquals(expectedPriceOfAttraction, result);
        return this;
    }
}
