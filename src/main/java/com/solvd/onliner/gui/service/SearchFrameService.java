package com.solvd.onliner.gui.service;

import com.solvd.onliner.gui.pages.SearchFrame;
import org.openqa.selenium.WebDriver;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class SearchFrameService {

    private final SearchFrame searchFrame;

    public SearchFrameService(WebDriver webDriver) {
        this.searchFrame = new SearchFrame(webDriver);
        webDriver.switchTo().frame(searchFrame.getRootElement());
    }

    public boolean checkIsAllResultsContainsText(String text) {
        AtomicBoolean result = new AtomicBoolean(true);
        searchFrame.getSearchResults()
                .forEach(item -> {
                    String itemName = item.getResultNameText().toLowerCase(Locale.ROOT);
                    if (!itemName.contains(
                            text.toLowerCase(Locale.ROOT))) {
                        result.set(false);
                    }
                });
        return result.get();
    }
}
