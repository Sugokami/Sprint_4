package UiTests;

import PageObject.BrowserRule;
import PageObject.MainPage;
import org.junit.*;

public class CheckAboutImportantListPanelText {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void checkAnswersWhenQuestionsOpen() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.scroll();
        mainPage.clickFirstQuestionButton();
        mainPage.waitForLoadAnswers();
        mainPage.getTextFirstQuestionAnswer();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

        Assert.assertEquals(expected, mainPage.getTextFirstQuestionAnswer());
    }


    @Test
    public void checkAnswersWhenQuestionsOpen2() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.scroll();
        mainPage.clickSecondQuestionButton();
        mainPage.waitForLoadAnswers();
        mainPage.getTextSecondQuestionAnswer();
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

        Assert.assertEquals(expected, mainPage.getTextSecondQuestionAnswer());
    }

    @Test
    public void checkAnswersWhenQuestionsOpen3() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.scroll();
        mainPage.clickThirdQuestionButton();
        mainPage.waitForLoadAnswers();
        mainPage.getTextThirdQuestionAnswer();
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

        Assert.assertEquals(expected, mainPage.getTextThirdQuestionAnswer());
    }
}