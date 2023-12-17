package POM.Steps;

import POM.Pages.AttractionsPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


public class AttractionsPageSteps {
    AttractionsPage attractionsPage = new AttractionsPage();

    @Step("input  location")
    public AttractionsPageSteps inputLocation(String location) {
        attractionsPage.locationInputField.click();
        attractionsPage.locationInputField.setValue(location);
        return this;
    }

    @Step("choose  location")
    public AttractionsPageSteps clickLocation() {
        attractionsPage.locationElement.shouldBe(Condition.appear);
        attractionsPage.locationElement.click();
        return this;
    }

}
