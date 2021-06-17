package Pages.Search;

import BasePackage.BasePage;
import Utilities.ObjectRepositoryJsonParser;
import Utilities.TimeUtils;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    WebElement findYourCarBtn = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.findYourCarBtn");

    public void gotoSearchPage() {
        elementClick(findYourCarBtn);
    }

    public void sortByYear() {
        WebElement yearFilterBtn = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.yearFilterBtn");
        TimeUtils.explicitWait(yearFilterBtn, 10);
        elementClick(yearFilterBtn);
        WebElement fromYear = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.fromYear");
        elementClick(fromYear);
        WebElement year2015 = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.year2015");
        TimeUtils.explicitWait(year2015, 10);
        elementClick(year2015);
        elementClick(yearFilterBtn);
        TimeUtils.mediumWait();
    }

    public void sortBypriceDesc() {
        WebElement sortByBtn = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.sortByBtn");
        elementClick(sortByBtn);
        WebElement priceDescBtn = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.priceDescBtn");
        TimeUtils.explicitWait(priceDescBtn, 10);
        elementClick(priceDescBtn);
    }
}