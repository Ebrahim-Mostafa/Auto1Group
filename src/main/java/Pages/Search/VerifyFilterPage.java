package Pages.Search;

import BasePackage.BasePage;
import Utilities.ObjectRepositoryJsonParser;
import Utilities.TimeUtils;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class VerifyFilterPage extends BasePage {

    SoftAssert softAssert = new SoftAssert();

    public void verifyFilterFirstRegistration() {
        WebElement yearFilterBtn = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.yearFilterBtn");
        TimeUtils.explicitWait(yearFilterBtn, 10);
        String yearFilterTxt = yearFilterBtn.getText();
        softAssert.assertTrue("Ab 2015".equals(yearFilterTxt), "Filter all cars by first registration not applied");

        WebElement activeFilterBtn = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.activeFilterBtn");
        String activeFilterTxt = activeFilterBtn.getText();
        TimeUtils.shortWait();
        softAssert.assertTrue("Erstzulassung: Ab 2015".equals(activeFilterTxt), "Filter by first registration button not found");
        softAssert.assertEquals(activeFilterBtn.isDisplayed(), true);

        WebElement resetFilterBtn = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.resetFilterBtn");
        String resetFilterTxt = resetFilterBtn.getText();
        TimeUtils.shortWait();
        softAssert.assertTrue("Filter löschen".equals(resetFilterTxt), "Reset filter button not found");
        softAssert.assertAll();
    }

    public void verifyFilterPriceDescending() {
        WebElement sortByBtn = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.sortByBtn");
        WebElement priceDescBtn = ObjectRepositoryJsonParser.getObjectLocator("$.SearchPage.priceDescBtn");
        TimeUtils.explicitWait(priceDescBtn, 10);
        elementClick(priceDescBtn);
        elementClick(sortByBtn);
        String priceDescTxt = priceDescBtn.getText();
        TimeUtils.shortWait();
        softAssert.assertTrue("Höchster Preis".equals(priceDescTxt), "Filter all cars by price descending not applied");
        softAssert.assertAll();
    }
}