package com.gitlab.rmarzec.pages.w3schools;

import com.gitlab.rmarzec.framework.utils.FrameUtil;
import com.gitlab.rmarzec.framework.utils.WaitUtil;
import com.gitlab.rmarzec.pages.commons.Dropdown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TryItEditorPage {
    private final FrameUtil frameUtil;
    @FindBy(id = "runbtn")
    WebElement runButton;

    @FindBy(tagName = "h1")
    WebElement h1Element;

    @FindBy(id = "cars")
    WebElement carsSelect;

    public TryItEditorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        frameUtil = new FrameUtil(driver);

        WaitUtil.waitForPageLoadAndElement(driver, 3, runButton);
    }

    public TryItEditorPage printPreviewPaneH1() {
        frameUtil.executeInFrame("iframeResult", () -> {
            String textFromElement = h1Element.getText();
            System.out.println("H1 from Preview Pane:\n" + textFromElement);
        });
        return this;
    }

    public void printPreviewPaneSelectedOptionFromDropdown() {
        frameUtil.executeInFrame("iframeResult", () -> {
            Dropdown carsDropdown = new Dropdown(carsSelect);
            System.out.printf("Text and value from current selector option:\n%s, %s \n",
                    carsDropdown.getSelectedText(), carsDropdown.getSelectedValue());
        });
    }

    public TryItEditorPage selectCarFromSelectionInPreviewPane(String car) {
        frameUtil.executeInFrame("iframeResult", () -> {
            Dropdown carsDropdown = new Dropdown(carsSelect);
            carsDropdown.selectByVisibleText(car);
        });
        return this;
    }
}
