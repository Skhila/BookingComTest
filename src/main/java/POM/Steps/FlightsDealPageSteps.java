package POM.Steps;

import POM.Data.Constants;
import POM.Pages.FlightsDealPage;
import POM.Steps.CommonSteps.HelperSteps;
import com.codeborne.selenide.*;
import io.qameta.allure.Step;



public class FlightsDealPageSteps {
    FlightsDealPage flightsDealPage = new FlightsDealPage();

    @Step("Uncheck One Stop Filter")
    public FlightsDealPageSteps uncheckOneStopFilterCheckbox(){
        HelperSteps.clickElementUsingJSExecutor(flightsDealPage.oneStopFilterCheckbox);
        return this;
    }

    @Step("Uncheck Two Or More Stops Filter")
    public FlightsDealPageSteps uncheckTwoOrMoreStopsFilterCheckbox(){
        HelperSteps.clickElementUsingJSExecutor(flightsDealPage.twoOrMoreStopsFilterCheckbox);
        return this;
    }

    @Step("Scroll And Click On Show More Button")
    public FlightsDealPageSteps clickOnShowMoreButton(){
        flightsDealPage.showMoreButton.scrollIntoView(true).click();
        return this;
    }

    @Step("Uncheck All Booking Sites Filters Except Booking.com")
    public FlightsDealPageSteps checkOnlyBookingComFilter(){
        ElementsCollection bookingSitesFilterCheckboxes = flightsDealPage.bookingSitesFilterCheckboxes;

        for (SelenideElement currentBookingSiteFilterCheckbox : bookingSitesFilterCheckboxes) {
            if(!currentBookingSiteFilterCheckbox.getAttribute("name").equals(Constants.EXPECTED_BOOKING_SITE_FILTER_CHECKBOX_NAME) && currentBookingSiteFilterCheckbox.is(Condition.checked)){
                HelperSteps.clickElementUsingJSExecutor(currentBookingSiteFilterCheckbox);
                currentBookingSiteFilterCheckbox.shouldBe(Condition.not(Condition.checked));
            }
            else if(currentBookingSiteFilterCheckbox.getAttribute("name").equals(Constants.EXPECTED_BOOKING_SITE_FILTER_CHECKBOX_NAME) && !currentBookingSiteFilterCheckbox.is(Condition.checked)){
                HelperSteps.clickElementUsingJSExecutor(currentBookingSiteFilterCheckbox);
            }
        }

        return this;
    }

}
