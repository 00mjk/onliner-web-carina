package com.solvd.onliner.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.onliner.gui.components.FilterBlock;
import com.solvd.onliner.gui.components.ProductBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends AbstractPage {

    @FindBy(id = "schema-filter")
    private FilterBlock filterBlock;

    @FindBy(xpath = ".//*[contains(@class, 'schema-products_processing')]")
    private ExtendedWebElement productBlock;

    @FindBy(xpath = "//*[@id='schema-products']/*[contains(@class, 'group')]")
    private List<ProductBlock> productBlocks;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("console_products_url"));
    }

    public FilterBlock getFilterBlock() {
        return filterBlock;
    }

    public List<ProductBlock> getProductBlocks() {
        return productBlocks;
    }

    public ExtendedWebElement getStateAnimation() {
        return productBlock;
    }
}
