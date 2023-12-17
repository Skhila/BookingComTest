package POM.Steps;

import POM.Pages.HotelPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.Assert;

public class HotelPageSteps {
    HotelPage hotelPage = new HotelPage();
    @Step("Choose room number")
    public HotelPageSteps reserveRoom(){
        if(hotelPage.reserveButtonText.isDisplayed()){
            hotelPage.hotelReservationTotalPriceElement.should(Condition.appear);
            hotelPage.reserveButton.hover().click();
            return this;
        }
        hotelPage.reserveButton.click();
        hotelPage.reserveNowButton.shouldBe(Condition.visible).shouldBe(Condition.enabled).shouldNotBe(Condition.hidden).click();
        return this;
    }
    @Step("Validates name of the hotel")
    public HotelPageSteps validateHotelName(String name){
        Assert.assertEquals(name,hotelPage.hotelName.getText());
        return this;
    }

}
