package steps;

import pages.HomePage;
import pages.ProductPage;
import pages.TelevisionsPage;

public class PageInitializers {
    public static HomePage homePage;
    public static ProductPage productPage;
    public static TelevisionsPage televisionsPage;

    public static void initializePageObjects() {
        homePage = new HomePage();
        productPage = new ProductPage();
        televisionsPage = new TelevisionsPage();
    }
}
