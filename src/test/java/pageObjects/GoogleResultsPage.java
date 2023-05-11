package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultsPage {

    public GoogleResultsPage searchForTextInElement(int index, String expectedText) {
        ElementsCollection elements = $$(By.xpath("//*[@id=\"rso\"]/div[2]"));

        elements.get(index).shouldHave(text(expectedText));

        return this;
    }
}
