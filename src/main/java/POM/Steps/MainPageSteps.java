package POM.Steps;

import POM.Pages.MainPage;
import com.codeborne.selenide.Condition;
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
        if(mainPage.closeSignInButton.isDisplayed()) {
            mainPage.closeSignInButton.click();
        }
        return this;
    }
    @Step("Fill in the search bar")
    public MainPageSteps fillInSearchBar(String place){
        mainPage.hotelSearchBar.setValue(place);
        return this;
    }
    @Step("Chooses specified search result")
    public MainPageSteps chooseResult(int index,String place){
        mainPage.searchAutocompleteResults.get(index).shouldHave(Condition.text(place)).click();
        return this;
    }
    @Step("Click on date picker")
    public MainPageSteps clickDatePicker(){
        if(!mainPage.dateFlexibleButton.is(Condition.visible)) {
            mainPage.dateSelector.click();
        }
        return this;
    }
    @Step("Click search button")
    public MainPageSteps clickSearchButton(){
        mainPage.searchButton.click();
        return this;
    }

}
