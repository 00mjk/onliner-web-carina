package com.solvd.onliner.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.onliner.gui.components.FooterMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = ".//*[contains(@class, 'actions')]//img")
    private ExtendedWebElement logo;

    @FindBy(xpath = ".//input[contains(@class, 'search') and contains(@class, 'fast')]")
    private ExtendedWebElement searchField;

    @FindBy(xpath = ".//footer[contains(@class, 'bottom')]")
    private FooterMenu footerMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("url"));
    }

    public ExtendedWebElement getLogo() {
        return logo;
    }

    public ExtendedWebElement getSearchField() {
        return searchField;
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public void search(String text) {
        this.searchField.type(text);
    }
}
