package com.solvd.onliner.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.onliner.gui.pages.AboutPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends AbstractUIObject {

    @FindBy(xpath = ".//a[contains(text(), 'О компании')]")
    private ExtendedWebElement aboutPageLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AboutPage openAboutPage() {
        aboutPageLink.click();
        return new AboutPage(driver);
    }
}
