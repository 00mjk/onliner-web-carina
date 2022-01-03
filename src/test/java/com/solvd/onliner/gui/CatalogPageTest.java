package com.solvd.onliner.gui;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.onliner.gui.components.CategoryNavigationElement;
import com.solvd.onliner.gui.pages.CatalogPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class CatalogPageTest extends AbstractTest {

    @DataProvider(name = "catalogCategories")
    public Object[][] catalogCategoriesItems() {
        return new Object[][]{
                {"Электроника", List.of()},
                {"Компьютеры и сети", List.of()},
                {"Бытовая техника", List.of()},
                {"Стройка и ремонт", List.of()},
                {"Дом и сад", List.of()},
                {"Авто и мото", List.of()},
                {"Красота и спорт", List.of()},
                {"Детям и мамам", List.of()},
                {"Работа и офис", List.of()},
                {"Еда", List.of("Пицца", "Суши", "Бургеры и фастфуд", "Шашлык, гриль", "Шаурма", "Мясо и рыба", "Паста",
                        "Пироги, пирожки", "Фермерские продукты", "Бакалея", "Деликатесы и морепродукты", "Десерты, сладкая выпечка",
                        "Все заведения")}
        };
    }

    @Test(dataProvider = "catalogCategories")
    public void checkCategoriesExistsTest(String categoryName, List<String> categoryItemsNames) {
        CatalogPage catalogPage = new CatalogPage(getDriver());
        catalogPage.open();
        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened");
        CategoryNavigationElement categoryNavigationElement = catalogPage.getCategoryByName(categoryName);
        Assert.assertFalse(Objects.isNull(categoryNavigationElement), String.format("Category %s is not exists", categoryName));
        if (Objects.isNull(categoryItemsNames) || categoryItemsNames.size() <= 0) return;
        categoryNavigationElement.getRootElement().click();

        List<String> categoryItems = catalogPage
                .getElements().stream().map(item -> item.toLowerCase(Locale.ROOT)).collect(Collectors.toList());
        Assert.assertNotNull(categoryItems, "Category items list cannot be null");
        for (String categoryItemName : categoryItemsNames) {
            Assert.assertTrue(categoryItems.contains(categoryItemName.toLowerCase(Locale.ROOT)), String.format("There are no %s in %s category", categoryItemName, categoryName));
        }
    }
}
