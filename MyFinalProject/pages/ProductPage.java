package MyFinalProject.pages;

import MyFinalProject.models.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    ProductModel productModel = new ProductModel();
    private final By selectProduct = By.xpath("//a[@data-gtm-link='787152']");
    private final By mainIcon = By.xpath("//img[@alt='1a.lv - interneta veikals']");
    private final By addToCardButton = By.id("add_to_cart_btn");
    private By priceOnPage = By.xpath("//span[@class='price']/child::span[1]");
    private By priceOnPageCurrency = By.xpath("//span[@class='price']/child::span[2]");
    private final By nameOnPage = By.xpath("//*[@class='product-righter google-rich-snippet']/h1");
    private final By popUpContainer = By.xpath("//div[@id='cart-popup-container']");
    private final By closePopUpWindow = By.xpath("//button[@class='fancybox-button fancybox-close-small']");
    private final By goToCard = By.xpath("//i[@class='cart-block__icon icon-svg']");

    public void selectProductFromHomePage() {
        driver.findElement(selectProduct).click(); }
    public void addProductToCart() {

        driver.findElement(addToCardButton).click();
    }

    public void getPriceOnProductPage() {
        String priceOnProductPage = driver.findElement(priceOnPage).getText() + " " + driver.findElement(priceOnPageCurrency).getText();
        System.out.println(priceOnProductPage);
        productModel.setProductPrice(priceOnProductPage);

    }
    public void getNameOnProductPage() {
        String productNameOnProductPage = driver.findElement(nameOnPage).getText();
        System.out.println(productNameOnProductPage);
        productModel.setProductName(productNameOnProductPage);
    }

    public void closePopUp () {
        wait.until((ExpectedConditions.visibilityOfElementLocated(popUpContainer)));
        driver.findElement(closePopUpWindow).click();
    }
    public void switchToParent() {
        driver.switchTo().parentFrame();
    }

    public void goToCard() {
        wait.until((ExpectedConditions.visibilityOfElementLocated(mainIcon)));
        driver.findElement(goToCard).click();
    }

}
