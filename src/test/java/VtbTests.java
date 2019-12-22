import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;

public class VtbTests{
    private AuthorizeWithLoginPage authorizeWithLoginPage;
    private MainVTBPage mainVTBPage;
    private RegisterForSalaryPage registerForSalaryPage;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        baseUrl = "http://fe-root-client.slr-test.k8s-dev-reksoft.vtb-dbo.local";
        open(baseUrl);
    }

    //авторизация в системе с логином и паролем
    @Test
    public void signInTest() {
        authorizeWithLoginPage = new AuthorizeWithLoginPage();
        mainVTBPage = new MainVTBPage();
        authorizeWithLoginPage.open()
                .authorizing("77515030", "123ewqEWQ");
        SelenideElement head = mainVTBPage.getHead();
        head.shouldHave(exactText("Главная"));
        //Assert.assertEquals(head, "Главная");
    }

//    //переход на страницу ЗЗП
//    @Test
//    public void getRegisterForSalaryPageTest() {
//        authorizeWithLoginPage.authorizing("77515030", "123ewqEWQ");
//        mainVTBPage.getRegisterForSalaryPage(driver);
//        String head = registerForSalaryPage.getHead();
//        Assert.assertEquals(head, "Реестры на зачисление заработной платы");
//    }
//
//    //создание реестра ЗЗП в статусе "Новый"
//    @Test
//    public void createRegisterForSalaryTest() throws InterruptedException {
//        getRegisterForSalaryPageTest();
//        registerForSalaryPage.clickCreateButton();
//        registerForSalaryPage.clickCreateRegisterForSalaryButton();
//        String formName = registerForSalaryPage.getNameOfRegisterSalaryForm();
//        Assert.assertEquals(formName.substring(0, 37), "Реестр на зачисление заработной платы");
//        registerForSalaryPage.fillRegisterForSalaryForm();
//        registerForSalaryPage.clickSave();
//        String status = driver.findElement(By.xpath("//span[text() = 'Новый / Введен вручную']")).getText();
//        Assert.assertEquals(status, "Новый / Введен вручную");
//    }

}