package POM.Steps;

import POM.Pages.HotelsPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class HotelsPageSteps{
    HotelsPage hotelsPage = new HotelsPage();

    @Step("Click Sorter Dropdown")
    public HotelsPageSteps clickSorterDropdown(){
        hotelsPage.sorterDropDown.should(appear);
        hotelsPage.sorterDropDown.hover().click();
        return this;
    }

    @Step("Choose Sort With Price Option")
    public HotelsPageSteps chooseSortWithPriceOption(){
        hotelsPage.sortWithPriceOption.click();
        return this;
    }

    @Step("Select Filter With Rating (9+)")
    public HotelsPageSteps selectFilterWithRating(){
        hotelsPage.filterWithRatingCheckbox.scrollIntoView(true).click();
        hotelsPage.loading.should(disappear);
        return this;
    }
    @Step("Clicks on the hotel with the index")
    public HotelsPageSteps clickOnHotelsAvailabilityButton(int index){
        hotelsPage.hotelsAvailabilityButton.get(index).shouldBe(Condition.visible).shouldBe(Condition.enabled).scrollTo().click();
        return this;
    }
    @Step("Gets name of the hotel for validation")
    public String getHotelName(int index){
        return hotelsPage.hotel.get(index).getText();
    }
    @Step("Switches tab")
    public HotelsPageSteps switchTab(){
        Selenide.switchTo().window(1);
        return this;
    }

}
