package POM.Pages.CommonPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CommonElements {
    public SelenideElement searchButton = $x("//button[@type = \"submit\"]");

}
