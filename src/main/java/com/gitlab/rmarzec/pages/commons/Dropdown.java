package com.gitlab.rmarzec.pages.commons;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    private final Select dropdown;

    public Dropdown(WebElement dropdownElement) {
        this.dropdown = new Select(dropdownElement);
    }

    public WebElement getSelectedOption() {
        return dropdown.getFirstSelectedOption();
    }

    public void selectByVisibleText(String text) {
        dropdown.selectByVisibleText(text);
    }

    public String getSelectedText() {
        return getSelectedOption().getText();
    }
    
    public String getSelectedValue() {
        return getSelectedOption().getAttribute("value");
    }
}