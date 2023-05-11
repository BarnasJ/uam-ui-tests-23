package ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pageObjects.GoogleHomePage;
import pageObjects.GoogleResultsPage;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TextReportExtension.class)
public class GoogleTest {

    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.google.com";
    }

    @Test
    public void googleHomeTest() {

        open("/");

        $(byId("L2AGLb")).click();

        $(byName("q")).shouldBe(Condition.visible)
                .val("kalkulator").pressEnter();

        $(by("jsname", "lVjWed")).click();
        $(by("jsname", "XSr6wc")).click();
        $(by("jsname", "abcgof")).click();
        $(by("jsname", "Pt8tGc")).click();

        $(by("jsname", "VssY5c"))
                .shouldHave(Condition.text("8"));
    }

    @Test
    public void pageObjectPatternApproach() throws InterruptedException {
        new GoogleHomePage().open().acceptCookies()
                .search("kalkulator");

        new GoogleResultsPage()
                .searchForTextInElement(0, "test");
    }




}
