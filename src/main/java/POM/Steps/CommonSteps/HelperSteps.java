package POM.Steps.CommonSteps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;


public class HelperSteps {

    @Step("Switch To New Window")
    public static void switchToNewWindow(){
        Selenide.switchTo().window(1);
    }

    @Step("Click Element Using JS Executor")
    public static void clickElementUsingJSExecutor(SelenideElement selenideElement){
        Selenide.executeJavaScript("arguments[0].click()", selenideElement);
    }

    @Step("Open Website")
    public static void openWebsite(String URL){
        open(URL);
    }
}
