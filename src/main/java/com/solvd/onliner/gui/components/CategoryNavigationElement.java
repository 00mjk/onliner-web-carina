package com.solvd.onliner.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoryNavigationElement extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class, 'title') and contains(@class, 'wrapper')]")
    private ExtendedWebElement categoryTitle;

    public CategoryNavigationElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCategoryTitle() {
        return categoryTitle;
    }

    public String getCategoryTitleAsText() {
        return categoryTitle.getText();
    }
}
