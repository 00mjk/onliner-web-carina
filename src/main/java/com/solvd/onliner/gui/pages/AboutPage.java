package com.solvd.onliner.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AboutPage extends AbstractPage {

    @FindBy(xpath = ".//*[contains(@class, 'title') and contains(@class, 'news')]")
    private ExtendedWebElement title;

    public AboutPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("blog_url"));
    }

    public ExtendedWebElement getInfoTitle() {
        return title;
    }

    public String getInfoTitleText() {
        return title.getText();
    }
}
