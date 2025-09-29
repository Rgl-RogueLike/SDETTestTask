package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class FormFieldsPage {
    private WebDriver driver;

    @FindBy(id = "name-input")
    private WebElement nameField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='checkbox' and @id='drink2']")
    private WebElement milkOption;

    @FindBy(xpath = "//input[@type='checkbox' and @id='drink3']")
    private WebElement coffeeOption;

    @FindBy(id = "color3")
    private WebElement favoriteColor;

    @FindBy(css = "#automation > option:nth-child(2)")
    private WebElement likeAutomationOption;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailField;

    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(css = "button[class='custom_btn btn_hover']")
    private WebElement submitButton;

    private By automationToolsListLocator = By.xpath("//label[text()='Automation tools']/following-sibling::ul/li");

    public FormFieldsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FormFieldsPage enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public FormFieldsPage enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public FormFieldsPage selectMilk() {
        milkOption.click();
        return this;
    }

    public FormFieldsPage selectCoffee() {
        coffeeOption.click();
        return this;
    }

    public FormFieldsPage selectFavoriteColor() {
        favoriteColor.click();
        return this;
    }

    public FormFieldsPage selectLikeAutomation() {
        likeAutomationOption.click();
        return this;
    }

    public FormFieldsPage enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public FormFieldsPage enterMessage(String message) {
        messageField.clear();
        messageField.sendKeys(message);
        return this;
    }

    public FormFieldsPage enterMessageWithLongestToolName() {
        List<WebElement> tools = driver.findElements(automationToolsListLocator);
        int count = tools.size();

        String longestTool = "";
        for (WebElement tool : tools) {
            String text = tool.getText();
            if (text.length() > longestTool.length()) {
                longestTool = text;
            }
        }

        String message = "Количество инструментов: " +  count + ". Инструмент, содержащий наибольшее количество символов: " + longestTool + ".";
        messageField.clear();
        messageField.sendKeys(message);
        return this;
    }

    public void submit() {
        submitButton.click();
    }
}
