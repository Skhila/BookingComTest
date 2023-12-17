package Tests;

import POM.Data.Constants;
import POM.Steps.*;
import POM.Steps.CommonSteps.CommonElementsSteps;
import POM.Steps.CommonSteps.DatePickerSteps;
import POM.Steps.CommonSteps.HeaderSectionSteps;
import POM.Steps.CommonSteps.HelperSteps;
import TestsConfig.BaseConfigSelenide;
import TestsConfig.TestListeners.SelenideListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.URL;

import static com.codeborne.selenide.Selenide.open;

@Listeners(SelenideListener.class)
@Epic("Booking.com Functionality Test")
public class BookingTests extends BaseConfigSelenide {
    MainPageSteps mainPageSteps;
    HotelsPageSteps hotelsPageSteps;
    HotelOfferCardSectionSteps hotelOfferCardSectionSteps;
    DatePickerSteps datePickerSteps;
    FlightsSearchPageSteps flightsSearchPageSteps;
    FlightsDealPageSteps flightsDealPageSteps;
    HeaderSectionSteps headerSectionSteps;
    CommonElementsSteps commonElementsSteps;
    FlightDealCardSectionSteps flightDealCardSectionSteps;
    BestFlightDealPageSteps bestFlightDealPageSteps;
    LanguageChangePageSteps languageChangePageSteps;

    @BeforeClass
    public void initiateStepClasses(){
        mainPageSteps = new MainPageSteps();
        hotelsPageSteps = new HotelsPageSteps();
        datePickerSteps = new DatePickerSteps();
        flightsSearchPageSteps = new FlightsSearchPageSteps();
        headerSectionSteps = new HeaderSectionSteps();
        commonElementsSteps = new CommonElementsSteps();
        bestFlightDealPageSteps = new BestFlightDealPageSteps();
        languageChangePageSteps = new LanguageChangePageSteps();
    }

    @Test(description = "Trending Locations Test")
    @Feature("Hotels Rating/Price Order Test")
    @Story("Test Trending Location's Hotels")
    @Description("This Test Opens First Trending Location's Hotel Offers, Sorts With Price and Filters With Review Score," +
            "Finally Validates That Price Is Correctly Ordered, Review Scores Are In Range " +
            "and All Offers Are From The First Trending Location")
    public void trendingLocationsTest(){
        HelperSteps.openWebsite(Constants.URL);
        String firstTrendingLocationName = mainPageSteps.getFirstTrendingLocationName();

        mainPageSteps
                .closeSignInSuggestion()
                .clickOnFirstTrendingLocation();

        datePickerSteps
                .doubleClickDatePickerTrigger()
                .clickFlexibleButton()
                .chooseStayDuration(0)
                .selectMonth(0)
                .clickSelectDateButton();

        commonElementsSteps.clickSearchButton();

        hotelsPageSteps
                .clickSorterDropdown()
                .chooseSortWithPriceOption()
                .selectFilterWithRating();

        hotelOfferCardSectionSteps = new HotelOfferCardSectionSteps();
        hotelOfferCardSectionSteps
                .validateHotelsPrices()
                .validateHotelsLocations(firstTrendingLocationName)
                .validateHotelsRating(Constants.EXPECTED_HOTEL_LOWEST_REVIEW_SCORE);

        hotelOfferCardSectionSteps.softAssert.assertAll();
    }

    @Test(description = "Flights Test")
    @Feature("Flights Functionality Test")
    @Story("Test Flight Offers Page")
    @Description("This Test Opens Flights Page, Writes Desired Destination Location And Searches Flights. Then Filters Flights" +
            "To See Only NonStop Flight Offers, Unchecks All Booking Site Filters Except Booking.com. Validates That All The Offers" +
            "Are From Booking.com, saves The Best Flight Deal's First And Second Airlines, Clicks On The Deal And Validates Airline Companies")
    public void flightsTest() {
        HelperSteps.openWebsite(Constants.URL);
        mainPageSteps.closeSignInSuggestion();

        headerSectionSteps.goToFlightsPage();

        flightsSearchPageSteps
                .clickOnFinalDestinationContainer()
                .writeFinalDestination(Constants.FLIGHT_FINAL_DESTINATION_NAME)
                .chooseFirstDestination();

        commonElementsSteps.clickSearchButton();

        flightsDealPageSteps = new FlightsDealPageSteps();
        flightsDealPageSteps
                .uncheckOneStopFilterCheckbox()
                .uncheckTwoOrMoreStopsFilterCheckbox()
                .clickOnShowMoreButton()
                .checkOnlyBookingComFilter();

        flightDealCardSectionSteps = new FlightDealCardSectionSteps();
        flightDealCardSectionSteps
                .validateFlightDealsBookingSites()
                .getBestFlightDealAirlineNameFirst()
                .getBestFlightDealAirlineNameSecond()
                .clickOnBestFlightDeal();

        HelperSteps.switchToNewWindow();

        bestFlightDealPageSteps
                .validateBestFlightDealAirline(flightDealCardSectionSteps.bestFlightDealAirlineNameFirst
                        , flightDealCardSectionSteps.bestFlightDealAirlineNameSecond);
    }

    @Test(description = "Language Change Test")
    @Feature("Language Change Functionality")
    @Story("Verify The Functionality Of Changing The Language")
    @Description("This Test Close PopUp Window, Then Clicks on Language Button And  Clicks German Language Button" +
            "After It Test Makes Flag Validation and Asserts That German Flag Is Shown Correctly," +
            " Then Test Using Rest Assured And With The Help Of It Finds Outs What Language Is The Given Text from" +
            "And Finally It Validates That The Language Has Been Changed Correctly ")
    public void LanguageChangeTest(){
        HelperSteps.openWebsite(Constants.URL);
        mainPageSteps.closeSignInSuggestion()
                .clickOnLanguageButton();
        languageChangePageSteps.clickOnGermanBtn();
        mainPageSteps.flagValidation()
                .restStep(mainPageSteps.getGermanText())
                .languageValidation();

    }

}
