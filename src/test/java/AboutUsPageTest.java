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

    @Story("Open About As Page")
    @Description("Should open About As Page")
    @Test(description = "The About As button on navbar should able to navigate to About As page", priority = 1)
    public void joinAboutUs_buttonLocator() {
        WebElement joinAboutUs_buttonLocator = driver.findElement(By.xpath("//*[@title = 'من نحن']"));
        joinAboutUs_buttonLocator.click();
    }

    @Story("The specialList title should Displayed")
    @Description(" Verify The specialList title should Displayed")
    @Test(description = "The specialList title should Displayed In specialList Page", priority = 2)
    public void titleInAboutAsIsDisplayed() {

        WebElement aboutUsTitle = driver.findElement(By.xpath("(//*[contains(text() , 'منصة فامكير')])[1]"));
        Assert.assertTrue(aboutUsTitle.isDisplayed());

    }

    @Story("The specialList title should Displayed")
    @Description(" Verify The specialList title should Displayed")
    @Test(description = "The specialList title should Displayed In specialList Page", priority = 3)
    public void subTitleInAboutAsIsDisplayed() {
        WebElement aboutUsSubTitle = driver.findElement(By.xpath("//*[contains(text() , 'بدأت من منطلق اهتمامنا بتعزيز الصحة')]"));
        Assert.assertTrue(aboutUsSubTitle.isDisplayed());

    }

    @Story("image about us")
    @Description("  The specialList profile image should Displayed in specialList card ")
    @Test(description = "Verify The specialList profile image is Displayed in specialList card", priority = 4)
    public void basicImageInAboutUsIsDisplayed() {
        WebElement aboutUsImage = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div/div[2]/div/div/img"));
        Assert.assertTrue(aboutUsImage.isDisplayed());
    }

    @Story("OurVisionCard")
    @Description("  The specialList card should Displayed in specialList Page")
    @Test(description = "Verify The specialList card is Displayed in specialList Page", priority = 5)
    public void ourVisionCardDisplayed() {
        WebElement ourVisionCard = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[1]/div"));
        Assert.assertTrue(ourVisionCard.isDisplayed());
    }

    @Story("OurVisionCard name")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 6)
    public void titleOurVisionCardDisplayed() {
        WebElement titleCart = driver.findElement(By.xpath("//*[contains(text() , 'رؤيتنا')]"));
        Assert.assertTrue(titleCart.isDisplayed());
    }

    @Story("The OurVisionCard Description should be displayed")
    @Description("  The specialList Description should Displayed in specialList card")
    @Test(description = "Verify The specialList Description is Displayed in specialList card ", priority = 7)
    public void theOurVisionCardDescriptionIsDisplayed() {
        WebElement ourVisionCardDescription = driver.findElement(By.xpath("//*[contains(text() , 'أن نكون منصة رائدة عربياً في مجال تقديم الاستشارات الأسرية والزوجية والدعم النفسي.')]"));
        Assert.assertTrue(ourVisionCardDescription.isDisplayed());
    }

    @Story("Our values")
    @Description("  The specialList card should Displayed in specialList Page")
    @Test(description = "Verify The specialList card is Displayed in specialList Page", priority = 8)
    public void ourvaluesCardDisplayed() {
        WebElement ourvaluesCard = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[2]/div"));
        Assert.assertTrue(ourvaluesCard.isDisplayed());
    }

    @Story("OurValues Card name")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 9)
    public void titleOurValuesCardDisplayed() {
        WebElement titleOurValuesCart = driver.findElement(By.xpath("//*[contains(text() , 'قيمنا')]"));
        Assert.assertTrue(titleOurValuesCart.isDisplayed());
    }

    @Story("OurValues CardList")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 10)
    public void listOurValuesCardDisplayed() {
        WebElement listOurValuesCart = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[2]/div/div[3]/ul"));
        Assert.assertTrue(listOurValuesCart.isDisplayed());
    }

    @Story("OurValues Card image list")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 11)
    public void imageListOurValuesCardDisplayed() {
        WebElement imagelistOurValuesCart = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[2]/div/div[3]/ul/li[1]/img"));
        Assert.assertTrue(imagelistOurValuesCart.isDisplayed());
    }

    @Story("OurValues Card title list")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 12)
    public void titleListOurValuesCardDisplayed() {
        WebElement titlelistOurValuesCart = driver.findElement(By.xpath("//*[contains(text() , 'خصوصية وأمان')]"));
        Assert.assertTrue(titlelistOurValuesCart.isDisplayed());
    }


    @Story("Join us as a consultant")
    @Description("  The specialList card should Displayed in specialList Page")
    @Test(description = "Verify The specialList card is Displayed in specialList Page", priority = 13)
    public void joinUsAsConsultantCardDisplayed() {
        WebElement joinUsAsConsultantCard = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[3]/div"));
        Assert.assertTrue(joinUsAsConsultantCard.isDisplayed());
    }

    @Story("Join us as a consultant Card name")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 14)
    public void titlejoinUsAsConsultanCardDisplayed() {
        WebElement titlejoinUsAsConsultanCart = driver.findElement(By.xpath("//*[contains(text() , 'انضم لنا كمستشار')]"));
        Assert.assertTrue(titlejoinUsAsConsultanCart.isDisplayed());
    }

    @Story("The Join us as a consultant Description should be displayed")
    @Description("  The specialList Description should Displayed in specialList card")
    @Test(description = "Verify The specialList Description is Displayed in specialList card ", priority = 15)
    public void thejoinUsAsConsultanDescriptionIsDisplayed() {
        WebElement joinUsAsConsultanCardDescription = driver.findElement(By.xpath("//*[contains(text() , 'إذا كنت مستشار معتمد ومهتم بالمجال كُن جزء من فريقنا وساهم بتعزيز الصحة النفسية بالمجتمع')]"));
        Assert.assertTrue(joinUsAsConsultanCardDescription.isDisplayed());
    }


    @Story("email in The Join us as a consultant cart button should be displayed")
    @Description("  The specialList profile page button should Displayed in specialList card")
    @Test(description = "Verify The specialList profile page button is Displayed in specialList card ", priority = 16)
    public void thejoinUsAsConsultanButtonIsDisplayed() {
        WebElement emailButton = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[3]/div/div[6]/a"));
        Assert.assertTrue(emailButton.isDisplayed());

    }

    @Story("email in The Join us as a consultant cart button should be Clickable")
    @Description("  The specialList profile page button should Clickable in specialList card")
    @Test(description = "Verify The specialList profile page button is Clickable in specialList card ", priority = 17)
    public void thejoinUsAsConsultanButtonIsClickable() {
        WebElement emailButtonClick = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div[3]/div/div[6]/a"));
        emailButtonClick.click();

    }

}


