package POM.Steps.CommonSteps;

import POM.Pages.CommonPages.HeaderSection;
import POM.Steps.MainPageSteps;
import io.qameta.allure.Step;

public class HeaderSectionSteps {

    HeaderSection headerSection = new HeaderSection();

    @Step("Go To Flights Page")
    public HeaderSectionSteps goToFlightsPage(){
        headerSection.flightsBtn.click();
        return this;
    }

    @Step("Go To Attractions Page")
    public HeaderSectionSteps goToAttractionsPage(){
        headerSection.attractionsMenuBtn.click();
        return this;
    }
}
