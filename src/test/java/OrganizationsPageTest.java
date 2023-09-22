import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class OrganizationsPageTest extends HomePageTest{

    @Story("Open Organizations Page")
    @Description("Should open Organizations Page")
    @Test(description = "The About As button on navbar should able to navigate to Organizations As page", priority = 1)
    public void joinOrganizations_buttonLocator() {
        WebElement joinAOrganizations_buttonLocator = driver.findElement(By.xpath("//*[@title = 'المنظمات']"));
        joinAOrganizations_buttonLocator.click();
    }

    @Story("The Organizations title should Displayed")
    @Description(" Verify The Organizations title should Displayed")
    @Test(description = "The specialList title should Displayed In Organizations Page", priority = 2)
    public void titleOrganizationsAsIsDisplayed() {

        WebElement OrganizationsTitle = driver.findElement(By.xpath("(//*[contains(text() , 'عطاء وإنتاجية الموظف تبدأ من الصحة النفسية')])[1]"));
        Assert.assertTrue(OrganizationsTitle.isDisplayed());

    }

    @Story("The Organizations Description should Displayed")
    @Description(" Verify The Organizations Description should Displayed")
    @Test(description = "The Organizations Description should Displayed In specialList Page", priority = 3)
    public void descriptionInOrganizationsIsDisplayed() {
        WebElement organizationsDescription = driver.findElement(By.xpath("//*[contains(text() , 'في فامكير للمنظمات نساهم بتعزيز صحة موظفيك النفسية لخلق بيئة عمل صحية مليئة بالعطاء والإنتاجية لما لها أثر كبير على أداء الموظفين و إنتاجيتهم ويمتد أثرها لأسرة الموظف وتمكينهم لمواجهة المشاكل الأسرية والتربوية')]"));
        Assert.assertTrue(organizationsDescription.isDisplayed());

    }

    @Story("image Organizations")
    @Description("  The Organizations profile image should Displayed in specialList card ")
    @Test(description = "Verify The specialList profile image is Displayed in specialList card", priority = 4)
    public void basicImageInOrganizationsIsDisplayed() {
        WebElement organizationsImage = driver.findElement(By.xpath("/html/body/div[1]/section[1]/div/div/div[2]/div/div[2]/img"));
        Assert.assertTrue(organizationsImage.isDisplayed());
    }

    @Story("Organizations section")
    @Description("  The Organizations card should Displayed in Organizations Page")
    @Test(description = "Verify The specialList card is Displayed in specialList Page", priority = 5)
    public void organizationsSectionDisplayed() {
        WebElement organizationsSection = driver.findElement(By.xpath("/html/body/div[1]/section[2]"));
        Assert.assertTrue(organizationsSection.isDisplayed());
    }

    @Story("Organizations section title")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 6)
    public void titleOrganizationsSectionDisplayed() {
        WebElement titleSection = driver.findElement(By.xpath("//*[contains(text() , 'أثر الصحة النفسية على أداء الموظفين')]"));
        Assert.assertTrue(titleSection.isDisplayed());
    }

    @Story("Organizations section image Displayed")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 7)
    public void imageSectionDisplayed() {
        WebElement imageSection = driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/div/div/div[2]/div[3]/div/div/div[1]/img"));
        Assert.assertTrue(imageSection.isDisplayed());
    }


    @Story("Organizations section image title Displayed")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 8)
    public void imageTitleSectionDisplayed() {
        WebElement imageTitleSection = driver.findElement(By.xpath("(//*[contains(text() , 'استمرارية في العطاء')])[2]"));
        Assert.assertTrue(imageTitleSection.isDisplayed());
    }

///////////////
    @Story("Organizations section2")
    @Description("  The Organizations card should Displayed in Organizations Page")
    @Test(description = "Verify The specialList card is Displayed in specialList Page", priority = 9)
    public void organizationsSection2Displayed() {
        WebElement organizationsSection2 = driver.findElement(By.xpath("/html/body/div[1]/section[3]"));
        Assert.assertTrue(organizationsSection2.isDisplayed());
    }

    @Story("Organizations section2 title")
    @Description("The specialList Name should Displayed in specialList card")
    @Test(description = "Verify The specialList Name is Displayed in specialList card ", priority = 10)
    public void titleOrganizationsSection2Displayed() {
        WebElement titleSection2 = driver.findElement(By.xpath("//*[contains(text() , 'عزّز صحة موظفيك النفسية وسجل الآن')]"));
        Assert.assertTrue(titleSection2.isDisplayed());
    }


    @Story("Request the service button should be displayed")
    @Description("  The specialList Book an appointment button should Displayed in specialList card")
    @Test(description = "Verify The specialList Book an appointment button is Displayed in specialList card ", priority = 11)
    public void theRequestTheServiceButtonIsDisplayed() {
        WebElement RequestTheServiceButton = driver.findElement(By.xpath("/html/body/div[1]/section[3]/div/div/div/div/div[2]/button"));
        Assert.assertTrue(RequestTheServiceButton.isDisplayed());

    }

    @Story("Request the service button should be Clickable")
    @Description("  The specialList profile page button should Clickable in specialList card")
    @Test(description = "Verify The specialList profile page button is Clickable in specialList card ", priority = 12)
    public void theRequestTheServiceButtonIsClickable() throws InterruptedException {
        WebElement theRequestTheServiceButton = driver.findElement(By.xpath("/html/body/div[1]/section[3]/div/div/div/div/div[2]/button"));
        theRequestTheServiceButton.click();
        sleep(5000);
    }

    @Story("Filling all form")
    @Description("")
    @Test(description = "", priority = 13)
    public void shouldBeAbleToOpenRequestTheServiceForm() throws InterruptedException {

        WebElement joinAOrganizations_buttonLocator = driver.findElement(By.xpath("//*[@title = 'المنظمات']"));
        joinAOrganizations_buttonLocator.click();

        WebElement requestTheServiceFButton = driver.findElement(By.xpath("/html/body/div[1]/section[3]/div/div/div/div/div[2]/button"));
        requestTheServiceFButton.click();

        String your_name = Faker.instance().name().name();
        WebElement joinAsSpecialistForm_yourName_inputLocator = driver.findElement(By.xpath("//*[@id=\"wpcf7-f167-o1\"]/form/div[2]/input"));
        joinAsSpecialistForm_yourName_inputLocator.sendKeys(your_name);
        System.out.println(your_name);

        String your_phone = Faker.instance().phoneNumber().phoneNumber();
        WebElement joinAsSpecialistForm_yourPhone_inputLocator = driver.findElement(By.xpath("//*[@id=\"wpcf7-f167-o1\"]/form/div[3]/input"));
        joinAsSpecialistForm_yourPhone_inputLocator.sendKeys(your_phone);
        System.out.println(your_phone);

        String your_email = Faker.instance().address().city();
        WebElement joinAsSpecialistForm_degree_inputLocator = driver.findElement(By.xpath("//*[@id=\"wpcf7-f167-o1\"]/form/div[4]/input"));
        joinAsSpecialistForm_degree_inputLocator.sendKeys(your_email);
        System.out.println(your_email);

        String your_company = Faker.instance().company().name();
        WebElement joinAsSpecialistForm_specialization_inputLocator = driver.findElement(By.xpath("//*[@id=\"wpcf7-f167-o1\"]/form/div[5]/input"));
        joinAsSpecialistForm_specialization_inputLocator.sendKeys(your_company);
        System.out.println(your_company);

        String number_of_employee = Faker.instance().number().numberBetween(1,10) + "";
        WebElement joinAsSpecialistForm_experience_inputLocator = driver.findElement(By.xpath("//*[@id=\"wpcf7-f167-o1\"]/form/div[6]/input"));
        joinAsSpecialistForm_experience_inputLocator.sendKeys(number_of_employee);
        System.out.println(number_of_employee);


        WebElement RequestTheServiceForm_send_inputLocator = driver.findElement(By.xpath("//*[@id=\"wpcf7-f167-o1\"]/form/input[2]"));
        RequestTheServiceForm_send_inputLocator.click();

        sleep(5000);


        String  successMessage = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/form/div[7]")).getText();
        sleep(5000);
        System.out.println(successMessage);

        Assert.assertEquals(successMessage, "شكراً لك. لقد تم الإرسال بنجاح.");


    }
}
