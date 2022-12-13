package MyFinalProject.pages;

import org.openqa.selenium.JavascriptExecutor;

public class Helper extends BasePage{


    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) BasePage.driver;
        js.executeScript("window.scrollBy(0, -700)");

    }

    public void scrollDown(int verticalPixels) {
    driver.executeScript("window.scrollBy(0," + verticalPixels + ")", "");
}
}
