package POM.Steps.CommonSteps;

import POM.Pages.CommonPages.CommonElements;
import POM.Steps.HotelsPageSteps;
import io.qameta.allure.Step;

public class CommonElementsSteps {
    CommonElements commonElements = new CommonElements();

    @Step("Click On Search Button")
    public CommonElementsSteps clickSearchButton(){
        commonElements.searchButton.click();
        return this;
    }
}
