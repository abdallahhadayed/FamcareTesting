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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AcademyPageTest {

    public WebDriver driver;
    public static JavascriptExecutor javaSE;
    public Wait<WebDriver> wait;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
        driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        javaSE = (JavascriptExecutor) driver;
        driver.get("https://famcare.app");
    }

    @Story("Open AcademyPage")
    @Description("should open specialList page")
    @Test(description = "The Specialist button on navbar should able to navigate to specialList page", priority = 0)
    public void AcademyPageButtonInNavBarIsOpenAcademyPage() {
        WebElement AcademyPageButton = driver.findElement(By.xpath("//*[@title = 'الأكاديمية']"));
        AcademyPageButton.click();
    }
}
