package POM.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class MainPage {
    public SelenideElement
            hotelSearchBar = $x("//input[@aria-label='Where are you going?']"),
            dateSelector = $x("//div[@data-testid='searchbox-dates-container']/button"),
            dateFlexibleButton = $x("//button[@aria-controls='flexible-searchboxdatepicker']"),
            searchButton = $x("//button[@type='submit']"),
            firstTrendingLocation = $x("//div[@data-testid = \"destination-postcards-firstrow\"]//a[2]"),
            firstTrendingLocationName = firstTrendingLocation.$x(".//div[contains(@data-testid, \"destination-postcard\")]/div/div"),
            closeSignInButton = $x("//button[@aria-label=\"Dismiss sign-in info.\"]"),
            languageBtn = $x("//button[@data-testid=\"header-language-picker-trigger\"]"),
            flag = $x("//button[@data-testid='header-language-picker-trigger']//child::img"),
            germanText = $x("//header//h1");

    public ElementsCollection
            searchAutocompleteResults = $$x("//div[@data-testid='autocomplete-results-options']//div[@role='button']");

            

}
