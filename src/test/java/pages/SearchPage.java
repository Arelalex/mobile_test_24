package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {

    SelenideElement
            searchLineOne = $(accessibilityId("Search Wikipedia")),
            searchLineTwo = $(id("org.wikipedia.alpha:id/search_src_text")),
            searchLine = $(id("org.wikipedia.alpha:id/page_list_item_title"));
    ElementsCollection
            listOfTitle = $$(id("org.wikipedia.alpha:id/page_list_item_title"));


    public SearchPage clickSearchLine() {
        searchLineOne.click();

        return this;
    }

    public SearchPage enterValueInSearchLine(String value) {
        searchLineTwo.sendKeys(value);

        return this;
    }

    public SearchPage checkResultNotNull() {
        listOfTitle.shouldHave(sizeGreaterThan(0));

        return this;
    }

    public SearchPage enterValueAndClick(String value) {
        searchLine.shouldHave(text(value)).click();

        return this;
    }
}
