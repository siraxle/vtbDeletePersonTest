import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VtbTest {
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
    }

    //переход на страницу ЗЗП
    @Test
    @Ignore
    public void getRegisterForSalaryPageTest() {
        authorizeWithLoginPage = new AuthorizeWithLoginPage();
        mainVTBPage = new MainVTBPage();
        registerForSalaryPage = new RegisterForSalaryPage();
        authorizeWithLoginPage.open()
                .authorizing("77515030", "123ewqEWQ");
        mainVTBPage.getRegisterForSalaryPage();
        SelenideElement head = registerForSalaryPage.getHead();
        head.shouldHave(exactText("Реестры на зачисление заработной платы"));
    }

    //создание реестра ЗЗП в статусе "Новый" с файлом в ведомости
    @Test
    @Ignore
    public void createRegisterForSalaryWithFileTest() {
        authorizeWithLoginPage = new AuthorizeWithLoginPage();
        mainVTBPage = new MainVTBPage();
        registerForSalaryPage = new RegisterForSalaryPage();
        authorizeWithLoginPage.open()
                .authorizing("77515030", "123ewqEWQ");
        mainVTBPage.getRegisterForSalaryPage();
        registerForSalaryPage.clickCreateButton();
        registerForSalaryPage.clickCreateRegisterForSalaryButton();
        SelenideElement formName = registerForSalaryPage.getNameOfRegisterSalaryForm();
        formName.text().substring(0, 37).equals("Реестр на зачисление заработной платы");
        registerForSalaryPage.fillRegisterForSalaryFormWithFile();
        registerForSalaryPage.clickSave();
        SelenideElement status = $(By.xpath("//span[text() = 'Новый / Введен вручную']"));
        status.shouldHave(exactText("Новый / Введен вручную"));
    }

    //создание реестра ЗЗП в статусе "Новый" с сотрудником в ведомости
    @Test
    @Ignore
    public void createRegisterForSalaryWithPersonTest() {
        authorizeWithLoginPage = new AuthorizeWithLoginPage();
        mainVTBPage = new MainVTBPage();
        registerForSalaryPage = new RegisterForSalaryPage();
        authorizeWithLoginPage.open()
                .authorizing("77515030", "123ewqEWQ");
        mainVTBPage.getRegisterForSalaryPage();
        registerForSalaryPage.clickCreateButton();
        registerForSalaryPage.clickCreateRegisterForSalaryButton();
        registerForSalaryPage.fillRegisterForSalaryFormWithPerson();
    }

}