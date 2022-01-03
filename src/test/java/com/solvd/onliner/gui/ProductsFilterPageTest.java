package com.solvd.onliner.gui;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.onliner.gui.components.FilterBlockItem;
import com.solvd.onliner.gui.components.ProductBlock;
import com.solvd.onliner.gui.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Locale;

public class ProductsFilterPageTest extends AbstractTest {

    @DataProvider(name = "manufacturers")
    private Object[][] manufacturers() {
        return new Object[][]{
                {"Sony"}
        };
    }

    @Test(dataProvider = "manufacturers")
    public void validateFilteringByManufacturerTest(String manufacturer) throws InterruptedException {
        ProductPage productPage = new ProductPage(getDriver());
        productPage.open();
        FilterBlockItem manufacturerFilterBlockItem = productPage.getFilterBlock().getFilterBlockItems().stream()
                .filter(filterBlockItem -> manufacturer.toLowerCase(Locale.ROOT).equals(filterBlockItem.getLabelTextText().toLowerCase(Locale.ROOT)))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There are no such manufacturer in the filter list"));
        ExtendedWebElement checkBox = manufacturerFilterBlockItem.getCheckbox();
        checkBox.click();
        Assert.assertTrue(checkBox.isChecked(), "Checkbox is not checked");

        WebDriverWait w = new WebDriverWait(getDriver(), 20);
        w.until(dr -> dr.findElement(By.xpath("//*[contains(@class, 'schema-filter-button__state_animated')]")));

        productPage.getProductBlocks().stream()
                .map(ProductBlock::getTitleTextText)
                .forEach(title -> Assert.assertTrue(title.toLowerCase(Locale.ROOT).contains(manufacturer.toLowerCase(Locale.ROOT)),
                        String.format("There are no '%s' in '%s'", manufacturer, title))
                );
    }
}
