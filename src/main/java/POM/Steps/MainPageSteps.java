package POM.Steps;

import POM.Data.Constants;
import POM.Pages.HotelsPage;
import POM.Pages.MainPage;
import POM.Steps.CommonSteps.HelperSteps;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.testng.Assert;
import io.restassured.response.Response;


public class MainPageSteps {
    MainPage mainPage = new MainPage();
    Response response;

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
            mainPage.closeSignInButton.hover().click();
        }
        return this;
    }
    @Step("Fill in the search bar")
    public MainPageSteps fillInSearchBar(String place){
        mainPage.closeSignInButton.should(Condition.disappear);

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

    @Step("Clicking On Language Change Button")
    public  MainPageSteps clickOnLanguageButton(){
        mainPage.closeSignInButton.should(Condition.disappear);
        mainPage.languageBtn.click();
        return this;
    }

    @Step("This Step Is Validating If The Flag Is Shown Correctly")
    public MainPageSteps flagValidation(){
        String srcAttributeValue =mainPage.flag.getAttribute("src");
        assert srcAttributeValue != null;
        Assert.assertTrue(srcAttributeValue.contains("De@3x.png"), Constants.ASSERT_ERROR);
        return this;
    }

    @Step("This Step Gets German Text")
    public String  getGermanText(){
        String germanText = mainPage.germanText.getText();
        return germanText;
    }

    @Step("This Step is Using Rest Assured And Finds Out In Which Language Is Current Text")
    public MainPageSteps restStep(String expectedText) {
        response = RestAssured
                .given()
                .queryParam("secret_key", Constants.SECRET_KEY)
                .queryParam("query", expectedText)
                .when()
                .get(Constants.API_URL);

        System.out.println(response.getBody().asString());
        return this;
    }
    @Step("This Step Validates If The Page Is German Or NO")
    public MainPageSteps languageValidation(){
        String languageName = response.path("results[0].language_name");
        String languageCode = response.path("results[0].language_code");

        Assert.assertEquals(languageName, Constants.GERMAN_NAME, Constants.ASSERT_LANGUAGE_ERROR);
        Assert.assertEquals(languageCode, Constants.GERMAN_CODE, Constants.ASSERT_CODE_ERROR);
        return this;
    }

}
