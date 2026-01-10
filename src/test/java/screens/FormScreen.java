package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;

public class FormScreen {
    private final SelenideElement
            inputField=$("[content-desc=text-input]"),
            textResult=$("[content-desc=input-text-result]"),
            toggleSwitch = $("[content-desc=switch]"),
            switchText = $("[content-desc=switch-text]"),
            dropDown = $("[content-desc=Dropdown]"),
            dropDownValue = $("[text='webdriver.io is awesome']"),
            buttonActive = $("[content-desc=button-Active]");

    public FormScreen  setInputValue(String inputValue){
        inputField.sendKeys(inputValue);
        textResult.equals(inputValue);
        return this;
    }

    public FormScreen clickToggleSwitch(){
        String isChecked = toggleSwitch.getAttribute("checked");

        if(isChecked.equals("false")){
            toggleSwitch.click();
            switchText.shouldHave(text("Click to turn the switch OFF"));
        } else switchText.shouldHave(text("Click to turn the switch ON"));

        return  this;
    }

    public FormScreen clickDropdown(){
        dropDown.click();
        return this;
    }

    public FormScreen selectDropdownValue(){
        dropDownValue.click();
        return this;
    }

    public FormScreen clickButtonActive(){
        buttonActive.click();
        return this;
    }
}
