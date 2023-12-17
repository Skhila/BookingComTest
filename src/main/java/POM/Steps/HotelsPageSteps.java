package POM.Steps;

import POM.Pages.HotelsPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;

public class HotelsPageSteps {
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





}
