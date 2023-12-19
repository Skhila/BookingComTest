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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
    HotelPageSteps hotelPageSteps;
    HotelReservationPersonalDetailsPageSteps hotelReservationPersonalDetailsPageSteps;
    CompleteBookingPageSteps completeBookingPageSteps;
    BookingConfirmationPageSteps bookingConfirmationPageSteps;
    LanguageChangePageSteps languageChangePageSteps;
    AttractionsPageSteps attractionsPageSteps;
    AttractionsContentPageSteps attractionsContentPageSteps;
    AttractionsDetailsPageSteps attractionsDetailsPageSteps;
    AttractionPricePageSteps attractionPricePageSteps;

    @BeforeClass
    public void initiateStepClasses() {
        mainPageSteps = new MainPageSteps();
        hotelsPageSteps = new HotelsPageSteps();
        datePickerSteps = new DatePickerSteps();
        flightsSearchPageSteps = new FlightsSearchPageSteps();
        headerSectionSteps = new HeaderSectionSteps();
        commonElementsSteps = new CommonElementsSteps();
        bestFlightDealPageSteps = new BestFlightDealPageSteps();
        hotelPageSteps = new HotelPageSteps();
        hotelReservationPersonalDetailsPageSteps = new HotelReservationPersonalDetailsPageSteps();
        completeBookingPageSteps = new CompleteBookingPageSteps();
        bookingConfirmationPageSteps = new BookingConfirmationPageSteps();
        languageChangePageSteps = new LanguageChangePageSteps();
        attractionsPageSteps = new AttractionsPageSteps();
        attractionsContentPageSteps = new AttractionsContentPageSteps();
        attractionsDetailsPageSteps = new AttractionsDetailsPageSteps();
        attractionPricePageSteps = new AttractionPricePageSteps();
    }

    @Test(description = "Trending Locations Test")
    @Feature("Hotels Rating/Price Order Test")
    @Story("Test Trending Location's Hotels")
    @Description("This Test Opens First Trending Location's Hotel Offers, Sorts With Price and Filters With Review Score," +
            "Finally Validates That Price Is Correctly Ordered, Review Scores Are In Range " +
            "and All Offers Are From The First Trending Location")
    public void trendingLocationsTest() {
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

    @Test(description = "Reservation Test")
    @Feature("Reservation Functionality Test")
    @Story("Test Hotel Reservation functionality")
    @Description("This test enters a desired destination into the main page's search bar, then selects desired dates" +
            "from the date picker. It searches for the hotel, clicks on the first search result, and switches to the newly" +
            "opened tab. The test validates the name of the hotel, clicks on the 'Reserve' button, and fills in the fields" +
            "for name, surname, email, and phone number before clicking the 'Next' button. Finally, it clicks on the" +
            "'Complete Booking' button and validates that the reservation was successful.")
    public void hotelReservationTest() {
        HelperSteps.openWebsite(Constants.URL);
        mainPageSteps
                .closeSignInSuggestion()
                .fillInSearchBar(Constants.STAY_DESTINATION)
                .chooseResult(0, Constants.STAY_DESTINATION_VALIDATION)
                .clickDatePicker();
        datePickerSteps
                .clickFlexibleButton()
                .chooseStayDuration(0)
                .selectMonth(0)
                .clickSelectDateButton();
        mainPageSteps
                .clickSearchButton();

        hotelsPageSteps
                .clickOnHotelsAvailabilityButton(0);
        hotelsPageSteps
                .switchTab();
        hotelPageSteps
                .validateHotelName(Constants.STAY_DESTINATION_VALIDATION)
                .reserveRoom();
        hotelReservationPersonalDetailsPageSteps
                .fillInName(Constants.FIRST_NAME)
                .fillInSurname(Constants.LAST_NAME)
                .fillInEmail(hotelReservationPersonalDetailsPageSteps.generateUniqueEmail())
                .fillInPhone(Constants.PHONE_NUMBER)
                .clickNext();
        completeBookingPageSteps
                .clickCompleteBookingButton();
        bookingConfirmationPageSteps
                .validateConfirmationMessage();
    }

    @Test(description = "Language Change Test")
    @Feature("Language Change Functionality")
    @Story("Verify The Functionality Of Changing The Language")
    @Description("This Test Close PopUp Window, Then Clicks on Language Button And  Clicks German Language Button" +
            "After It Test Makes Flag Validation and Asserts That German Flag Is Shown Correctly," +
            " Then Test Using Rest Assured And With The Help Of It Finds Outs What Language Is The Given Text from" +
            "And Finally It Validates That The Language Has Been Changed Correctly ")
    public void languageChangeTest() {
        HelperSteps.openWebsite(Constants.URL);
        mainPageSteps.closeSignInSuggestion()
                .clickOnLanguageButton();
        languageChangePageSteps.clickOnGermanBtn();
        mainPageSteps.flagValidation()
                .restStep(mainPageSteps.getGermanText())
                .languageValidation();
    }

    @Test(description = "Attractions test ")
    @Feature("Booking attractions functionality test")
    @Story("Validate name of attraction and price while booking")
    @Description("This Test Close PopUp Window, Then Clicks on Attractions Button input paris in Location and click search Button" +
            "After It Test clicks Most Popular Button and choose first offered attraction , scroll down " +
            " select  available date , choose one ticket for adult and save price and name of attraction." +
            "finally it clicks on next button and validate price and name of attraction")
    public void attractionsTest() {
        HelperSteps.openWebsite(Constants.URL);
        mainPageSteps
                .closeSignInSuggestion();
        headerSectionSteps
                .goToAttractionsPage();

        attractionsPageSteps
                .inputLocation(Constants.ATTRACTION_LOCATION)
                .clickLocation();

        commonElementsSteps
                .clickSearchButton();

        attractionsContentPageSteps
                .clickMostPopularBtn()
                .clickFirstOfferedElement();

        HelperSteps
                .switchToNewWindow();

        attractionsDetailsPageSteps
                .getTextOfAttraction()
                .scrollDown()
                .clickShowMoreBtn()
                .clickAvailableDate()
                .chooseTicketAmountForAdults(1)
                .clickNextBtn();

        attractionPricePageSteps
                .validateNameOfAttraction(attractionsDetailsPageSteps.nameOfAttraction)
                .validatePrice(attractionsDetailsPageSteps.price);

        attractionPricePageSteps
                .softAssert.assertAll();
    }
}
