package cucumber.steps;

import BasePackage.BaseTest;
import Pages.Search.SearchPage;
import Pages.Search.VerifyFilterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTest extends BaseTest {

    public static SearchPage searchPage = new SearchPage();
    public static VerifyFilterPage verifyFilterPage = new VerifyFilterPage();

    @Given("^user is on the dashboard page$")
    public void user_is_on_the_dashboard_page() {
        System.out.println("You are in the dashboard page");
    }

    @When("^user click on find your car button$")
    public void user_click_on_find_your_car_button() {
        searchPage.gotoSearchPage();
    }

    @Then("^user will be navigated to search page$")
    public void user_will_be_navigated_to_search_page() {
        System.out.println("You are in the search page");
    }

    @And("^user will sort by first registration$")
    public void user_will_sort_by_first_registration() {
        searchPage.sortByYear();
    }

    @Then("^all cars are filtered by first registration$")
    public void all_cars_are_filtered_by_first_registration() {
        System.out.println("Cars are filtered by first registration");
        verifyFilterPage.verifyFilterFirstRegistration();
    }

    @And("^user will sort by price descending$")
    public void user_will_sort_by_price_descending() {
       searchPage.sortBypriceDesc();
    }

    @Then("^all cars are filtered by price descending$")
    public void all_cars_are_filtered_by_price_descending() {
        System.out.println("Cars are filtered by price descending");
        verifyFilterPage.verifyFilterPriceDescending();
    }

}