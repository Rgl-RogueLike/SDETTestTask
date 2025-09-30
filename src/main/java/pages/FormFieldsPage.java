package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Класс страницы с формой, предоставляющий методы для взаимодействия
 * с полями формы, выборами и кнопкой отправки.
 */
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

    @FindBy(css = "select[id='automation'] >option")
    private List<WebElement> likeAutomationOption;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailField;

    @FindBy(id = "message")
    private WebElement messageField;

    private By automationToolsListLocator = By.xpath("//label[text()='Automation tools']/following-sibling::ul/li");

    /**
     * Конструктор
     */
    public FormFieldsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Вводит имя в поле ввода.
     *
     * @param name имя для ввода
     * @return текущий объект страницы
     */
    public FormFieldsPage enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    /**
     * Вводит пароль в поле ввода.
     *
     * @param password пароль для ввода
     * @return текущий объект страницы
     */
    public FormFieldsPage enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    /**
     * Выбирает опцию "Молоко" (milk) на форме.
     *
     * @return текущий объект страницы
     */
    public FormFieldsPage selectMilk() {
        milkOption.click();
        return this;
    }

    /**
     * Выбирает опцию "Кофе" (coffee) на форме.
     *
     * @return текущий объект страницы
     */
    public FormFieldsPage selectCoffee() {
        coffeeOption.click();
        return this;
    }

    /**
     * Выбирает любимый цвет (favorite color).
     *
     * @return текущий объект страницы
     */
    public FormFieldsPage selectFavoriteColor() {
        favoriteColor.click();
        return this;
    }

    /**
     * Выбирает опцию "Нравится автоматизация".
     *
     * @return текущий объект страницы
     */
    public FormFieldsPage selectLikeAutomation(int idLikeAutomation) {
        likeAutomationOption.get(idLikeAutomation).click();
        return this;
    }

    /**
     * Вводит email в поле ввода.
     *
     * @param email email для ввода
     * @return текущий объект страницы
     */
    public FormFieldsPage enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    /**
     * Вводит сообщение в текстовое поле сообщения.
     *
     * @param message сообщение для ввода
     * @return текущий объект страницы
     */
    public FormFieldsPage enterMessage(String message) {
        messageField.clear();
        messageField.sendKeys(message);
        return this;
    }

    /**
     * Получает список элементов инструментов на странице.
     *
     * @return список WebElement элементов инструментов автоматизации
     */
    public List<WebElement> getToolsAutomation() {
        return driver.findElements(automationToolsListLocator);
    }

    /**
     * Нажимает кнопку отправки формы.
     */
    public void submit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"submit-btn\").click()"); //Пришлось использовать JS, так как через Selenium появляется ошибка из-за того, что кнопка submit не кликабельна даже после скролла
    }
}
