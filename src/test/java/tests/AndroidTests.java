package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    SearchPage searchPage = new SearchPage();

    private final static String SEARCH_VALUE_ONE = "Appium";

    @Test
    @Tag("browserstack")
    void successfulSearchAppiumTest() {
        step("Type search", () -> {
            searchPage.clickSearchLine()
                    .enterValueInSearchLine(SEARCH_VALUE_ONE);
        });

        step("Verify content found", () -> {
            searchPage.checkResultNotNull();
        });
    }

    @Test
    @Tag("local")
    void searchTests() {
        step("Check 1 screen", () -> {
            $(id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("We’ve found the following on your device:"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check 2 screen", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check 3 screen", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check 3 screen", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data"));
        });
    }
}
