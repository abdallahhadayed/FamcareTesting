import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static java.lang.Thread.sleep;

public class BlogPageTest {

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

    @Story("the Blog button is displayed")
    @Description("should the Blog button on navbar is displayed")
    @Test(description = "The Blog button on navbar should be displayed", priority = 0)
    public void blogButtonInNavBarIsDisable() {
        WebElement blogButton = driver.findElement(By.xpath("//*[@title = 'المدونة']"));
        Assert.assertTrue(blogButton.isDisplayed());
    }
    @Story("Open Blog Page")
    @Description("should open Blog page")
    @Test(description = "The Blog button on navbar should able to navigate to Blog page", priority = 1)
    public void blogButtonInNavBarIsOpenBlogPage() {
        WebElement blogButton = driver.findElement(By.xpath("//*[@title = 'المدونة']"));
        blogButton.click();
    }

    @Story("verify the page is scrolling")
    @Description("verify the page is scrolling Down correctly")
    @Test(description = "verify The blog page is Scrolling Down Correctly", priority = 36)
    public void thePageIsScrolling() throws InterruptedException {
        WebElement b = driver.findElement(By.xpath("//input[@value = 'اشتراك']"));
        b.sendKeys(Keys.PAGE_DOWN);
        javaSE.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        sleep(2000);

    }



    @Story("verify the sliders sections is displayed")
    @Description("verify the sliders sections is displayed on blog page")
    @Test(description = "verify the sliders sections is displayed on blog page", priority = 2)
    public void theSlidersSectionIsDisplayed()  {
        WebElement mainSlider = driver.findElement(By.xpath("//*[contains(@class , 'swiper-slide') and contains(@class , 'swiper-slide-active')]"));
        Assert.assertTrue(mainSlider.isDisplayed());

    }

    @Story("verify the blog image in slider is displayed")
    @Description(" the blog image in slider should displayed")
    @Test(description = "verify if the blog image in slider is displayed", priority = 3)
    public void theBlogImageInSliderIsDisplayed() throws InterruptedException {
        WebElement image = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/div[2]/div/img"));
        Assert.assertTrue(image.isDisplayed());
    }

    @Story("verify the blog published date in slider is displayed")
    @Description(" the blog published date in slider should displayed")
    @Test(description = "verify if the blog published date in slider is displayed", priority = 4)
    public void theBlogPublishedDateInSliderIsDisplayed() throws InterruptedException {
        WebElement publishedDate = driver.findElement(By.cssSelector(".swiper-slide-active .date"));
        Assert.assertTrue(publishedDate.isDisplayed());

    }

    @Story("verify the blog Specialization in slider is displayed")
    @Description(" the blog Specialization in slider should displayed")
    @Test(description = "verify if the blog Specialization in slider is displayed", priority = 5)
    public void theBlogSpecializationInSliderIsDisplayed() throws InterruptedException {
        WebElement blogSpecialization = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/div[1]/div/div[1]/p[2]/a"));
        Assert.assertTrue(blogSpecialization.isDisplayed());

    }


    @Story("verify the blog Specialization in slider is clickable")
    @Description(" the blog Specialization in slider should clickable")
    @Test(description = "verify if the blog Specialization in slider is clickable", priority = 6)
    public void theBlogSpecializationInSliderIsClickable() throws InterruptedException {
        WebElement blogSpecialization = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/div[1]/div/div[1]/p[2]/a"));
        blogSpecialization.click();
        WebElement titleInSecondPage = driver.findElement(By.cssSelector(".col-md-6:nth-child(2) h3 > a"));
        Assert.assertTrue(titleInSecondPage.isDisplayed());
        driver.navigate().back();

    }

    @Story("verify the blog Title in slider is displayed")
    @Description(" the blog Title in slider should displayed")
    @Test(description = "verify if the blog Title in slider is displayed", priority = 7)
    public void theBlogTitleInSliderIsDisplayed() throws InterruptedException {
        WebElement blogTitle = driver.findElement(By.cssSelector(".swiper-slide-active .featured-blog__title"));
        Assert.assertTrue(blogTitle.isDisplayed());
    }

    @Story("verify the blog Title in slider is clickable")
    @Description(" the blog Title in slider should clickable")
    @Test(description = "verify if the blog Title in slider is clickable and navigate to same blog page", priority = 8)
    public void theBlogTitleInSliderIsClickable() throws InterruptedException {
        WebElement blogTitle = driver.findElement(By.cssSelector(".swiper-slide-active .featured-blog__title"));
        blogTitle.click();
        WebElement titleInSecondPage = driver.findElement(By.cssSelector(".post_title"));
        sleep(2000);
        Assert.assertTrue(titleInSecondPage.isDisplayed());
        driver.navigate().back();
    }

    @Story("verify the blog subTitle in slider is displayed")
    @Description(" the blog subTitle in slider should displayed")
    @Test(description = "verify if the blog subTitle in slider is displayed", priority = 9)
    public void theBlogSubTitleInSliderIsDisplayed() throws InterruptedException {
        WebElement blogSubTitle = driver.findElement(By.cssSelector(".swiper-slide-active .featured-blog__excerpt"));
        Assert.assertTrue(blogSubTitle.isDisplayed());
    }

    @Story("verify the profile image of blog publisher in slider is displayed")
    @Description(" the profile image of blog publisher in slider should displayed")
    @Test(description = "verify if the profile image of blog publisher in slider is displayed", priority = 10)
    public void theProfileImageOfBlogPublisherInSliderIsDisplayed() throws InterruptedException {
        WebElement profileImage = driver.findElement(By.cssSelector(".swiper-slide-active .featured-blog__excerpt"));
        Assert.assertTrue(profileImage.isDisplayed());
    }

    @Story("verify the profile image of blog publisher in slider is clickable")
    @Description(" the profile image of blog publisher in slider should clickable")
    @Test(description = "verify if the profile image of blog publisher in slider is clickable", priority = 11)
    public void theProfileImageOfBlogPublisherInSliderIsClickable() throws InterruptedException {
        WebElement blogTitle = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/div[1]/div/div[2]/div[1]/a"));
        blogTitle.click();
        WebElement titleInSecondPage = driver.findElement(By.cssSelector("h1:nth-child(2)"));
        Assert.assertTrue(titleInSecondPage.isDisplayed());
        driver.navigate().back();

    }
    @Story("verify the name of blog publisher in slider is displayed")
    @Description(" the name of blog publisher in slider should displayed")
    @Test(description = "verify if the name of blog publisher in slider is displayed", priority = 12)
    public void theNameOfBlogPublisherInSliderIsDisplayed() throws InterruptedException {
        WebElement name = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/div[1]/div/div[2]/div[2]/p[1]/a"));
        Assert.assertTrue(name.isDisplayed());
    }

    @Story("verify the name of blog publisher in slider is clickable")
    @Description(" the name of blog publisher in slider should clickable")
    @Test(description = "verify if the name of blog publisher in slider is clickable", priority = 13)
    public void theNameOfBlogPublisherInSliderIsClickable() throws InterruptedException {
        WebElement blogTitle = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/div[1]/div/div[2]/div[1]/a"));
        blogTitle.click();
        WebElement titleInSecondPage = driver.findElement(By.cssSelector("h1:nth-child(2)"));
        Assert.assertTrue(titleInSecondPage.isDisplayed());
        driver.navigate().back();
    }

    @Story("verify the specialization of blog publisher in slider is displayed")
    @Description(" the specialization of blog publisher in slider should displayed")
    @Test(description = "verify if the specialization of blog publisher in slider is displayed", priority = 14)
    public void theSpecializationOfBlogPublisherInSliderIsDisplayed() throws InterruptedException {
        WebElement specialization = driver.findElement(By.cssSelector(".swiper-slide-active .blog-post__author-specialization"));
        Assert.assertTrue(specialization.isDisplayed());
    }


    @Story("verify the share a blog on facebook button on the slider is displayed")
    @Description(" The share blog on facebook button on the slider should displayed")
    @Test(description = "verify if the share blog on facebook button in slider is displayed", priority = 15)
    public void theShareOnFacebookButtonInSliderIsDisplayed() throws InterruptedException {
        WebElement name = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/div/a[1]"));
        Assert.assertTrue(name.isDisplayed());
    }

    @Story("verify the share a blog on facebook button on the slider is clickable")
    @Description(" The share blog on facebook button on the slider should clickable")
    @Test(description = "verify if the share blog on facebook button in slider is clickable", priority = 16)
    public void theShareOnFacebookButtonInSliderIsClickable() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/div/a[1]"));
        button.click();
        String originalWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break; // قم بالتبديل إلى أول نافذة جديدة واستمر
            }
        }
        WebElement elementInNewWindow = driver.findElement(By.xpath("//*[contains(text() , 'Happening now')]"));
        Assert.assertTrue(elementInNewWindow.isDisplayed());
        driver.close();
        driver.switchTo().window(originalWindowHandle);
    }

    @Story("verify the share a blog on twitter button on the slider is displayed")
    @Description(" The share blog on twitter button on the slider should displayed")
    @Test(description = "verify if the share blog on twitter button in slider is displayed", priority = 17)
    public void theShareOnTwitterButtonInSliderIsDisplayed() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("(//img[@alt='مشاركة المقال عبر تويتر'])[2]"));
        Assert.assertTrue(button.isDisplayed());
    }


    @Story("verify the share a blog on twitter button on the slider is clickable")
    @Description(" The share blog on twitter button on the slider should clickable")
    @Test(description = "verify if the share blog on twitter button in slider is clickable", priority = 18)
    public void theShareOnTwitterButtonInSliderIsClickable() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("(//img[@alt='مشاركة المقال عبر تويتر'])[2]"));
        button.click();
        String originalWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break; // قم بالتبديل إلى أول نافذة جديدة واستمر
            }
        }
        WebElement elementInNewWindow = driver.findElement(By.id("homelink"));
        Assert.assertTrue(elementInNewWindow.isDisplayed());
        driver.close();
        driver.switchTo().window(originalWindowHandle);
    }

    @Story("verify the details button of blog is displayed")
    @Description(" verify the details button of blog in slider should displayed")
    @Test(description = "verify if the details button of blog in slider is displayed", priority = 19)
    public void detailsButtonInSliderIsDisplayed() throws InterruptedException {
        WebElement button = driver.findElement(By.cssSelector(".swiper-slide-active .btn-primary"));
        Assert.assertTrue(button.isDisplayed());
    }

    @Story("verify the details button of blog is clickable")
    @Description(" verify the details button of blog in slider should clickable")
    @Test(description = "verify if the details button of blog in slider is clickable", priority = 20)
    public void detailsButtonInSliderIsClickable() throws InterruptedException {
//        jse.executeScript("window.scrollBy(0,3100)", "");
        WebElement button = driver.findElement(By.cssSelector(".swiper-slide-active .btn-primary"));
        button.click();
        WebElement titleInSecondPage = driver.findElement(By.xpath("/html/body/div[1]/div/div/h1"));
        Assert.assertTrue(titleInSecondPage.isDisplayed());
        driver.navigate().back();
    }


    @Story("verify the blog image in main page is displayed")
    @Description(" the blog image in main page should displayed")
    @Test(description = "verify if the blog image in main page is displayed", priority = 21)
    public void theBlogImageInMainPageIsDisplayed() throws InterruptedException {
        WebElement publishedDate = driver.findElement(By.xpath("/html/body/section[3]/div/div/article[1]/div[1]/a"));
        Assert.assertTrue(publishedDate.isDisplayed());
    }

    @Story("verify the blog image in main page is clickable")
    @Description(" the blog image in main page should clickable")
    @Test(description = "verify if the blog image in main page is clickable", priority = 22)
    public void theBlogImageInMainPageIsClickable() throws InterruptedException {
        WebElement publishedDate = driver.findElement(By.xpath("/html/body/section[3]/div/div/article[1]/div[1]/a"));
        publishedDate.click();
        WebElement titleInSecondPage = driver.findElement(By.cssSelector(".post_title"));
        Assert.assertTrue(titleInSecondPage.isDisplayed());
        driver.navigate().back();
    }

    @Story("verify the blog published date in main page is displayed")
    @Description("the blog published date in main page should displayed")
    @Test(description = "verify if the blog published date in main page is displayed", priority = 23)
    public void theBlogPublishedDateInMainPageIsDisplayed() throws InterruptedException {
        WebElement publishedDate = driver.findElement(By.xpath("//time[contains(., '10 يوليو 2023')]"));
        Assert.assertTrue(publishedDate.isDisplayed());
    }

    @Story("verify the blog Specialization in main page is displayed")
    @Description("the blog Specialization in main page should displayed")
    @Test(description = "verify if the blog Specialization in main page is displayed", priority = 24)
    public void theBlogSpecializationInMainPageIsDisplayed() {
        WebElement blogSpecialization = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) .post-meta > a"));
        Assert.assertTrue(blogSpecialization.isDisplayed());

    }

    @Story("verify the blog Specialization in main page is clickable")
    @Description("the blog Specialization in main page should clickable")
    @Test(description = "verify if the blog Specialization in main page is clickable", priority = 25)
    public void theBlogSpecializationInMainPageIsClickable() throws InterruptedException {
        WebElement blogSpecialization = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) .post-meta > a"));
        blogSpecialization.click();
        WebElement titleInSecondPage = driver.findElement(By.cssSelector(".col-md-6:nth-child(2) h3 > a"));
        Assert.assertTrue(titleInSecondPage.isDisplayed());
        driver.navigate().back();


    }

    @Story("verify the blog Title in main page is displayed")
    @Description("the blog Title in main page should displayed")
    @Test(description = "verify if the blog Title in main page is displayed", priority = 26)
    public void theBlogTitleInMainPageIsDisplayed() throws InterruptedException {
        WebElement blogTitle = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) > .blog-data .specialist_event"));
        Assert.assertTrue(blogTitle.isDisplayed());
    }
    //
    @Story("verify the blog Title in main page is clickable")
    @Description(" the blog Title in main page should clickable")
    @Test(description = "verify if the blog Title in main page is clickable and navigate to same blog page", priority = 27)
    public void theBlogTitleInMainPageIsClickable() throws InterruptedException {
        WebElement blogTitle = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) > .blog-data .specialist_event"));
        blogTitle.click();
        WebElement titleInSecondPage = driver.findElement(By.cssSelector(".post_title"));
        driver.navigate().back();
    }

    @Story("verify the blog subTitle in main page is displayed")
    @Description("the blog subTitle in main page should displayed")
    @Test(description = "verify if the blog subTitle in main page is displayed", priority = 28)
    public void theBlogSubTitleInMainPageIsDisplayed()  {
        WebElement blogSubTitle = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) .blog-excerpt"));
        Assert.assertTrue(blogSubTitle.isDisplayed());
    }

    @Story("verify the profile image of blog publisher in main page is displayed")
    @Description(" the profile image of blog publisher in main page should displayed")
    @Test(description = "verify if the profile image of blog publisher in main page is displayed", priority = 29)
    public void theProfileImageOfBlogPublisherInMainPageIsDisplayed() throws InterruptedException {
        WebElement profileImage = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) .avatar"));
        Assert.assertTrue(profileImage.isDisplayed());
    }

    @Story("verify the profile image of blog publisher in main page is clickable")
    @Description("the profile image of blog publisher in main page should clickable")
    @Test(description = "verify if the profile image of blog publisher in main page is clickable", priority = 30)
    public void theProfileImageOfBlogPublisherInMainPageIsClickable() throws InterruptedException {
        WebElement blogTitle = driver.findElement(By.xpath("/html/body/section[3]/div/div/article[1]/div[2]/div[2]/div/div/a/img"));
        blogTitle.click();
        WebElement titleInSecondPage = driver.findElement(By.cssSelector("h1:nth-child(2)"));
        driver.navigate().back();
    }
    @Story("verify the name of blog publisher in main page is displayed")
    @Description(" the name of blog publisher in main page should displayed")
    @Test(description = "verify if the name of blog publisher in main page is displayed", priority = 31)
    public void theNameOfBlogPublisherInMainPageIsDisplayed() throws InterruptedException {
        WebElement name = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) .m-0 > .author-name"));
        Assert.assertTrue(name.isDisplayed());
    }

    @Story("verify the name of blog publisher in main page is clickable")
    @Description(" the name of blog publisher in main page should clickable")
    @Test(description = "verify if the name of blog publisher in main page is clickable", priority = 32)
    public void theNameOfBlogPublisherInMainPageIsClickable() throws InterruptedException {
        WebElement blogTitle = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) .m-0 > .author-name"));
        blogTitle.click();
        WebElement titleInSecondPage = driver.findElement(By.cssSelector("h1:nth-child(2)"));
        driver.navigate().back();

    }

    @Story("verify the specialization of blog publisher in main page is displayed")
    @Description(" the specialization of blog publisher in main page should displayed")
    @Test(description = "verify if the specialization of blog publisher in main page is displayed", priority = 33)
    public void theSpecializationOfBlogPublisherInMainPageIsDisplayed() throws InterruptedException {
        WebElement specialization = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) .m-0:nth-child(2)"));
        Assert.assertTrue(specialization.isDisplayed());
    }



    @Story("verify the details button of blog is displayed")
    @Description(" verify the details button of blog in main page should displayed")
    @Test(description = "verify if the details button of blog in main page is displayed", priority = 34)
    public void detailsButtonIsDisplayed()  {
        WebElement button = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) .btn"));
        Assert.assertTrue(button.isDisplayed());
    }

    @Story("verify the details button of blog is clickable")
    @Description(" verify the details button of blog in main page should clickable")
    @Test(description = "verify if the details button of blog in main page is clickable", priority = 35)
    public void detailsButtonIsClickable() throws InterruptedException {
//        jse.executeScript("window.scrollBy(0,3100)", "");
        WebElement button = driver.findElement(By.cssSelector(".col-md-4:nth-child(1) .btn"));
        button.click();
        WebElement titleInSecondPage = driver.findElement(By.xpath("/html/body/div[1]/div/div/h1"));
        Assert.assertTrue(titleInSecondPage.isDisplayed());
        driver.navigate().back();
    }

    @Story("The show more button should displayed")
    @Description("verify The show more button should displayed")
    @Test(description = "Verify The show more button is displayed ", priority = 37)
    public void theShowMoreButtonIsDisplayed() {
        WebElement showMoreButton = driver.findElement(By.xpath("//*[contains(@class, 'btn-gmore') and contains(@class, 'blog-more')]"));
        wait.until(ExpectedConditions.visibilityOf(showMoreButton));
        Assert.assertTrue(showMoreButton.isDisplayed());

    }

    @Story("The show more button should work correctly")
    @Description("verify The show more button should clickable and appear more blogs cards")
    @Test(description = "Verify The show more button is clickable and appear more blogs cards ", priority = 38)
    public void theShowMoreButtonIsClickable() throws InterruptedException {

        WebElement showMoreButton = driver.findElement(By.xpath("//*[contains(@class, 'btn-gmore') and contains(@class, 'blog-more')]"));
        wait.until(ExpectedConditions.visibilityOf(showMoreButton));
        sleep(5000);
        showMoreButton.click();
        WebElement newSpecialList = driver.findElement(By.xpath("/html/body/section[3]/div/div/div[1]/article[2]/div[2]/div[2]/h1/a"));

    }



    @Story("The google play button should displayed")
    @Description("verify The google play button should displayed ")
    @Test(description = "Verify The google play button is displayed", priority = 39)
    public void googlePlayButtonIsDisplayed() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[1]/div/div[1]/a"));
        Assert.assertTrue(button.isDisplayed());

    }

    @Story("The google play button should clickable")
    @Description("verify The google play button is clickable ")
    @Test(description = "Verify The google play button is clickable when click", priority = 0)

    public void googlePlayButtonIsClickable() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[1]/div/div[1]/a"));
        button.sendKeys(Keys.PAGE_DOWN);
        sleep(2000);
        button.click();
        String originalWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break; // قم بالتبديل إلى أول نافذة جديدة واستمر
            }
        }
        WebElement elementInNewWindow = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz[2]/div/div/div[2]/div[1]/div/div/c-wiz/div[2]/div[1]/div/h1/span"));
        Assert.assertTrue(elementInNewWindow.isDisplayed());
        driver.close();
        driver.switchTo().window(originalWindowHandle);

    }


    @Story("The apple store button should displayed")
    @Description("verify The apple store button should displayed ")
    @Test(description = "Verify The apple store button is displayed", priority = 41)
    public void appleStoreButtonIsDisplayed() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[1]/div/div[2]/a"));
        wait.until(ExpectedConditions.visibilityOf(button));
        Assert.assertTrue(button.isDisplayed());
    }
    //TODO ensure
    @Story("The apple store button should clickable")
    @Description("verify The apple store button is clickable ")
    @Test(description = "Verify The apple store button is clickable when click", priority = 42)
    public void appleStoreButtonIsClickable() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[1]/div/div[2]/a"));
        button.click();
        String originalWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break; // قم بالتبديل إلى أول نافذة جديدة واستمر
            }
        }
        WebElement elementInNewWindow = driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/section[1]/div/div[2]/header/h1"));
        Assert.assertTrue(elementInNewWindow.isDisplayed());
        driver.close();
        driver.switchTo().window(originalWindowHandle);
    }

    //
    @Story("The subscription Button should displayed")
    @Description("verify The subscription button is displayed ")
    @Test(description = "Verify The subscription button is displayed", priority = 43)
    public void subscriptionButtonIsDisplayed() {
        WebElement button = driver.findElement(By.xpath("//input[@value = 'اشتراك']"));
        Assert.assertTrue(button.isDisplayed());
    }

    //
    @Story("The subscription Button should clickable")
    @Description("verify The subscription button is clickable  ")
    @Test(description = "Verify The subscription button is clickable when click", priority = 44)
    public void secondSubscriptionButtonIsClickable() {
        WebElement button = driver.findElement(By.xpath("//input[@value = 'اشتراك']"));
        button.click();

    }

    @Story("Click on subscription button with invalid email ")
    @Description("verify to click on subscription button with wrong email")
    @Test(description = "Verify to click on subscription button with invalid email format ", priority = 46)
    public void clickOnSubscriptionButtonWithInvalidEmail() {
        WebElement input = driver.findElement(By.xpath("//*[@class = 'mail-list-email']"));
        WebElement button = driver.findElement(By.xpath("//input[@value = 'اشتراك']"));
        input.sendKeys("hello");
        button.click();
        driver.navigate().back();
    }

    @Story("Click on subscription button with valid email ")
    @Description("verify to click on subscription button with correct email")
    @Test(description = "Verify to click on subscription button with valid email format ", priority = 45)
    public void clickSubscriptionButtonWithValidEmail() throws InterruptedException {
//        jse.executeScript("window.scrollBy(0,5000)", "");
        WebElement input = driver.findElement(By.xpath("//*[@class = 'mail-list-email']"));
        WebElement button = driver.findElement(By.xpath("//input[@value = 'اشتراك']"));
        input.sendKeys("osama@email.com");
        button.click();
        sleep(2000);

    }

    @Story("verify the image on footer is displayed ")
    @Description("verify the image is displayed ")
    @Test(description = "verify the image is displayed on footer", priority = 47)
    public void footerImageIsDisplayed() throws InterruptedException {
        WebElement image = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/div[2]/img"));
        sleep(1000);
        Assert.assertTrue(image.isDisplayed());

    }
}
