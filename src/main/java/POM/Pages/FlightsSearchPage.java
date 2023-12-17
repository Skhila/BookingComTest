package POM.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FlightsSearchPage {
    public SelenideElement finalDestinationInput = $x("//input[@placeholder=\"To?\"]"),
    finalDestinationContainer = $x("//div[text()=\"To?\"]"),
    firstSuggestedDestination = $x("//li[@role=\"option\"]");
}
