package POM.Steps;

import POM.Pages.FlightsSearchPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class FlightsSearchPageSteps {

    FlightsSearchPage flightsSearchPage = new FlightsSearchPage();

    @Step("Click On Final Destination Input Container")
    public FlightsSearchPageSteps clickOnFinalDestinationContainer(){
        flightsSearchPage.finalDestinationContainer.click();
        return this;
    }

    @Step("Write Desired Final Destination")
    public FlightsSearchPageSteps writeFinalDestination(String finalDestinationName){
        flightsSearchPage.finalDestinationInput.sendKeys(finalDestinationName);
        return this;
    }

    @Step("Choose First Suggested Final Destination")
    public FlightsSearchPageSteps chooseFirstDestination(){
        flightsSearchPage.firstSuggestedDestination.should(Condition.appear).hover().click();
        return this;
    }
}
