package com.solvd.onliner.gui.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterBlock extends AbstractUIObject {

    @FindBy(xpath = ".//label[contains(@class, 'checkbox') and contains(@class, 'item')]")
    private List<FilterBlockItem> filterBlockItems;

    public FilterBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<FilterBlockItem> getFilterBlockItems() {
        return filterBlockItems;
    }
}
