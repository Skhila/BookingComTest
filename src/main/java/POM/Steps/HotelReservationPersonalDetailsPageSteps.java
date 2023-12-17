package POM.Steps;

import POM.Pages.HotelReservationPersonalDetailsPage;
import io.qameta.allure.Step;

import java.util.UUID;

public class HotelReservationPersonalDetailsPageSteps {
    HotelReservationPersonalDetailsPage hotelReservationPersonalDetailsPage = new HotelReservationPersonalDetailsPage();
    @Step("Fills in the first name field")
    public HotelReservationPersonalDetailsPageSteps fillInName(String name){
        hotelReservationPersonalDetailsPage.firstNameField.setValue(name);
        return this;
    }
    @Step("Fills in the last name field")
    public HotelReservationPersonalDetailsPageSteps fillInSurname(String surname){
        hotelReservationPersonalDetailsPage.lastNameField.setValue(surname);
        return this;
    }
    @Step("Fills in the email field")
    public HotelReservationPersonalDetailsPageSteps fillInEmail(String email){
        hotelReservationPersonalDetailsPage.emailField.setValue(email);
        return this;
    }
    @Step("Fills in the phone field")
    public HotelReservationPersonalDetailsPageSteps fillInPhone(String phone){
        hotelReservationPersonalDetailsPage.phoneNumberField.setValue(phone);
        return this;
    }
    @Step("Clicks Next: Final details button")
    public HotelReservationPersonalDetailsPageSteps clickNext(){
        hotelReservationPersonalDetailsPage.nextButton.scrollTo().click();
        return this;
    }
    @Step("Generates unique email for reservation")
    public String generateUniqueEmail() {
        String uniqueID = UUID.randomUUID().toString();
        return "user_" + uniqueID + "@gmail.com";
    }
}
