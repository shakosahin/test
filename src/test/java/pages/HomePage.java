package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class HomePage extends CommonMethods {
    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//div[@id='hmenu-content']/ul[@class='hmenu hmenu-visible']/li")
    private List<WebElement> hamburgerMenuItems;

    @FindBy(xpath = "//div[@id='hmenu-content']/ul[@class='hmenu hmenu-visible hmenu-translateX']/li")
    private List<WebElement> subMenuItems;

    public WebElement getHamburgerMenu() {
        return hamburgerMenu;
    }

    public List<WebElement> getHamburgerMenuItems() {
        return hamburgerMenuItems;
    }

    public List<WebElement> getSubMenuItems() {
        return subMenuItems;
    }

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
}
