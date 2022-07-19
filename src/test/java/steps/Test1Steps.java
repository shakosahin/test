package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TelevisionsPage;
import utils.CommonMethods;

public class Test1Steps extends CommonMethods {
    @Given("user navigates to tutorials ninja website and verify that the url is {string}")
    public void userNavigatesToTutorialsNinjaWebsiteAndVerifyThatTheUrlIs(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @When("user clicks on the hamburger menu in the top left corner")
    public void userClicksOnTheHamburgerMenuInTheTopLeftCorner() {
        click(homePage.getHamburgerMenu());
    }

    @And("user scrolls down and then Click on the {string} link under Shop by Department section.")
    public void userScrollsDownAndThenClickOnTheLinkUnderShopByDepartmentSection(String menuItem){
        clickOnList(homePage.getHamburgerMenuItems(), menuItem);
    }

    @And("user clicks on {string} under Tv, Audio & Cameras sub section")
    public void userClicksOnUnderTvAudioCamerasSubSection(String subSection) {
        clickOnList(homePage.getSubMenuItems(), subSection);
    }

    @And("user scrolls down and filter the results by Brand {string}")
    public void userScrollsDownAndFilterTheResultsByBrand(String brandName){
        clickOnList(televisionsPage.getBrandLabels(), brandName);
    }

    @And("user sorts the Samsung results with {string}")
    public void userSortsTheSamsungResultsWith(String sortOption) throws InterruptedException {
        click(televisionsPage.getSortByDropdown());
        Thread.sleep(1000);
        click(televisionsPage.getSortByElements(sortOption));
    }

    @And("user clicks on the {string} highest priced item")
    public void userClicksOnTheHighestPricedItem(String rank) {
        clickOnPriceList(televisionsPage.getPriceList(), Integer.parseInt(rank.replaceAll("\\.", "")));
    }

    @Then("user verifies that {string} section is present")
    public void userVerifiesThatSectionIsPresent(String sectionName) {
        switchWindow();
        jsScrollDown(productPage.getAboutThisItemSection(sectionName));
        highlightText(productPage.getAboutThisItemSection(sectionName), "red");
        Assert.assertTrue(isDisplayed(productPage.getAboutThisItemSection(sectionName)));
    }
}
