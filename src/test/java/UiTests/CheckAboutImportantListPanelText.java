package UiTests;

import PageObject.BrowserRule;
import PageObject.MainPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import steps.Steps;
import org.junit.Test;
@RunWith(Parameterized.class)
public class CheckAboutImportantListPanelText {

    private final By questionButton;
    private final By answerButton;
    private final String expectedAnswer;
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    public CheckAboutImportantListPanelText(By questionButton, By answerButton, String expectedAnswer) {
        this.questionButton = questionButton;
        this.answerButton = answerButton;
        this.expectedAnswer = expectedAnswer;
    }
    @Parameterized.Parameters
    public static Object[][] getAnswers() {
        return new Object[][] {
                {By.xpath(".//div[@id='accordion__heading-0']"), By.xpath(".//*[@id=\"accordion__panel-0\"]/p"), "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {By.xpath(".//div[@id='accordion__heading-1']"), By.xpath(".//*[@id=\"accordion__panel-1\"]/p"), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {By.xpath(".//div[@id='accordion__heading-2']"), By.xpath(".//*[@id=\"accordion__panel-2\"]/p"), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {By.xpath(".//div[@id='accordion__heading-3']"), By.xpath(".//*[@id=\"accordion__panel-3\"]/p"), "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {By.xpath(".//div[@id='accordion__heading-4']"), By.xpath(".//*[@id=\"accordion__panel-4\"]/p"), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {By.xpath(".//div[@id='accordion__heading-5']"), By.xpath(".//*[@id=\"accordion__panel-5\"]/p"), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {By.xpath(".//div[@id='accordion__heading-6']"), By.xpath(".//*[@id=\"accordion__panel-6\"]/p"), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {By.xpath(".//div[@id='accordion__heading-7']"), By.xpath(".//*[@id=\"accordion__panel-7\"]/p"), "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    public By getAnswerButton() {
        return answerButton;
    }
    @Test
    public void checkAnswersWhenQuestionsOpen() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        Steps steps = new Steps(browserRule.getDriver());
        steps.open(mainPage.getUrl());
        steps.scroll(questionButton);
        steps.click(questionButton);
        steps.waitForLoadAnswers(questionButton);
        steps.getText(answerButton);
        Assert.assertEquals(expectedAnswer, steps.getText(answerButton));
    }
}