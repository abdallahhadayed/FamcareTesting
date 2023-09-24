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

public class SpecialistsPageTest {

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


    @Story("Open Specialist Page")
    @Description("should open specialList page")
    @Test(description = "The Specialist button on navbar should able to navigate to specialList page", priority = 0)
    public void specialistButtonInNavBarIsOpenSpecialListPage() {
        WebElement specialListButton = driver.findElement(By.xpath("//*[@title = 'الأخصائيين']"));
        specialListButton.click();
    }

    @Story("verify the page is scrolling")
    @Description("verify the page is scrolling Down correctly")
    @Test(description = "The page should Scrolling Down Correctly", priority = 18)
    public void thePageIsScrolling() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        sleep(2000);

    }

    @Story("The specialList title should Displayed")
    @Description(" Verify The specialList title should Displayed")
    @Test(description = "The specialList title should Displayed In specialList Page", priority = 1)
    public void titleInSpecialistIsDisplayed() {
        WebElement titleInSpecialist = driver.findElement(By.xpath("//*[contains(text() , 'أخصائيين فامكير')]"));
        Assert.assertTrue(titleInSpecialist.isDisplayed());
        String titleInSpecialistIsTrueText = driver.findElement(By.xpath("//*[contains(text() , 'أخصائيين فامكير')]")).getText();
        System.out.println(titleInSpecialistIsTrueText);

    }

    @Story("The specialList subTitle should Displayed")
    @Description(" Verify specialList subTitle should Displayed")
    @Test(description = "Verify The specialList subTitle should Displayed In specialList Page", priority = 3)
    public void subTitleInSpecialistIsDisplayed() {
        WebElement subTitleInSpecialist = driver.findElement(By.xpath("//p[contains(text() , 'المرّخصين معك ولأجلك في متنفّسك ومساحتك الآمنة')]"));
        Assert.assertTrue(subTitleInSpecialist.isDisplayed());
        String subTitleInSpecialistText = driver.findElement(By.xpath("//p[contains(text() , 'المرّخصين معك ولأجلك في متنفّسك ومساحتك الآمنة')]")).getText();
        System.out.println(subTitleInSpecialistText);

    }

    @Story("The specialList card should be displayed")
    @Description("  The specialList card should Displayed in specialList Page")
    @Test(description = "Verify The specialList card is Displayed in specialList Page", priority = 5)
    public void theSpecialistCardIsDisplayed() {
        WebElement specialListCard = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div"));
        Assert.assertTrue(specialListCard.isDisplayed());
    }

    @Story("The specialList profile image should be displayed")
    @Description("  The specialList profile image should Displayed in specialList card ")
    @Test(description = "Verify The specialList profile image is Displayed in specialList card", priority = 6)
    public void theSpecialistProfileImageIsDisplayed() {
        WebElement specialListProfileImage = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/a/img"));
        Assert.assertTrue(specialListProfileImage.isDisplayed());
    }

    @Story("The specialList Name should be displayed")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 7)
    public void theSpecialistNameIsDisplayed() {
        WebElement specialListName = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/h2/a"));
        Assert.assertTrue(specialListName.isDisplayed());
        String specialListNamePrint = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/h2/a")).getText();
        System.out.println(specialListNamePrint);

    }

    @Story("The specialList Rate should be displayed")
    @Description("  The specialList Rate should Displayed in specialList card")
    @Test(description = "Verify The specialList Rate is Displayed in specialList card ", priority = 9)
    public void theSpecialistRateIsDisplayed() {
        WebElement specialListRate = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/span"));
        Assert.assertTrue(specialListRate.isDisplayed());
    }

    @Story("The specialList Description should be displayed")
    @Description("  The specialList Description should Displayed in specialList card")
    @Test(description = "Verify The specialList Description is Displayed in specialList card ", priority = 10)
    public void theSpecialistDescriptionIsDisplayed() {
        WebElement specialListDescription = driver.findElement(By.xpath("//*[contains(text() , 'اختصاصي  تخاطب مستشار تعليمي وباحث أكاديمي؛ مؤلف ومعالج لإضطرابات اللغة والتواصل')]"));
        Assert.assertTrue(specialListDescription.isDisplayed());
        String specialListDescriptionPrint = driver.findElement(By.xpath("//*[contains(text() , 'اختصاصي  تخاطب مستشار تعليمي وباحث أكاديمي؛ مؤلف ومعالج لإضطرابات اللغة والتواصل')]")).getText();
        System.out.println(specialListDescriptionPrint);

    }

    @Story("The specialList profile page button should be displayed")
    @Description("  The specialList profile page button should Displayed in specialList card")
    @Test(description = "Verify The specialList profile page button is Displayed in specialList card ", priority = 11)
    public void theSpecialistProfilePageButtonIsDisplayed() {
        WebElement ProfilePageButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/a[1]"));
        Assert.assertTrue(ProfilePageButton.isDisplayed());

    }

    @Story("The specialList profile page button should be Clickable")
    @Description("  The specialList profile page button should Clickable in specialList card")
    @Test(description = "Verify The specialList profile page button is Clickable in specialList card ", priority = 12)
    public void theSpecialistProfilePageButtonIsClickable() throws InterruptedException {
        WebElement profilePageButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/a[1]"));
        profilePageButton.click();
        String nameOnProfilePage = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/h1")).getText();
        System.out.println(nameOnProfilePage);
        driver.navigate().back();
        sleep(5000);

    }


    @Story("The specialList Book an appointment button should be displayed")
    @Description("  The specialList Book an appointment button should Displayed in specialList card")
    @Test(description = "Verify The specialList Book an appointment button is Displayed in specialList card ", priority = 13)
    public void theSpecialistBookAnAppointmentButtonIsDisplayed() {
        WebElement bookAnAppointment = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/a[3]"));
        Assert.assertTrue(bookAnAppointment.isDisplayed());

    }

    @Story("The specialList profile page button should be Clickable")
    @Description("  The specialList profile page button should Clickable in specialList card")
    @Test(description = "Verify The specialList profile page button is Clickable in specialList card ", priority = 14)
    public void theSpecialistBookAnAppointmentButtonIsClickable() throws InterruptedException {
        WebElement profilePageButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/a[3]"));
        profilePageButton.click();
        sleep(5000);
        WebElement bookButtonOnSecondPage = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div/div[2]/div/div[3]/a"));
        driver.navigate().back();
        sleep(5000);
    }

    @Story("The search field should displayed")
    @Description("verify The search field should displayed")
    @Test(description = "Verify The search field is displayed ", priority = 15)
    public void theSearchFiledIsDisplayed() {
        WebElement searchField = driver.findElement(By.xpath("//*[@class  = 'search-text']"));
        Assert.assertTrue(searchField.isDisplayed());

    }

    @Story("The search field should Enabled")
    @Description("verify The search field should Enabled")
    @Test(description = "Verify The search field button is Enabled ", priority = 16)
    public void theSearchFiledIsEnabled() {
        WebElement searchField = driver.findElement(By.xpath("//*[@class  = 'search-text']"));
        Assert.assertTrue(searchField.isEnabled());

    }

    @Story(" search for specialList")
    @Description("verify when search for specialList should be displayed")
    @Test(description = "verify when search for specific specialList should be displayed", priority = 20)
    public void searchForSpecificSpecialList() throws InterruptedException {
        WebElement searchField = driver.findElement(By.xpath("//*[@class  = 'search-text']"));
        searchField.sendKeys("ريه");
        sleep(3000);
        searchField.submit();
        sleep(3000);
        driver.navigate().back();
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

    }


    @Story("The show more button should displayed")
    @Description("verify The show more button should displayed")
    @Test(description = "Verify The show more button is displayed ", priority = 19)
    public void theShowMoreButtonIsDisplayed() throws InterruptedException {
        WebElement showMoreButton = driver.findElement(By.xpath("//*[contains(@class, 'btn-gmore') and contains(@class, 'more-specialists')]"));
        wait.until(ExpectedConditions.visibilityOf(showMoreButton));
        sleep(5000);
        Assert.assertTrue(showMoreButton.isDisplayed());
    }

    @Story("The show more button should work correctly")
    @Description("verify The show more button should clickable and appear more specialLists cards")
    @Test(description = "Verify The show more button is clickable and appear more specialLists cards ", priority = 17)
    public void theShowMoreButtonIsClickable() throws InterruptedException {
        WebElement showMoreButton = driver.findElement(By.xpath("//*[contains(@class, 'btn-gmore') and contains(@class, 'more-specialists')]"));
        wait.until(ExpectedConditions.visibilityOf(showMoreButton));
        sleep(5000);
        showMoreButton.click();
        sleep(5000);
    }

    @Story("The google play button should displayed")
    @Description("verify The google play button should displayed ")
    @Test(description = "Verify The google play button is displayed", priority = 21)
    public void googlePlayButtonIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement button = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[1]/div/div[1]/a/img"));
        sleep(6000);
        Assert.assertTrue(button.isDisplayed());
    }

    @Story("The google play button should clickable")
    @Description("verify The google play button is clickable ")
    @Test(description = "Verify The google play button is clickable when click", priority = 22)
    public void googlePlayButtonIsClickable() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement button = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[1]/div/div[1]/a/img"));
        button.click();
        String id = driver.getWindowHandle();
        System.out.println(id);
        driver.switchTo().window(id);

    }

    @Story("The apple store button should displayed")
    @Description("verify The apple store button should displayed ")
    @Test(description = "Verify The apple store button is displayed", priority = 23)
    public void appleStoreButtonIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement button = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[1]/div/div[2]/a"));
        wait.until(ExpectedConditions.visibilityOf(button));
        Assert.assertTrue(button.isDisplayed());
    }

    //TODO ensure
    @Story("The apple store button should clickable")
    @Description("verify The apple store button is clickable ")
    @Test(description = "Verify The apple store button is clickable when click", priority = 24)
    public void appleStoreButtonIsClickable() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement button = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[1]/div/div[2]/a"));
        button.click();
        String id = driver.getWindowHandle();
        System.out.println(id);
        driver.switchTo().window(id);
    }

    //
    @Story("The subscription Button should displayed")
    @Description("verify The subscription button is displayed ")
    @Test(description = "Verify The subscription button is displayed", priority = 25)
    public void subscriptionButtonIsDisplayed() {
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement button = driver.findElement(By.xpath("//input[@value = 'اشتراك']"));
        Assert.assertTrue(button.isDisplayed());
    }

    //
    @Story("The subscription Button should clickable")
    @Description("verify The subscription button is clickable  ")
    @Test(description = "Verify The subscription button is clickable when click", priority = 26)
    public void secondSubscriptionButtonIsClickable() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement button = driver.findElement(By.xpath("//input[@value = 'اشتراك']"));
        button.click();

    }

    @Story("Click on subscription button with invalid email ")
    @Description("verify to click on subscription button with wrong email")
    @Test(description = "Verify to click on subscription button with invalid email format ", priority = 28)
    public void clickOnSubscriptionButtonWithInvalidEmail() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        WebElement input = driver.findElement(By.xpath("//*[@class = 'mail-list-email']"));
        WebElement button = driver.findElement(By.xpath("//input[@value = 'اشتراك']"));
        input.sendKeys("Welcome");
        button.click();

    }

    @Story("Click on subscription button with valid email ")
    @Description("verify to click on subscription button with correct email")
    @Test(description = "Verify to click on subscription button with valid email format ", priority = 27)
    public void clickSubscriptionButtonWithValidEmail() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,5000)", "");
        WebElement input = driver.findElement(By.xpath("//*[@class = 'mail-list-email']"));
        WebElement button = driver.findElement(By.xpath("//input[@value = 'اشتراك']"));
        input.sendKeys("abdallah.hadayed@gmail.com");
        button.click();
        sleep(2000);
        driver.navigate().back();
    }

    @Story("verify the image on footer is displayed ")
    @Description("verify the image is displayed ")
    @Test(description = "verify the image is displayed on footer", priority = 29)
    public void footerImageIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,5000)", "");
        WebElement image = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[2]/img"));
        sleep(1000);
        Assert.assertTrue(image.isDisplayed());

    }
}
