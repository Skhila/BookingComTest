package POM.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class BestFlightDealPage {
    public ElementsCollection bestFlightDealAirlineLogos = $$x("//img[contains(@src, \"airlines_logo\")]");
}
