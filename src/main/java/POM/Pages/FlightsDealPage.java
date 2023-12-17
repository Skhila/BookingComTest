package POM.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class FlightsDealPage {
    public ElementsCollection showMoreButtons = $$x("//span[text() = \"Show more\"]//parent::a"),
    bookingSitesFilterCheckboxes = $$x("//div[@aria-label=\"Booking sites\"]//input");

    public SelenideElement oneStopFilterCheckbox = $x("//label[text()=\"1 stop\"]//preceding-sibling::input"),
    twoOrMoreStopsFilterCheckbox = $x("//label[text()=\"2+ stops\"]//preceding-sibling::input"),
    showMoreButton = showMoreButtons.get(1);

}
