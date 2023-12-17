package POM.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HotelPage {
    public SelenideElement
            reserveButton = $x("//button[@id='hp_book_now_button']"),
            reserveButtonText = $x("//span[@class='b-button__from-text book_now_rt_summary']"),
            reserveNowButton = $x("//span[contains(.,\"I'll reserve\")]/parent::button"),
            hotelName = $x("//div[@id='hp_hotel_name']/descendant::h2"),
            hotelReservationTotalPriceElement = $x("//div[contains(@class, \"hprt-reservation-total-price\")]");
}
