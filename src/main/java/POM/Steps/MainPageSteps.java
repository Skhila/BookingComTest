package POM.Steps;

import POM.Pages.HotelsPage;
import POM.Pages.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class MainPageSteps {
    MainPage mainPage = new MainPage();
    @Step("Get First Trending Location's Name")
    public String getFirstTrendingLocationName(){
        return mainPage.firstTrendingLocationName.getText();
    }

    @Step("Click On The First Trending Location")
    public MainPageSteps clickOnFirstTrendingLocation(){
        mainPage.firstTrendingLocation.click();
        return this;
    }

    @Step("Close Sign In Suggestion Popup")
    public MainPageSteps closeSignInSuggestion(){
        mainPage.closeSignInButton.click();
        return this;
    }


}
