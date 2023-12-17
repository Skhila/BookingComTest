package POM.Steps.CommonSteps;

import POM.Pages.CommonPages.DatePickerSection;
import io.qameta.allure.Step;


public class DatePickerSteps {
    DatePickerSection datePickerSection = new DatePickerSection();

    @Step("Open Date Picker Table")
    public DatePickerSteps doubleClickDatePickerTrigger(){
        datePickerSection.datePickerTrigger.click();
        datePickerSection.datePickerTrigger.click();

        return this;
    }

    @Step("Click date flexible button")
    public DatePickerSteps clickFlexibleButton(){
        datePickerSection.dateFlexibleButton.hover().click();
        datePickerSection.dateFlexibleButton.click();
        return this;
    }
    @Step("Choose how long you want to stay between weekend,week,month,other")
    public DatePickerSteps chooseStayDuration(int index){
        datePickerSection.stayDurationRadioButtons.get(index).click();
        return this;
    }
    @Step("Select month")
    public DatePickerSteps selectMonth(int index){
        datePickerSection.monthSelectionButtons.get(index).click();
        return this;
    }
    @Step("Click select Dates button")
    public DatePickerSteps clickSelectDateButton(){
        datePickerSection.selectDateButton.click();
        return this;
    }
}
