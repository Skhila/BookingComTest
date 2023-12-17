package POM.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class FlightDealCardSection {

    public ElementsCollection dealsBookingSites = $$("span.name-only-text"),
            bestFlightDealAirlines = $$x("//div[@class = \"best-flights-list-results\"]//div[contains(@class,  \"Flights-Results-ResultInfo\")]//img");

    public SelenideElement bestFlightDealViewDealButton = $x("//a[@aria-label='View Deal']");
}
