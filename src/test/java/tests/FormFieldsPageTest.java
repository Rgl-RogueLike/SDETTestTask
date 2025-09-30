package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FormFieldsPage;

import java.time.Duration;

public class FormFieldsPageTest {
    private WebDriver driver;
    private FormFieldsPage objFormFieldsPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();

        driver.get("https://practice-automation.com/form-fields/");
        objFormFieldsPage = new FormFieldsPage(driver);
    }

    @Test
    public void testFillFormAndSubmit() {
        objFormFieldsPage.enterName("Nikita")
                .enterPassword("12345")
                .selectMilk()
                .selectCoffee()
                .selectFavoriteColor()
                .selectLikeAutomation()
                .enterEmail("nikita@example.com")
                .enterMessageWithLongestToolName()
                .submit();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
