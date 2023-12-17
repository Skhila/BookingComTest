package POM.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class MainPage {
    public SelenideElement firstTrendingLocation = $x("//div[@data-testid = \"destination-postcards-firstrow\"]//a[2]"),
            firstTrendingLocationName = firstTrendingLocation.$x(".//div[contains(@data-testid, \"destination-postcard\")]/div/div"),
            closeSignInButton = $x("//button[@aria-label=\"Dismiss sign-in info.\"]");

    public SelenideElement
            hotelSearchBar = $x("//input[@aria-label='Where are you going?']"),
            closePopup = $("button[aria-label = 'Dismiss sign-in info.']"),
            dateSelector = $x("//div[@data-testid='searchbox-dates-container']/button"),
            dateFlexibleButton = $x("//button[@aria-controls='flexible-searchboxdatepicker']"),
            selectDateButton = $x("//span[contains(text(), 'Select dates')]/parent::button"),
            searchButton = $x("//button[@type='submit']");

    public ElementsCollection
            searchAutocompleteResults = $$x("//div[@data-testid='autocomplete-results-options']//div[@role='button']"),
            monthSelectionButtons = $$x("//div[@id='flexible-searchboxdatepicker']//ul/li/label"),
            stayDurationRadioButtons = $$x("//div[@data-testid='flexible-dates-day']");
}
