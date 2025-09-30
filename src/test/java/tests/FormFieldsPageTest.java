package tests;

import Utilities.dataGeneration;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Тестовый класс для проверки работы формы на странице FormFieldsPage.
 */
public class FormFieldsPageTest extends BaseTest {

    /**
     * Тестирует заполнение формы и последующую отправку
     * отправляет форму и проверяет, что alert содержит сообщение "Message received!".
     */
    @Test
    public void testFillFormAndSubmit() {
        objFormFieldsPage.enterName("Nikita")
                .enterPassword("12345")
                .selectMilk()
                .selectCoffee()
                .selectFavoriteColor()
                .selectLikeAutomation(dataGeneration.getRandomNumber(1, 4))
                .enterEmail(dataGeneration.getFakeEmail())
                .enterMessage(longestToolName())
                .submit();

        assertEquals(driver.switchTo().alert().getText(), "Message received!");
    }

    /**
     * Возвращает строку с информацией о количестве доступных инструментов.
     *
     * @return строка с количеством инструментов и названием самого длинного из них
     */
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

        return "Количество инструментов: " + count + ". Инструмент, содержащий наибольшее количество символов: " + longestTool + ".";
    }

}
