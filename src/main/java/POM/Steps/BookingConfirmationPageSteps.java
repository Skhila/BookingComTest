package POM.Steps;

import POM.Data.Constants;
import POM.Pages.BookingConfirmationPage;
import io.qameta.allure.Step;
import org.testng.Assert;

public class BookingConfirmationPageSteps{
    BookingConfirmationPage bookingConfirmationPage = new BookingConfirmationPage();
    @Step("Checks confirmation text for reservation")
    public BookingConfirmationPageSteps validateConfirmationMessage(){
        Assert.assertEquals(bookingConfirmationPage.confirmationText.getText(), Constants.CONFIRMATION_MESSAGE);
        return this;
    }
}
