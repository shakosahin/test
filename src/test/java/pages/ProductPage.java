package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ProductPage extends CommonMethods {
    public WebElement getAboutThisItemSection(String text) {
       return driver.findElement(By.xpath("//h1[contains(text(),'" + text + "')]"));
    }

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }
}
