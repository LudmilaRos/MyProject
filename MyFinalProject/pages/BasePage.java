package MyFinalProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    public static ChromeDriver driver;
    public static Wait<WebDriver> wait;

    public void startDriver() {
        String driverPath = "C:\\Users\\Ludmila\\IdeaProjects\\SomeProjectGradle\\src\\test\\resources\\chromedriver.exe";
        System.setProperty("webDriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }


     public void stopDriver() {
        driver.quit();
     }
}

