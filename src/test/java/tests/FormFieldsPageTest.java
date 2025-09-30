package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FormFieldsPage;

import java.util.List;

public class FormFieldsPageTest {
    private WebDriver driver;
    private FormFieldsPage objFormFieldsPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
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
                .enterMessage(longestToolName())
                .submit();

        driver.switchTo().alert().getText();
    }

    public String longestToolName() {
        List<WebElement> tools = objFormFieldsPage.getToolsAutomation();
        int count = tools.size();

        String longestTool = "";
        for (WebElement tool : tools) {
            String text = tool.getText();
            if (text.length() > longestTool.length()) {
                longestTool = text;
            }
        }

        return  "Количество инструментов: " +  count + ". Инструмент, содержащий наибольшее количество символов: " + longestTool + ".";
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
