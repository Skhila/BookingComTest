package POM.Steps;

import POM.Pages.AttractionDetailsPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


public class AttractionsDetailsPageSteps {

    AttractionDetailsPage attractionDetailsPage = new AttractionDetailsPage();

    public String nameOfAttraction = "";
    public double price = 0.0;

    @Step("get text of attraction element")
    public AttractionsDetailsPageSteps getTextOfAttraction() {
        nameOfAttraction = attractionDetailsPage.nameOfAttractionElement.getText();
        return this;
    }

    @Step("scroll down ")
    public AttractionsDetailsPageSteps scrollDown() {
        attractionDetailsPage.nextBtn.scrollIntoView(true);
        return this;
    }

    @Step("click show more button")
    public AttractionsDetailsPageSteps clickShowMoreBtn() {
        attractionDetailsPage.showMoreDatesBtn.click();
        return this;
    }

    @Step("click available date to booking attraction")
    public AttractionsDetailsPageSteps clickAvailableDate() {
        attractionDetailsPage.availableDate.click();
        return this;
    }


    @Step("choose amount of tickets and get price")
    public AttractionsDetailsPageSteps chooseTicketAmountForAdults(int amount) {
        SelenideElement firstSection = attractionDetailsPage.adultTicketRow;

        SelenideElement addBtn = firstSection.$x(".//span//following-sibling::button");
        SelenideElement priceElement = firstSection.$x(".//div[contains(@class,'abf093bdfe')]");
        String numericPart = priceElement.getText().split(" ")[1];
        price = Double.parseDouble(numericPart);
        for (int i = 1; i <= amount; i++) {
            addBtn.click();
        }
        return this;
    }

    @Step("click next button")
    public AttractionsDetailsPageSteps clickNextBtn() {
        attractionDetailsPage.nextBtn.click();
        return this;
    }


}
