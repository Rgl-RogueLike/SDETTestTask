package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

    @FindBy(css = "button[class='custom_btn btn_hover']")
    private WebElement submitButton;

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

    public FormFieldsPage selectMilkAndCoffee() {
        milkOption.click();
        coffeeOption.click();
        return this;
    }

    public FormFieldsPage selectFavoriteColor() {
        favoriteColor.click();
        return this;
    }

    public void submit() {
        submitButton.click();
    }
}
