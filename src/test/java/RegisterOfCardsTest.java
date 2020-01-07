import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegisterOfCardsTest {
    private static AuthorizeWithLoginPage authorizeWithLoginPage;
    private static MainVTBPage mainVTBPage;
    private static RegisterOfCardPage registerOfCardPage;

    private static void signInSystemVTB() {
        authorizeWithLoginPage = new AuthorizeWithLoginPage();
        mainVTBPage = new MainVTBPage();
        authorizeWithLoginPage.open()
                .authorizing("77515030", "123ewqEWQ");
    }

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        baseUrl = "http://fe-root-client.slr-test.k8s-dev-reksoft.vtb-dbo.local";
        open(baseUrl);
        authorizeWithLoginPage = new AuthorizeWithLoginPage();
        mainVTBPage = new MainVTBPage();
        registerOfCardPage = new RegisterOfCardPage();
    }

    @Test
    public void signInTest() {
        authorizeWithLoginPage.open()
                .authorizing("77515030", "123ewqEWQ");
        SelenideElement head = mainVTBPage.getHead();
        head.shouldHave(exactText("Главная"));
    }

    @Test
    public void getRegisterOfCardsPageTest() {
        authorizeWithLoginPage.open()
                .authorizing("77515030", "123ewqEWQ");
        mainVTBPage.getRegisterOfCardsPage();
        SelenideElement head = registerOfCardPage.getHead();
        head.shouldHave(exactText("Реестры на выпуск карт"));
    }

}
