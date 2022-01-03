package com.solvd.onliner.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResult extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(@class, 'title')]")
    private ExtendedWebElement resultName;

    public SearchResult(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getResultName() {
        return resultName;
    }

    public String getResultNameText() {
        return resultName.getText();
    }
}
