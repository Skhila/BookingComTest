package POM.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LanguageChangePage {
    public SelenideElement germanBtn = $x("//span[text() = \"Deutsch\"]");

}
