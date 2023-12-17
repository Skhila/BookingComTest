package POM.Pages;


import POM.Data.Constants;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AttractionsPage {


    public SelenideElement
            locationInputField =
            $x("//input[@data-testid='search-input-field']"),
            locationElement =
                    $x("//a[@city ='" + Constants.ATTRACTION_LOCATION + "']");


}
