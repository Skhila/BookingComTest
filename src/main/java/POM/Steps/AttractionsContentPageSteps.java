package POM.Steps;

import POM.Pages.AttractionsContentPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


public class AttractionsContentPageSteps {
    AttractionsContentPage attractionsDetailsPage = new AttractionsContentPage();


    @Step("Click most popular button")
    public AttractionsContentPageSteps clickMostPopularBtn() {
        attractionsDetailsPage.mostPopularBtn.shouldBe(Condition.visible);
        attractionsDetailsPage.mostPopularBtn.click();
        return this;
    }

    @Step("click first offered attraction element")
    public AttractionsContentPageSteps clickFirstOfferedElement() {
        attractionsDetailsPage.offeredAttractionList.get(0).click();
        return this;
    }
}

