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

public class AboutUsPageTest {

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

    @Story("Open About Us Page")
    @Description("Should open About Us page")
    @Test(description = "The About Us button on navbar should able to navigate to About Us page", priority = 1)
    public void joinAboutUs_buttonLocator() {
        WebElement joinAboutUs_buttonLocator = driver.findElement(By.xpath("//*[@title = 'من نحن']"));
        joinAboutUs_buttonLocator.click();
    }

    @Story("The About As title should Displayed")
    @Description(" Verify The About Us title should Displayed in About Us page")
    @Test(description = "The About Us title should Displayed In About Us page", priority = 2)
    public void titleInAboutAsIsDisplayed() {

        WebElement aboutUsTitle = driver.findElement(By.xpath("(//*[contains(text() , 'منصة فامكير')])[1]"));
        Assert.assertTrue(aboutUsTitle.isDisplayed());

    }

    @Story("The About As subtitle should Displayed")
    @Description(" Verify The About Us subtitle should Displayed in About Us page")
    @Test(description = "The About Us subtitle should Displayed In About Us page", priority = 3)
    public void subTitleInAboutAsIsDisplayed() {
        WebElement aboutUsSubTitle = driver.findElement(By.xpath("//*[contains(text() , 'بدأت من منطلق اهتمامنا بتعزيز الصحة')]"));
        Assert.assertTrue(aboutUsSubTitle.isDisplayed());

    }

    @Story("image about us")
    @Description("  The About Us image should Displayed inAbout Us page")
    @Test(description = "Verify The About Us image is Displayed in About Us page", priority = 4)
    public void basicImageInAboutUsIsDisplayed() {
        WebElement aboutUsImage = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div/div[2]/div/div/img"));
        Assert.assertTrue(aboutUsImage.isDisplayed());
    }

    @Story("Our Vision Card")
    @Description("  The Our Vision Card should Displayed in About Us page")
    @Test(description = "Verify Our Vision Card is Displayed in About Us page", priority = 5)
    public void ourVisionCardDisplayed() {
        WebElement ourVisionCard = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[1]/div"));
        Assert.assertTrue(ourVisionCard.isDisplayed());
    }

    @Story("Our Vision Card name")
    @Description("The Our Vision Card name should Displayed in About Us page")
    @Test(description = "Verify The Our Vision Card name is Displayed in About Us page", priority = 6)
    public void titleOurVisionCardDisplayed() {
        WebElement titleCart = driver.findElement(By.xpath("//*[contains(text() , 'رؤيتنا')]"));
        Assert.assertTrue(titleCart.isDisplayed());
    }

    @Story("The OurVisionCard Description should be displayed")
    @Description("  The About Us  Description should Displayed in About Us page")
    @Test(description = "Verify The About Us Description is Displayed in About Us page", priority = 7)
    public void theOurVisionCardDescriptionIsDisplayed() {
        WebElement ourVisionCardDescription = driver.findElement(By.xpath("//*[contains(text() , 'أن نكون منصة رائدة عربياً في مجال تقديم الاستشارات الأسرية والزوجية والدعم النفسي.')]"));
        Assert.assertTrue(ourVisionCardDescription.isDisplayed());
    }

    @Story("Our values")
    @Description("  The Our values card should Displayed in About Us page")
    @Test(description = "Verify Our values card is Displayed in About Us page", priority = 8)
    public void ourvaluesCardDisplayed() {
        WebElement ourvaluesCard = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[2]/div"));
        Assert.assertTrue(ourvaluesCard.isDisplayed());
    }

    @Story("Our Values Card name")
    @Description("The Our Values Card name should Displayed in About Us page")
    @Test(description = "Verify Our Values Card name is Displayed in About Us page", priority = 9)
    public void titleOurValuesCardDisplayed() {
        WebElement titleOurValuesCart = driver.findElement(By.xpath("//*[contains(text() , 'قيمنا')]"));
        Assert.assertTrue(titleOurValuesCart.isDisplayed());
    }

    @Story("Our Values Card List")
    @Description("The Our Values Card List should Displayed in About Us page")
    @Test(description = "Verify Our Values Card List is Displayed in About Us page", priority = 10)
    public void listOurValuesCardDisplayed() {
        WebElement listOurValuesCart = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[2]/div/div[3]/ul"));
        Assert.assertTrue(listOurValuesCart.isDisplayed());
    }

    @Story("Our Values Card image list")
    @Description("The Our Values Card image list should Displayed in About Us page")
    @Test(description = "Verify Our Values Card image list is Displayed in About Us page", priority = 11)
    public void imageListOurValuesCardDisplayed() {
        WebElement imagelistOurValuesCart = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[2]/div/div[3]/ul/li[1]/img"));
        Assert.assertTrue(imagelistOurValuesCart.isDisplayed());
    }

    @Story("Our Values Card title list")
    @Description("The Our Values Card title list should Displayed in About Us page")
    @Test(description = "Verify The Our Values Card title list is Displayed in About Us page", priority = 12)
    public void titleListOurValuesCardDisplayed() {
        WebElement titlelistOurValuesCart = driver.findElement(By.xpath("//*[contains(text() , 'خصوصية وأمان')]"));
        Assert.assertTrue(titlelistOurValuesCart.isDisplayed());
    }


    @Story("Join us as a consultant")
    @Description("  TheJoin us as a consultant should Displayed in About Us page")
    @Test(description = "Verify Join us as a consultant is Displayed in About Us page", priority = 13)
    public void joinUsAsConsultantCardDisplayed() {
        WebElement joinUsAsConsultantCard = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[3]/div"));
        Assert.assertTrue(joinUsAsConsultantCard.isDisplayed());
    }

    @Story("Join us as a consultant Card name")
    @Description("The Join us as a consultant Card name should Displayed in About Us page")
    @Test(description = "Verify The Join us as a consultant Card name is Displayed in About Us page", priority = 14)
    public void titlejoinUsAsConsultanCardDisplayed() {
        WebElement titlejoinUsAsConsultanCart = driver.findElement(By.xpath("//*[contains(text() , 'انضم لنا كمستشار')]"));
        Assert.assertTrue(titlejoinUsAsConsultanCart.isDisplayed());
    }

    @Story("The Join us as a consultant Description should be displayed")
    @Description("The Join us as a consultant Description should be displayed in About Us page")
    @Test(description = "Verify Join us as a consultant Description should be displayed in About Us page", priority = 15)
    public void theJoinUsAsConsultanDescriptionIsDisplayed() {
        WebElement joinUsAsConsultanCardDescription = driver.findElement(By.xpath("//*[contains(text() , 'إذا كنت مستشار معتمد ومهتم بالمجال كُن جزء من فريقنا وساهم بتعزيز الصحة النفسية بالمجتمع')]"));
        Assert.assertTrue(joinUsAsConsultanCardDescription.isDisplayed());
    }


    @Story("email in The Join us as a consultant cart button should be displayed")
    @Description("email in The Join us as a consultant cart button should Displayed in About Us page")
    @Test(description = "Verify The email in The Join us as a consultant cart button Displayed in About Us page", priority = 16)
    public void theJoinUsAsConsultanButtonIsDisplayed() {
        WebElement emailButton = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[3]/div/div[6]/a"));
        Assert.assertTrue(emailButton.isDisplayed());

    }

    @Story("email in The Join us as a consultant cart button should be Clickable")
    @Description("The email in The Join us as a consultant cart button should Clickable in About Us page")
    @Test(description = "Verify The email in The Join us as a consultant cart button should Clickable in About Us page", priority = 17)
    public void thejoinUsAsConsultanButtonIsClickable() {
        WebElement emailButtonClick = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[3]/div/div[6]/a"));
        emailButtonClick.click();

    }

}


