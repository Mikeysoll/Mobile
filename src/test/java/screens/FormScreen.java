package screens;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FormScreen {
    private final SelenideElement
            inputField=$("[content-desc=text-input]"),
            textResult=$("[content-desc=input-text-result]"),
            toggleSwitch = $("[content-desc=switch]"),
            switchText = $("[content-desc=switch-text]"),
            dropDown = $("[content-desc=Dropdown]"),
            dropDownValue = $("[text='webdriver.io is awesome']"),
            buttonActive = $("[content-desc=button-Active]"),
            submitButton = $(".android.widget.Button");

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

    public FormScreen clickActiveButton(){
        buttonActive.click();
        return this;
    }

    public FormScreen submit(){
        submitButton.click();
        return this;
    }
}
