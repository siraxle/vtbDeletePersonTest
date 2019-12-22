import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizeWithLoginPage {

    public AuthorizeWithLoginPage() {}

    public AuthorizeWithLoginPage open() {
        Selenide.open("/login/sign-in-login");
        return this;
    }

    private By loginField = By.xpath("//input[@name=\"login\"]");
    private By passwordField = By.xpath("//input[@placeholder='Введите пароль']");
    private By signInButton = By.xpath("//span[text()='Войти']/..");

    public AuthorizeWithLoginPage typeLogin (String login) {
        $(loginField).setValue(login);
        return this;
    }

    public AuthorizeWithLoginPage typePassword (String password) {
        $(passwordField).setValue(password);
        return this;
    }

    public MainVTBPage clickSignIn() {
        $(signInButton).click();
        return new MainVTBPage();
    }

    public MainVTBPage authorizing(String login, String password) {
        this.typeLogin(login);
        this.typePassword(password);
        this.clickSignIn();
        return new MainVTBPage();
    }

}
