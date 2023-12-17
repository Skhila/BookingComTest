package POM.Steps;

import POM.Data.Constants;
import POM.Pages.BestFlightDealPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class BestFlightDealPageSteps {
    BestFlightDealPage bestFlightDealPage = new BestFlightDealPage();

    @Step("Validate Chosen Flight Deal's Airline Company")
    public BestFlightDealPageSteps validateBestFlightDealAirline(String expectedAirlineOne, String expectedAirlineTwo){

        String actualBestFlightOfferAirlineOne = bestFlightDealPage.bestFlightDealAirlineLogos.get(0).getAttribute("alt");
        String actualBestFlightOfferAirlineTwo = bestFlightDealPage.bestFlightDealAirlineLogos.get(1).getAttribute("alt");

        if(expectedAirlineOne.contains("AnadoluJet")){
            expectedAirlineOne = Constants.TURKISH_AIRLINES_IMAGE_ALT;
        }else if(expectedAirlineTwo.contains("AnadoluJet")){
            expectedAirlineTwo = Constants.TURKISH_AIRLINES_IMAGE_ALT;
        }

        assert actualBestFlightOfferAirlineOne != null;
        assert actualBestFlightOfferAirlineTwo != null;
        Assert.assertTrue((expectedAirlineOne.contains(actualBestFlightOfferAirlineOne)) &&
                (expectedAirlineTwo.contains(actualBestFlightOfferAirlineTwo)), "Wrong Airline Company!");

        return this;
    }
}
