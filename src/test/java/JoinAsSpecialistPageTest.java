import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class JoinAsSpecialistPageTest {

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

    @Story("Open Join As Specialist Page")
    @Description("Should open Join As specialList page")
    @Test(description = "The Specialist button on navbar should able to navigate to Join As specialList page", priority = 1)
    public void joinAsSpecialist_buttonLocator() {
        WebElement joinAsspecialListButton = driver.findElement(By.xpath("//*[@id='navbarContent']/button"));
        joinAsspecialListButton.click();
    }

    @Story("Close Join As Specialist Page")
    @Description("Should Close Join As specialList page")
    @Test(description = "The Specialist button on navbar should able to navigate to Close Join As specialList page", priority = 2)
    public void joinAsSpecialistForm_closeBtn() {
        WebElement close_joinAsSpecialListButton = driver.findElement(By.xpath("//*[@id=\"joinUsModal\"]/div/div/button/span"));
        close_joinAsSpecialListButton.click();
    }

    @Story("Should Be Able ToFill Join As Specialist Form")
    @Description("Should Be Able ToFill Join As Specialist Form")
    @Test(priority = 3)
    public void shouldBeAbleToFillJoinAsSpecialistForm() {
        WebElement joinAsspecialListButton = driver.findElement(By.xpath("//*[@id='navbarContent']/button"));
        joinAsspecialListButton.click();


        String your_name = Faker.instance().name().name();
        WebElement joinAsSpecialistForm_yourName_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='your-name']"));
        joinAsSpecialistForm_yourName_inputLocator.sendKeys(your_name);
        System.out.println(your_name);
        WebElement close_joinAsSpecialListButton = driver.findElement(By.xpath("//*[@id=\"joinUsModal\"]/div/div/button/span"));
        close_joinAsSpecialListButton.click();

    }

    @Story("Join As Specialist Form_yourPhone_inputLocator")
    @Description("Join As Specialist Form_yourPhone_inputLocator")
    @Test(priority = 4)
    public void joinAsSpecialistForm_yourPhone_inputLocator() {
        WebElement joinAsspecialListButton = driver.findElement(By.xpath("//*[@id='navbarContent']/button"));
        joinAsspecialListButton.click();


        String your_phone = Faker.instance().phoneNumber().phoneNumber();
        WebElement joinAsSpecialistForm_yourPhone_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='your-phone']"));
        joinAsSpecialistForm_yourPhone_inputLocator.sendKeys(your_phone);
        System.out.println(your_phone);
        WebElement close_joinAsSpecialListButton = driver.findElement(By.xpath("//*[@id=\"joinUsModal\"]/div/div/button/span"));
        close_joinAsSpecialListButton.click();
    }

    @Story("join As Specialist Form_degree_inputLocator")
    @Description("join As Specialist Form_degree_inputLocator")
    @Test(priority = 5)
    public void joinAsSpecialistForm_degree_inputLocator() {
        WebElement joinAsspecialListButton = driver.findElement(By.xpath("//*[@id='navbarContent']/button"));
        joinAsspecialListButton.click();


        String your_degree = Faker.instance().university().name();
        WebElement joinAsSpecialistForm_degree_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='degree']"));
        joinAsSpecialistForm_degree_inputLocator.sendKeys(your_degree);
        System.out.println(your_degree);
        WebElement close_joinAsSpecialListButton = driver.findElement(By.xpath("//*[@id=\"joinUsModal\"]/div/div/button/span"));
        close_joinAsSpecialListButton.click();
    }

    @Story("join As Specialist Form_specialization_inputLocator")
    @Description("join As Specialist Form_specialization_inputLocator")
    @Test(priority = 6)
    public void joinAsSpecialistForm_specialization_inputLocator() {
        WebElement joinAsspecialListButton = driver.findElement(By.xpath("//*[@id='navbarContent']/button"));
        joinAsspecialListButton.click();


        String your_specialization = Faker.instance().educator().course();
        WebElement joinAsSpecialistForm_specialization_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='specialization']"));
        joinAsSpecialistForm_specialization_inputLocator.sendKeys(your_specialization);
        System.out.println(your_specialization);
        WebElement close_joinAsSpecialListButton = driver.findElement(By.xpath("//*[@id=\"joinUsModal\"]/div/div/button/span"));
        close_joinAsSpecialListButton.click();
    }

    @Story("join As Specialist Form_experience_inputLocator")
    @Description("join As Specialist Form_experience_inputLocator")
    @Test(priority = 7)
    public void joinAsSpecialistForm_experience_inputLocator() {
        WebElement joinAsspecialListButton = driver.findElement(By.xpath("//*[@id='navbarContent']/button"));
        joinAsspecialListButton.click();

        String your_experience = Faker.instance().number().numberBetween(1, 10) + "";
        WebElement joinAsSpecialistForm_experience_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='experience']"));
        joinAsSpecialistForm_experience_inputLocator.sendKeys(your_experience);
        System.out.println(your_experience);
        WebElement close_joinAsSpecialListButton = driver.findElement(By.xpath("//*[@id=\"joinUsModal\"]/div/div/button/span"));
        close_joinAsSpecialListButton.click();
    }

    @Story("join As Specialist Form_socialmedia_inputLocator")
    @Description("join As Specialist Form_socialmedia_inputLocator")
    @Test(priority = 8)
    public void joinAsSpecialistForm_socialmedia_inputLocator() {
        WebElement joinAsspecialListButton = driver.findElement(By.xpath("//*[@id='navbarContent']/button"));
        joinAsspecialListButton.click();


        String your_socialmedia = Faker.instance().animal().name();
        WebElement joinAsSpecialistForm_socialmedia_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='socialmedia']"));
        joinAsSpecialistForm_socialmedia_inputLocator.sendKeys(your_socialmedia);
        System.out.println(your_socialmedia);
        WebElement close_joinAsSpecialListButton = driver.findElement(By.xpath("//*[@id=\"joinUsModal\"]/div/div/button/span"));
        close_joinAsSpecialListButton.click();
    }

    @Story("Filling all form")
    @Description("Filling all form")
    @Test(priority = 9)
    public void shouldBeAbleToOpenJoinAsSpecialistForm() throws InterruptedException {
        WebElement joinAsspecialListButton = driver.findElement(By.xpath("//*[@id='navbarContent']/button"));
        joinAsspecialListButton.click();

        String your_name = Faker.instance().name().name();
        WebElement joinAsSpecialistForm_yourName_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='your-name']"));
        joinAsSpecialistForm_yourName_inputLocator.sendKeys(your_name);
        System.out.println(your_name);

        String your_phone = Faker.instance().phoneNumber().phoneNumber();
        WebElement joinAsSpecialistForm_yourPhone_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='your-phone']"));
        joinAsSpecialistForm_yourPhone_inputLocator.sendKeys(your_phone);
        System.out.println(your_phone);

        String your_degree = Faker.instance().university().name();
        WebElement joinAsSpecialistForm_degree_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='degree']"));
        joinAsSpecialistForm_degree_inputLocator.sendKeys(your_degree);
        System.out.println(your_degree);

        String your_specialization = Faker.instance().educator().course();
        WebElement joinAsSpecialistForm_specialization_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='specialization']"));
        joinAsSpecialistForm_specialization_inputLocator.sendKeys(your_specialization);
        System.out.println(your_specialization);

        String your_experience = Faker.instance().number().numberBetween(1, 10) + "";
        WebElement joinAsSpecialistForm_experience_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='experience']"));
        joinAsSpecialistForm_experience_inputLocator.sendKeys(your_experience);
        System.out.println(your_experience);

        String your_socialmedia = Faker.instance().animal().name();
        WebElement joinAsSpecialistForm_socialmedia_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[name='socialmedia']"));
        joinAsSpecialistForm_socialmedia_inputLocator.sendKeys(your_socialmedia);
        System.out.println(your_socialmedia);

        WebElement joinAsSpecialistForm_send_inputLocator = driver.findElement(By.cssSelector("#joinUsModal form input[type='submit']\n"));
        joinAsSpecialistForm_send_inputLocator.click();

        sleep(5000);


        String successMessage = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/div[8]")).getText();
        sleep(5000);
        System.out.println(successMessage);

        Assert.assertEquals(successMessage, "شكراً لك. لقد تم الإرسال بنجاح.");

        WebElement close_joinAsSpecialListButton = driver.findElement(By.xpath("//*[@id=\"joinUsModal\"]/div/div/button/span"));
        close_joinAsSpecialListButton.click();
    }
}
