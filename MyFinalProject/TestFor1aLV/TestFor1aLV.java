package MyFinalProject.TestFor1aLV;
import MyFinalProject.models.UserModel;
import MyFinalProject.pages.*;
import org.junit.jupiter.api.Test;

public class TestFor1aLV extends BasePage {

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    Helper helper = new Helper();
    UserModel userModel = new UserModel();
    OrderInfoPage orderInfoPage = new OrderInfoPage();



    @Test
    public void finalTest() throws InterruptedException {

        homePage.openBaseUrl();
     homePage.removeCookies();
     homePage.searchProduct("phone");
     helper.scrollDown(500);
     productPage.selectProductFromHomePage();
     helper.scrollDown(200);
     productPage.getNameOnProductPage();
     productPage.getPriceOnProductPage();
     productPage.addProductToCart();
     productPage.closePopUp();
     productPage.switchToParent();
     helper.scrollUp();
     productPage.goToCard();
     cartPage.getNameOnCartPageAndCompareWithNameOnProductPage();
     cartPage.getPriceOnCartPageAndCompareWithPriceOnProductPage();
     cartPage.completeOrder(userModel.getUserEmail());
     orderInfoPage.clickGetInOffice();
     orderInfoPage.clickDeliveryAddress();
     helper.scrollDown(700);
     orderInfoPage.enterUserName(userModel.getUserName());
     orderInfoPage.enterUserSurname(userModel.getUserSurname());
     orderInfoPage.enterPhoneNumber(userModel.getUserPhoneNr());
     helper.scrollDown(900);
     orderInfoPage.pressSaveDataButton();
     helper.scrollDown(900);
     orderInfoPage.pressContinue();
     orderInfoPage.paymentWay();
     stopDriver();
    }
}
