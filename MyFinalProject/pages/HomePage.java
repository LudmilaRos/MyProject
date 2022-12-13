package MyFinalProject.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

     String baseUrl = "https://www.1a.lv/";

    private final By removeCookiesNotification = By.xpath("//a[@href='javascript:void(0)']");
    private final By enterSearchQuery = By.id("q");
    private final By pressSearchProduct = By.className("main-search-submit");
    private By cookie = By.id("cookiebanner");


    public void openBaseUrl() {
        startDriver();
        driver.get(baseUrl);
    }

    public void removeCookies()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookie));
        driver.findElement(removeCookiesNotification).click();
    }

    public void searchProduct(String productSearchQuery) {
        driver.findElement(enterSearchQuery).sendKeys(productSearchQuery);
        driver.findElement(pressSearchProduct).click();
}
}