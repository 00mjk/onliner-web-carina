package com.solvd.onliner.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.onliner.gui.components.CategoryNavigationElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class CatalogPage extends AbstractPage {

    @FindBy(xpath = ".//*[contains(@class, 'title') and contains(@class, 'header')]")
    private ExtendedWebElement title;

    @FindBy(xpath = ".//*[contains(@class, 'classifier')]//li[contains(@class, 'item') and not (contains(@class, 'brand'))]")
    private List<CategoryNavigationElement> categories;

    @FindBy(xpath = ".//*[contains(@class, 'catalog-navigation-list__category') and contains(@style, 'display: block')]//*[contains(@class, 'catalog-navigation-list__aside-title')]")
    private List<ExtendedWebElement> categoryItemsList;

    public CatalogPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("catalog_url"));
    }

    public ExtendedWebElement getHeaderTitle() {
        return title;
    }

    public String getHeaderTitleText() {
        return title.getText();
    }

    public List<CategoryNavigationElement> getCategories() {
        return categories;
    }

    public List<String> getCategoriesAsTextList() {
        return categories.stream()
                .map(CategoryNavigationElement::getCategoryTitleAsText)
                .collect(Collectors.toList());
    }

    public CategoryNavigationElement getCategoryByName(String name) {
        return categories.stream()
                .filter(category -> category.getCategoryTitleAsText().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("There are no category with such name"));
    }

    public List<ExtendedWebElement> getCategoryItemsList() {
        return categoryItemsList;
    }

    public List<String> getElements() {
        return categoryItemsList.stream()
                .map(item -> item.getText()).collect(Collectors.toList());
    }
}
