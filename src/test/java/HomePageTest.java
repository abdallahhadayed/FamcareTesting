import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

import static java.lang.Thread.sleep;

public class HomePageTest {


    public WebDriver driver;
    public static JavascriptExecutor jse;
    public Wait<WebDriver> wait;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        jse = (JavascriptExecutor) driver;
        driver.get("https://famcare.app");
    }

    @Story("Load the home Page By Logo")
    @Description("The home page will be loaded for users")
    @Test (description = "Should be able to load home page",priority = 1)
    public void logoLinkLocator() {
        WebElement logo = driver.findElement(By.xpath("/html/body/header/div/div/nav/a/img"));
        Assert.assertTrue(logo.isDisplayed());
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.navigate().to("https://famcare.app/");

        driver.quit();

    }
}
