package com.solvd.onliner.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterBlockItem extends AbstractUIObject {

    @FindBy(tagName = "input")
    private ExtendedWebElement checkbox;

    @FindBy(xpath = ".//*[contains(@class, 'checkbox') and contains(@class, 'text')]")
    private ExtendedWebElement labelText;

    public FilterBlockItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCheckbox() {
        return checkbox;
    }

    public void clickCheckbox() {
        checkbox.check();
    }

    public ExtendedWebElement getLabelText() {
        return labelText;
    }

    public String getLabelTextText() {
        return labelText.getText();
    }
}
