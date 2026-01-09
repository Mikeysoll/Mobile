package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0)));
    }

    @Test
    void successfulOpenSearchTest() {
        back();
        step("Open search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
        });
        step("Enter search text", () -> {
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appian");
        });
        step("Open the desired search result", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .findBy(text("Appian Way")).click();
        });


    }
}