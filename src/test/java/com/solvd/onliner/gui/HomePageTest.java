package com.solvd.onliner.gui;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.onliner.gui.pages.AboutPage;
import com.solvd.onliner.gui.pages.HomePage;
import com.solvd.onliner.gui.service.SearchFrameService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends AbstractTest {

    @DataProvider(name = "searchableText")
    public Object[][] searchableText() {
        return new Object[][]{
                {"vodka"}, {"стул"}
        };
    }

    @Test
    public void verifyHomePageOpeningTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(5), "Home page is not opened");
    }

    @Test
    public void verifyLogoPresentTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        ExtendedWebElement logo = homePage.getLogo();
        Assert.assertTrue(logo.isPresent(), "Home page logo is not present");
    }

    @Test
    public void verifyOpenAboutPageTest() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        AboutPage aboutPage = homePage.getFooterMenu().openAboutPage();
        Assert.assertTrue(aboutPage.isPageOpened(), "About page is not opened");
    }

    @Test(dataProvider = "searchableText")
    public void verifySearchResultContainingTextTest(String text) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.search(text);
        SearchFrameService searchFrameService = new SearchFrameService(getDriver());
        Assert.assertTrue(searchFrameService.checkIsAllResultsContainsText(text), "Search result does not contains searching word");
    }
}
