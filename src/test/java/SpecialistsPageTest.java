import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SpecialistsPageTest extends HomePageTest {
    @Story("Open Specialist Page")
    @Description("should open specialList page")
    @Test(description = "The Specialist button on navbar should able to navigate to specialList page", priority = 1)
    public void specialistButtonInNavBarIsOpenSpecialListPage() {
        WebElement specialListButton = driver.findElement(By.xpath("//*[@title = 'الأخصائيين']"));
        specialListButton.click();
        driver.navigate().back();
    }
    @Story("verify the page is scrolling")
    @Description("verify the page is scrolling Down correctly")
    @Test(description = "The page should Scrolling Down Correctly", priority = 18)
    public void thePageIsScrolling() throws InterruptedException {
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        sleep(2000);

    }
    @Story("The specialList title should Displayed")
    @Description(" Verify The specialList title should Displayed")
    @Test(description = "The specialList title should Displayed In specialList Page", priority = 2)
    public void titleInSpecialistIsDisplayed() {
        WebElement specialListButton = driver.findElement(By.xpath("//*[@title = 'الأخصائيين']"));
        specialListButton.click();
        WebElement specialListButton2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/h1"));
        Assert.assertTrue(specialListButton2.isDisplayed());

    }

    @Story("The specialList title should Displayed")
    @Description(" Verify The specialList title should Displayed")
    @Test(description = "The specialList title should Displayed In specialList Page", priority = 3)
    public void titleInSpecialistIsDisplayedText() {
        WebElement specialListButton = driver.findElement(By.xpath("//*[@title = 'الأخصائيين']"));
        specialListButton.click();
        String textTitle = driver.findElement(By.xpath("//*[contains(text() , 'أخصائيين فامكير')]")).getText();
        System.out.println(textTitle);
        Assert.assertEquals(textTitle, "أخصائيين فامكير");


    }
}
