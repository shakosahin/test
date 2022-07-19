package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializers;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class CommonMethods extends PageInitializers {
    public static WebDriver driver;

    public void launchBrowser() {
        driver = BrowserFactory.get();
        initializePageObjects();
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static void switchWindow() {
        String mainPageHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String handle = iterator.next();
            if (!mainPageHandle.equals(handle)) {
                driver.switchTo().window(handle);
            }
        }
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static void clickOnList(List<WebElement> elementList, String text) {
        for (WebElement element : elementList) {
            if (getText(element).equalsIgnoreCase(text)) {
                click(element);
                break;
            }
        }
    }

    public static void clickOnPriceList(List<WebElement> elementList, int rank) {
        List<Integer> priceListInteger = new ArrayList<>();
        for (WebElement element : elementList) {
            priceListInteger.add(Integer.parseInt(getText(element).replaceAll("[,]", "")));
        }
        Collections.sort(priceListInteger);

        clickOnList(elementList, getIndianCurrencyFormat(String.valueOf(priceListInteger.get(priceListInteger.size() - rank))));
    }

    public static String getIndianCurrencyFormat(String amount) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] amountArray = amount.toCharArray();
        int a = 0, b = 0;
        for (int i = amountArray.length - 1; i >= 0; i--) {
            if (a < 3) {
                stringBuilder.append(amountArray[i]);
                a++;
            } else if (b < 2) {
                if (b == 0) {
                    stringBuilder.append(",");
                    stringBuilder.append(amountArray[i]);
                    b++;
                } else {
                    stringBuilder.append(amountArray[i]);
                    b = 0;
                }
            }
        }
        return stringBuilder.reverse().toString();
    }

    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void highlightText(WebElement element, String color) {
        getJSExecutor().executeScript("arguments[0].style.background='" + color.toLowerCase() + "'", element);
    }

    public static void jsScrollDown(WebElement element) {
        getJSExecutor().executeScript("arguments[0].scrollIntoView();", element);
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static byte[] takeScreenShot(String fileName) {
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] picBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        File destFile = new File(Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png");
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }
}
