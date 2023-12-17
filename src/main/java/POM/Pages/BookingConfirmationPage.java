package POM.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BookingConfirmationPage {
    public SelenideElement confirmationText = $x("//span[@class='conf-page-gem-offers__badge-text']");
}
