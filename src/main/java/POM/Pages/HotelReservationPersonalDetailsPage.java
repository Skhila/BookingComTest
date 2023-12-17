package POM.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HotelReservationPersonalDetailsPage {
    public SelenideElement
            firstNameField = $x("//input[@id='firstname']"),
            lastNameField = $x("//input[@id='lastname']"),
            emailField = $x("//input[@id='email']"),
            phoneNumberField = $x("//input[@id='phone']"),
            nextButton = $x("//button[@name='book']");

}
