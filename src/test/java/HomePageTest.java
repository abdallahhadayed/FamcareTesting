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


public class HomePageTest {
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

    @Story("Check the navbar is shown")
    @Description("open the home page and verify the navbar is shown")
    @Test(description = "Try to find the navigation bar section and confirm that it is correct if it is shown", priority = 0)
    public void navBarIsShown() {
        WebElement navbar = driver.findElement(By.xpath("//*[@id=\"navbarContent\"]"));
        Assert.assertTrue(navbar.isDisplayed());
    }

    @Story("Check the logo on navbar is shown")
    @Description("open the home page and verify if the logo on navbar is shown")
    @Test(description = "Try to find the logo and confirm its authenticity if it is shown", priority = 1)
    public void logoInNavBarIsShown() {
        WebElement logo = driver.findElement(By.className("navbar-brand"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Story("Check the logo on navbar is clickable and actionable")
    @Description("click on the logo on navbar and ensure if it clickable ")
    @Test(description = "click on the logo on the navigation bar and make sure it's clickable and open the home page, make sure any item is displayed on the home page", priority = 2)
    public void logoInNavBarIsClickable() {
        WebElement logo = driver.findElement(By.className("navbar-brand"));
        logo.click();
    }

    @Story("Check the specialList button on navbar is shown")
    @Description("verify the specialList button on navbar is Displayed and equal الأخصائيين")
    @Test(description = "find the specialList button element is Displayed and ensure if equal الأخصائيين", priority = 3)
    public void specialListButtonInNavBarIsShown() {
        WebElement buttonInNav = driver.findElement(By.xpath("//*[@title='الأخصائيين' and @class='nav-link']"));
        String getText = buttonInNav.getText();
        Assert.assertTrue(buttonInNav.isDisplayed());
        Assert.assertEquals(getText, "الأخصائيين");
    }

    @Story("Check the specialList button on navbar is clickable")
    @Description("Click on the special menu button and make sure it is clickable ")
    @Test(description = "Click the Specialized button and make sure it's clickable and open the Special Menu Page and make sure any item appears on the Special Menu Page", priority = 4)
    public void specialListButtonInNavBarIsClickable() {
        WebElement buttonInNav = driver.findElement(By.xpath("//*[@id=\"menu-item-1026\"]/a"));
        wait.until(ExpectedConditions.visibilityOf(buttonInNav));
        buttonInNav.click();
        WebElement searchBar = driver.findElement(By.name("search"));
        Assert.assertTrue(searchBar.isDisplayed());
        driver.navigate().back();
    }

    @Story("Check the page is scrolling")
    @Description("verify the page is scrolling Down correctly")
    @Test(description = "verify The blog page is Scrolling Down Correctly", priority = 5)
    public void thePageIsScrolling() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        sleep(3000);
    }

    @Story("Check the Arrow icon is shown")
    @Description("open the home page and scrolling down and check if the arrow icon is shown")
    @Test(description = "open the home page and scrolling down and check if the arrow icon is shown", priority = 6)
    public void findArrowAfterScrollIsShown() {
        WebElement arrowButton = driver.findElement(By.id("topcontrol"));
        Assert.assertTrue(arrowButton.isDisplayed());
    }

    @Story("Check the Arrow icon is clickable")
    @Description("open the home page and scrolling down and click on arrow button to ensure if it clickable")
    @Test(description = "open the home page and scrolling down and click on arrow button to ensure if it clickable and scrolling up again", priority = 7)
    public void findArrowAfterScrollIsClickable() throws InterruptedException {
        WebElement arrowButton = driver.findElement(By.id("topcontrol"));
        arrowButton.click();
        sleep(500);
    }

    @Story("Check the message icon is shown")
    @Description("open the home page check if the message icon is shown")
    @Test(description = "open the home page and check if the message icon is shown", priority = 8)
    public void messageIconIsDisplayed() throws InterruptedException {
        WebElement messageIcon = driver.findElement(By.xpath("/html/body/div[12]/div/div[1]"));
        wait.until(ExpectedConditions.visibilityOf(messageIcon));
        Assert.assertTrue(messageIcon.isDisplayed());
    }

    @Story("Check the message icon is clickable")
    @Description("open the home page and click on message button to ensure if it clickable")
    @Test(description = "open the home page and click on message button to ensure if it clickable and displayed messages menu", priority = 9)
    public void messageIconIsClickable() throws InterruptedException {
        WebElement messageIcon = driver.findElement(By.xpath("/html/body/div[12]/div/div[1]"));
        wait.until(ExpectedConditions.visibilityOf(messageIcon));
        messageIcon.click();
        sleep(3000);
        WebElement messageMenu = driver.findElement(By.xpath("/html/body/div[12]/div/div[1]"));
        sleep(6000);
        Assert.assertTrue(messageMenu.isDisplayed());
    }

    // section One ( Text Title & Image &  Button احجز جلستك الأولى //
    @Story("Check the title text is shown")
    @Description("verify the title on home page is shown and equal")
    @Test(description = "verify the title on home page is Displayed and equal", priority = 10)
    public void titleIsDisplayed() {
        WebElement title = driver.findElement(By.xpath("//*[text()='ابدأ جلستك الأولى مع مستشارك الي يناسبك مع خصم 60%']"));
        String getText = title.getText();

        Assert.assertTrue(title.isDisplayed());
        Assert.assertEquals(getText, "ابدأ جلستك الأولى مع مستشارك الي يناسبك مع خصم 60%");
    }

    @Story("Check the subTitle text is shown")
    @Description("verify the subTitle on home page is shown")
    @Test(description = "verify the subTitle on home page is shown and equal لاتستهين بخطواتك، أخصائيين مرخصين متوفرين بتخصصات مختلفة .. خذ القرار الآن", priority = 11)
    public void subTitleIsDisplayed() {
        WebElement subtitle = driver.findElement(By.xpath("//div[@id='heroText']/div/div[2]/p"));
        String getText = subtitle.getText();
        Assert.assertTrue(subtitle.isDisplayed());
        Assert.assertEquals(getText, "لاتستهين بخطواتك، أخصائيين مرخصين متوفرين بتخصصات مختلفة .. خذ القرار الآن ");
    }

    @Story("Check the book Your First Session Button  is shown")
    @Description("verify the book Your First Session button on home page is shown")
    @Test(description = "verify the bookAppointment button on home page is Check and equal", priority = 12)
    public void bookYourFirstSessionButtonIsDisplayed() {
        WebElement bookYourFirstSessionButton = driver.findElement(By.linkText("احجز جلستك الأولى"));
        Assert.assertTrue(bookYourFirstSessionButton.isDisplayed());
        String getText = bookYourFirstSessionButton.getText();
        Assert.assertEquals(getText, "احجز جلستك الأولى");

    }

    @Story("Ensure the bookAppointment button is clickable")
    @Description("verify the bookAppointment button on home page is clickable")
    @Test(description = "click on the bookAppointment button on home page and ensure if any element from new page is displayed", priority = 13)
    public void bookAppointmentButtonIsClickable() {
        WebElement bookButton = driver.findElement(By.linkText("احجز جلستك الأولى"));
        bookButton.click();
        String elementInNewWindow = driver.findElement(By.cssSelector(".product-header__title")).getText();
        System.out.println(elementInNewWindow);
        driver.navigate().back();

    }

    @Story("Ensure the image is Displayed")
    @Description("verify the image on home page is Displayed")
    @Test(description = "verify the image on home page is Displayed", priority = 14)
    public void bookImageIsDisplayed() {
        WebElement bookImage = driver.findElement(By.cssSelector("img[src='https://famcare.app/wp-content/uploads/2022/06/shutterstock_1989703088-1-1024x493.png']"));
        Assert.assertTrue(bookImage.isDisplayed());

    }

    // section Two ( Blog Section من المدونة //
    @Test(priority = 15)
    public void blogImageIsDisplayed() {
        javaSE.executeScript("window.scrollBy(0,3000)", "");
        WebElement image = driver.findElement(By.xpath("/html/body/div[1]/section[7]/div/div/div/div/div[3]/div/div/article[1]/div/div[1]/a"));
        Assert.assertTrue(image.isDisplayed());
    }

    @Test(priority = 16)
    public void postDataInfoIsDisplayed() {
        javaSE.executeScript("window.scrollBy(0,3000)", "");
        WebElement infoDate = driver.findElement(By.xpath("/html/body/div[1]/section[7]/div/div/div/div/div[3]/div/div/article[1]/div/div[2]/div[1]"));
        Assert.assertTrue(infoDate.isDisplayed());
    }

    @Test(priority = 17)
    public void categoryIsDisplayed() {
        javaSE.executeScript("window.scrollBy(0,3000)", "");
        WebElement category = driver.findElement(By.xpath("/html/body/div[1]/section[7]/div/div/div/div/div[3]/div/div/article[1]/div/div[2]/div[1]/a"));
        Assert.assertTrue(category.isDisplayed());
    }

    @Test(priority = 18)
    public void postTitleIsDisplayed() {
        javaSE.executeScript("window.scrollBy(0,3000)", "");
        WebElement specialized = driver.findElement(By.xpath("//*[contains(text() , 'استكشف مخاطر الاحتراق الوظيفي')]"));
        Assert.assertTrue(specialized.isDisplayed());
    }

    @Test(priority = 19)
    public void postSubTitleIsDisplayed() {
        javaSE.executeScript("window.scrollBy(0,3000)", "");
        WebElement specialized = driver.findElement(By.xpath("//*[contains(text() , 'هو ضعف الطاقة الفكرية والجسدية، وبالتالي النفسية تكاد تكون معدومة الراحة والرضا الوظيفي. كيف يأتي الاحتراق؟ يأتي من عدة نوافذ منها مرئية ومنها غير مرئية للموظف')]"));
        Assert.assertTrue(specialized.isDisplayed());
    }

    @Test(priority = 20)
    public void postCreatorProfileImageIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,3000)", "");
        WebElement profileImage = driver.findElement(By.xpath("/html/body/div[1]/section[7]/div/div/div/div/div[3]/div/div/article[1]/div/div[2]/div[2]/div/div/a/img"));
        sleep(1500);
        Assert.assertTrue(profileImage.isDisplayed());
    }

    @Test(priority = 21)
    public void postCreatorSpecializedIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,3100)", "");
        WebElement specialized = driver.findElement(By.xpath("/html/body/div[1]/section[7]/div/div/div/div/div[3]/div/div/article[1]/div/div[2]/div[2]/div/div/div/p"));
        sleep(700);
        Assert.assertTrue(specialized.isDisplayed());
    }

    @Test(priority = 22)
    public void detailsButtonIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,3100)", "");
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/section[7]/div/div/div/div/div[3]/div/div/article[1]/div/div[1]/a"));
        sleep(700);
        Assert.assertTrue(button.isDisplayed());
    }

    @Test(priority = 23)
    public void detailsButtonIsClickable() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,3100)", "");
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/section[7]/div/div/div/div/div[3]/div/div/article[1]/div/div[2]/div[2]/div/a"));
        sleep(3000);
        button.click();
        WebElement titleInSecondPage = driver.findElement(By.xpath("/html/body/div[1]/div/div/h1"));
        Assert.assertTrue(titleInSecondPage.isDisplayed());
    }

    @Test(priority = 24)
    public void readMoreButtonIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,3100)", "");
        WebElement button = driver.findElement(By.xpath("//*[contains(text() , 'اقرأ المزيد من المدونة')]"));
        sleep(700);
        Assert.assertTrue(button.isDisplayed());
    }

    @Test(priority = 25)
    public void readMoreButtonIsClickable() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,3100)", "");
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/section[7]/div/div/div/div/div[4]/a"));
        sleep(3000);
        button.click();
        WebElement titleInSecondPage = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/div[1]/div/a/h2"));
        Assert.assertTrue(titleInSecondPage.isDisplayed());
    }


    // section three (  من المشكلة إلى الحل في ثلاث خطوات فقط! //
    @Test(priority = 26)
    public void titleKcIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,2000)", "");
        WebElement titleKc = driver.findElement(By.xpath("//*[contains(text() , 'من المشكلة إلى الحل في ثلاث خطوات فقط')]"));
        sleep(500);
        Assert.assertTrue(titleKc.isDisplayed());
    }

    @Test(priority = 27)
    public void subTitleKcIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,2500)", "");
        WebElement subTitleKc = driver.findElement(By.xpath("//*[contains(text() , 'احجز استشارة مباشرة أو مجدولة بسريّة تامة من أي مكان وفي أي وقت، بأسعار رمزيّة ومناسبة للجميع')]"));
        sleep(500);
        Assert.assertTrue(subTitleKc.isDisplayed());
    }

    @Test(priority = 28)
    public void googlePlayButtonIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,2500)", "");
        WebElement googleButton = driver.findElement(By.xpath("//a[@href= 'https://play.google.com/store/apps/details?id=sa.app.famcare&referrer=utm_source%3Dwebsite%26utm_medium%3Dheader']"));
        Assert.assertTrue(googleButton.isDisplayed());
    }

    @Test(priority = 29)
    public void appleStoreButtonIsDisplayed() throws InterruptedException {
        javaSE.executeScript("window.scrollBy(0,2500)", "");
        WebElement appleButton = driver.findElement(By.xpath("//a[@href= 'https://apps.apple.com/us/app/famcare/id1517781498?utm_source=organic&utm_medium=website%20header&utm_campaign=a']"));
        sleep(500);
        Assert.assertTrue(appleButton.isDisplayed());
    }

    @Test(priority = 30)
    public void videoIsDisplayed() {
        javaSE.executeScript("window.scrollBy(0,2500)", "");
        WebElement video = driver.findElement(By.xpath("/html/body/div[1]/section[6]/div/div/div[3]/div/div/a/img"));
        Assert.assertTrue(video.isDisplayed());
    }

    // section four (  Feedback //
    @Test(priority = 31)
    public void personIconIsDisplayed() {
        javaSE.executeScript("window.scrollBy(0,1800)", "");
        WebElement icon = driver.findElement(By.xpath("/html/body/div[1]/section[4]/div/div/div[2]/div/div[1]/img"));
        Assert.assertTrue(icon.isDisplayed());
    }

    @Test(priority = 32)
    public void textNumberIsDisplayed() {
        WebElement textNumber = driver.findElement(By.xpath("//*[text() = '+500,000']"));
        Assert.assertTrue(textNumber.isDisplayed());
        String getText = textNumber.getText();
        Assert.assertEquals(getText, "+500,000");
    }

    @Test(priority = 33)
    public void subTitle3IsDisplayed() {
        WebElement subTitle = driver.findElement(By.xpath("//*[text() = 'مستفيد ومستفيدة']"));
        Assert.assertTrue(subTitle.isDisplayed());
        String getText = subTitle.getText();
        Assert.assertEquals(getText, "مستفيد ومستفيدة");
    }

    @Test(priority = 34)
    public void sliderIsDisplayed() {
        WebElement slider = driver.findElement(By.cssSelector(".kc-css-66359 .swiper-wrapper"));
        Assert.assertTrue(slider.isDisplayed());
    }

    @Test(priority = 35)
    public void feedBackCardIsDisplayed() {
        WebElement slider = driver.findElement(By.cssSelector(".swiper-slide:nth-child(4) > .testi-item"));
        Assert.assertTrue(slider.isDisplayed());
    }

    @Test(priority = 36)
    public void ratingIsDisplayed() {
        WebElement rate = driver.findElement(By.cssSelector(".swiper-slide:nth-child(5) .stars"));
        Assert.assertTrue(rate.isDisplayed());
    }

    @Test(priority = 37)
    public void commentIsDisplayed() {
        WebElement comment = driver.findElement(By.xpath("/html/body/div[1]/section[5]/div/div/div/div/div[2]/div/div/div[5]/div/div/div"));
    }

    @Test(priority = 38)
    public void commentOwnerNameIsDisplayed() {
        WebElement ownerName = driver.findElement(By.cssSelector(".swiper-slide:nth-child(5) h4"));
        Assert.assertTrue(ownerName.isDisplayed());
    }
}
