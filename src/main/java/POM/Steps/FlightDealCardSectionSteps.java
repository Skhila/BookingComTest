package POM.Steps;

import POM.Data.Constants;
import POM.Pages.FlightDealCardSection;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;


public class FlightDealCardSectionSteps {
    FlightDealCardSection flightDealCardSection = new FlightDealCardSection();

    public String bestFlightDealAirlineNameFirst;
    public String bestFlightDealAirlineNameSecond;

    @Step("Validate Flight Deals' Booking site (Should Be Booking.com)")
    public FlightDealCardSectionSteps validateFlightDealsBookingSites(){
        ElementsCollection flightDealsBookingSites = flightDealCardSection.dealsBookingSites;

        for (SelenideElement currentFlightDealBookingSite : flightDealsBookingSites) {
            Assert.assertEquals(currentFlightDealBookingSite.getText().trim(), Constants.EXPECTED_FLIGHT_DEAL_BOOKING_SITE_NAME);
        }
        return this;
    }

    @Step("Get The Best Flight First Airline")
    public FlightDealCardSectionSteps getBestFlightDealAirlineNameFirst(){
        bestFlightDealAirlineNameFirst = flightDealCardSection.bestFlightDealAirlines.get(0).getAttribute("alt");
        return this;
    }

    @Step("Get The Best Flight Second Airline")
    public FlightDealCardSectionSteps getBestFlightDealAirlineNameSecond(){
        bestFlightDealAirlineNameSecond = flightDealCardSection.bestFlightDealAirlines.get(1).getAttribute("alt");
        return this;
    }

    @Step("Click On The Best Airline")
    public FlightDealCardSectionSteps clickOnBestFlightDeal(){
        flightDealCardSection.bestFlightDealViewDealButton.scrollIntoView(true).click();
        return this;
    }
}
