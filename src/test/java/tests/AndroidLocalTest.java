package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

public class AndroidLocalTest extends TestBase {

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
    @Test
    void checkLoginButtonTest() {
        $(className("android.widget.TextView")).click();
        $(byText("Login / Sign up Form")).shouldBe(visible);
    }
}
