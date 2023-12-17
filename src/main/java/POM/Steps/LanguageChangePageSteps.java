package POM.Steps;

import POM.Pages.LanguageChangePage;
import io.qameta.allure.Step;

public class LanguageChangePageSteps {
    LanguageChangePage languageChangePage = new LanguageChangePage();
    @Step("This Step Clicks On German Language Button")
    public LanguageChangePageSteps clickOnGermanBtn(){
        languageChangePage.germanBtn.click();
        return this;
    }
}
