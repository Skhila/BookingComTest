package POM.Pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class CompleteBookingPage {
    public SelenideElement completeBookingButton = $x("//span[contains(text(),' Complete booking ')]/parent::button");
}
