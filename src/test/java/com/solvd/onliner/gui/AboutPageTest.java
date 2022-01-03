package com.solvd.onliner.gui;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.onliner.gui.pages.AboutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutPageTest extends AbstractTest {

    @Test
    public void verifyTitleTextTest() {
        final String expectedTitle = "О сайте";
        AboutPage aboutPage = new AboutPage(getDriver());
        aboutPage.open();
        Assert.assertTrue(aboutPage.isPageOpened(), "About page is not opened");
        String receivedTitle = aboutPage.getInfoTitleText();
        Assert.assertEquals(receivedTitle, expectedTitle, "About page title is not equals expected title");
    }
}
