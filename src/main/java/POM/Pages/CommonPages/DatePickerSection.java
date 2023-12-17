package POM.Pages.CommonPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DatePickerSection {
    public ElementsCollection stayDurationRadioButtons = $$x("//div[@data-testid='flexible-dates-day']"),
            monthSelectionButtons = $$x("//div[@id='flexible-searchboxdatepicker']//ul/li/label");

    public SelenideElement
            dateFlexibleButton = $x("//button[@aria-controls='flexible-searchboxdatepicker']"),
            selectDateButton = $x("//span[contains(text(), 'Select dates')]/parent::button"),
            datePickerTrigger = $x("//div[@data-testid=\"searchbox-dates-container\"]");
}
