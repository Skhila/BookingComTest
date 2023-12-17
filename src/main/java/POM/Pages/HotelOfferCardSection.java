package POM.Pages;


import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$$x;

public class HotelOfferCardSection {

    public ElementsCollection hotelsPrices = $$x("//span[@data-testid=\"price-and-discounted-price\"]"),
            hotelsALocations = $$x("//span[@data-testid=\"address\"]"),
            hotelsReviewScores = $$x("//div[@data-testid=\"review-score\"]/div[1]");
}
