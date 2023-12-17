package POM.Steps;

import POM.Pages.CompleteBookingPage;
import io.qameta.allure.Step;

public class CompleteBookingPageSteps {
    CompleteBookingPage completeBookingPage = new CompleteBookingPage();
    @Step
    public CompleteBookingPageSteps clickCompleteBookingButton(){
        completeBookingPage.completeBookingButton.scrollTo().click();
        return this;
    }
}
