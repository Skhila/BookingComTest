package POM.Steps;

import POM.Pages.HotelOfferCardSection;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HotelOfferCardSectionSteps {
    public SoftAssert softAssert = new SoftAssert();

    HotelOfferCardSection propertyCardSection = new HotelOfferCardSection();
    @Step("Validate Hotels' Ascending Prices")
    public HotelOfferCardSectionSteps validateHotelsPrices() {
        ElementsCollection hotelsPrices = propertyCardSection.hotelsPrices;

        for (int i = 0; i < hotelsPrices.size()-1; i++){
            double currentHotelPrice = Double.parseDouble(hotelsPrices.get(i).getText().split(" ")[1].replace(",", ""));
            double nextHotelPrice = Double.parseDouble(hotelsPrices.get(i+1).getText().split(" ")[1].replace(",", ""));

            softAssert.assertTrue(currentHotelPrice <= nextHotelPrice, "Wrong Hotel Price!");
        }

        return this;
    }

    @Step("Validate Hotels' Locations")
    public HotelOfferCardSectionSteps validateHotelsLocations(String expectedLocation){
        ElementsCollection hotelsLocations = propertyCardSection.hotelsALocations;

        for (SelenideElement currentHotelLocation : hotelsLocations) {
            softAssert.assertTrue(currentHotelLocation.getText().contains(expectedLocation) , "Wrong Hotel Location!!!");
        }

        return this;
    }

    @Step("Validate That Hotels Review Scores Are In Desired Range")
    public HotelOfferCardSectionSteps validateHotelsRating(double expectedHotelLowestReviewScore){
        ElementsCollection hotelsReviewScores = propertyCardSection.hotelsReviewScores;

        for (SelenideElement currentHotelReviewScore : hotelsReviewScores) {

            softAssert.assertTrue(Double.parseDouble(currentHotelReviewScore.getText()) >= expectedHotelLowestReviewScore , "Wrong Hotel Review Score!!!");
        }
        return this;
    }
}
