package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.FormFieldsPage;

/**
 * Базовый тестовый класс
 */
public class BaseTest {

    protected WebDriver driver;
    protected FormFieldsPage objFormFieldsPage;

    /**
     * Метод инициализации перед запуском теста
     */
    @BeforeClass
    public void setup() {
        String baseUrl = "https://practice-automation.com/form-fields/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);
        objFormFieldsPage = new FormFieldsPage(driver);
    }

    /**
     * Метод очистки после выполнения теста
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
