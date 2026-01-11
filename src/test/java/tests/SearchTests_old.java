package tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag("browserstack")
public class SearchTests_old {


    @Test
    void successfulSearchTestComplete() throws MalformedURLException, InterruptedException {

        // ========== 1. НАСТРОЙКА КАПАБИЛИТИ ==========
        UiAutomator2Options options = new UiAutomator2Options();

        // Настройки BrowserStack (все в bstack:options)
        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", "mikhail_B9r2gX");
        bstackOptions.put("accessKey", "J2wxzLgWN29oy28V9K2b");
        // Используем устройство из примера BrowserStack, которое точно поддерживается
        bstackOptions.put("deviceName", "Samsung Galaxy S22 Ultra"); // Изменили устройство
        bstackOptions.put("osVersion", "12.0"); // Исправляем версию ОС для нового устройства
        bstackOptions.put("projectName", "First Java Project");
        bstackOptions.put("buildName", "browserstack-build-1");
        bstackOptions.put("sessionName", "first_test");

        // Ключевые capabilities БЕЗ префикса appium:
        options.setCapability("platformName", "Android");
        options.setCapability("app", "bs://sample.app"); // Оставляем демо-приложение

        // Appium-специфичные настройки
        options.setCapability("appium:auto mationName", "UiAutomator2");

        // Присоединяем настройки BrowserStack
        options.setCapability("bstack:options", bstackOptions);

        // ========== 2. ИНИЦИАЛИЗАЦИЯ ДРАЙВЕРА ==========
        AndroidDriver driver = new AndroidDriver(new URL("https://hub.browserstack.com/wd/hub"), options);

        // ========== 3. ВЫПОЛНЕНИЕ ТЕСТОВОГО СЦЕНАРИЯ ==========

        // Ждём и кликаем на кнопку поиска
        WebElement searchElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Search Wikipedia")));
        searchElement.click();

        // Ждём поле ввода и вводим текст
        WebElement insertTextElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("Russia");

        // Ждём результаты
        Thread.sleep(5000);

        // Проверяем, что найдены результаты
        List<WebElement> allProductsName = driver.findElements(AppiumBy.className("android.widget.TextView"));
        assert (allProductsName.size() > 0) : "Не найдено ни одного результата поиска";

        System.out.println("Тест успешно выполнен! Найдено результатов: " + allProductsName.size());

        driver.quit();

    }
}