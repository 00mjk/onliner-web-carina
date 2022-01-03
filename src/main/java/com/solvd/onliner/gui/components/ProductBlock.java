package com.solvd.onliner.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductBlock extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class, 'title') and contains(@class, 'product')]//a//*")
    private ExtendedWebElement titleText;

    public ProductBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getTitleText() {
        return titleText;
    }

    public String getTitleTextText() {
        return titleText.getText();
    }
}
