package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class TelevisionsPage extends CommonMethods {
    @FindBy(xpath = "//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium']/li[@class='a-spacing-micro']/span[@class='a-list-item']/a/span")
    private List<WebElement> brandLabels;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    private WebElement sortByDropdown;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private List<WebElement> priceList;

    public List<WebElement> getBrandLabels() {
        return brandLabels;
    }

    public WebElement getSortByDropdown() {
        return sortByDropdown;
    }

    public List<WebElement> getPriceList() {
        return priceList;
    }

    public WebElement getSortByElements(String text) {
        return driver.findElement(By.xpath("//ul[@class='a-nostyle a-list-link']/li/a[contains(text(),'" + text + "')]"));
    }


    public TelevisionsPage() {
        PageFactory.initElements(driver, this);
    }

}

