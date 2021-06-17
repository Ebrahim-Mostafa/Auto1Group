package tests.searchTest;

import BasePackage.BaseTest;
import Pages.Search.SearchPage;
import Pages.Search.VerifyFilterPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class searchTest extends BaseTest {

    private static SearchPage searchPage;
    private static VerifyFilterPage verifyFilter;

    @BeforeClass
    public void initialization() {
        searchPage = new SearchPage();
        verifyFilter = new VerifyFilterPage();
    }


    @Test(priority = 1)
    public void search() {
        searchPage.gotoSearchPage();
        searchPage.sortByYear();
        searchPage.sortBypriceDesc();
    }

    @Test(priority = 2)
    public void filters(){
        verifyFilter.verifyFilterFirstRegistration();
        verifyFilter.verifyFilterPriceDescending();
    }
}