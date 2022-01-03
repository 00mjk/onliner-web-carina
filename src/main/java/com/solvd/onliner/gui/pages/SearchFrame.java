package com.solvd.onliner.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.onliner.gui.components.SearchResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchFrame extends AbstractUIObject {

    private final String rootSearchFrameXpath = "//*[@class='modal-iframe']";

    @FindBy(xpath = ".//*[contains(@class, 'result') and contains(@class, 'search')]/li//*[contains(@class, 'item_product')]")
    List<SearchResult> searchResults;

    public SearchFrame(WebDriver driver) {
        super(driver);
        setRootElement(driver.findElement(By.xpath(rootSearchFrameXpath)));
    }

    public List<SearchResult> getSearchResults() {
        return searchResults;
    }
}
