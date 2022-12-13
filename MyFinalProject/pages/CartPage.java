package MyFinalProject.pages;

import MyFinalProject.models.ProductInCartData;
import MyFinalProject.models.ProductModel;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;


public class CartPage extends BasePage {

    ProductInCartData productInCartData = new ProductInCartData();
    ProductModel productModel = new ProductModel();
    ProductPage productPage = new ProductPage();

    SoftAssertions softAssertions = new SoftAssertions();


    private final By lastPrice = By.id("cart-full-total-price");
    private final By nameOnSummary = By.xpath("//a[@class='detailed-cart-item__name-link']");
    private final By continueOrder = By.xpath("//input[@class='main-button cart-main-button']");
    private final By enterUnregisteredUserEmail = By.id("user_email");
    private final By pressContinueButton = By.xpath("//form[@id='new_user_guest']//input[@class='users-session-form__submit']");


   public void getNameOnCartPageAndCompareWithNameOnProductPage() {
        String nameOnCartPage = driver.findElement(nameOnSummary).getText();
        System.out.println(nameOnCartPage);
        productInCartData.setFinalProductName(nameOnCartPage);
        softAssertions.assertThat(nameOnCartPage).isEqualTo(productPage.productModel.getProductName());
    }
    public void getPriceOnCartPageAndCompareWithPriceOnProductPage() {
        String priceOnCartPage = driver.findElement(lastPrice).getText();
        System.out.println( priceOnCartPage);
        productInCartData.setFinalProductPrice(priceOnCartPage);
        softAssertions.assertThat(priceOnCartPage).isEqualTo(productPage.productModel.getProductPrice());
    }

    public void completeOrder(String userEmail) {
        driver.findElement(continueOrder).click();
        driver.findElements(enterUnregisteredUserEmail).get(1).sendKeys(userEmail);
        driver.findElement(pressContinueButton).click();
    }
}