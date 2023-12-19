package POM.Pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AttractionDetailsPage {


    public SelenideElement
            nameOfAttractionElement =
                    $x("//h2[@class='af8fbdf136 css-jlpcfv']"),

            nextBtn =
                    $x("//button[@data-testid='select-ticket']"),

            showMoreDatesBtn =
                    $x("//button[@data-testid='toggle-calendar']"),
            availableDate =
                    $x("//span[@class='cf06f772fa']"),

            adultTicketRow = $x("//label[contains(text(), \"Adult\")]//parent::div//parent::div")
    ;

}
