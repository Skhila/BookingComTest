package POM.Pages;

import POM.Data.Constants;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class HotelsPage {
    public SelenideElement sorterDropDown = $x("//button[@data-testid=\"sorters-dropdown-trigger\"]"),
    sortWithPriceOption = $x("//button[@data-id=\"price\"]\n"),
    filterWithRatingCheckbox = $x("//div[@data-filters-item=\"review_score:review_score=90\"]/input"),
    loading = $x("//div[text() = \"Book now, pay when you stay!\"]");

    public ElementsCollection
            hotelsAvailabilityButton = $$x("//div[@aria-label='Property']//a[@data-testid='availability-cta-btn']"),
            hotel = $$x("//div[@aria-label='Property']//div[@data-testid='title']");

}
