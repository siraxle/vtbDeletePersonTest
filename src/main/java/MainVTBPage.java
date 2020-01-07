import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class MainVTBPage {

    public MainVTBPage() { }

    private By head = By.xpath("//span[text()='Главная']");
    private By salaryProjectLink = By.xpath("//span[text() = 'Зарплатный проект']");
    private By registerForSalaryLink = By.xpath("//a[text() = 'Реестры на зачисление заработной платы']");
    private By registerOfCardsLink = By.xpath("//a[text() = 'Реестры на выпуск карт']");

    public SelenideElement getHead() {
        SelenideElement head = $(this.head);
        return head;
    }

    public RegisterForSalaryPage getRegisterForSalaryPage() {
        SelenideElement spLink = $(salaryProjectLink);
        actions().moveToElement(spLink).build().perform();
        $(registerForSalaryLink).click();
        return new RegisterForSalaryPage();
    }

    public RegisterOfCardPage getRegisterOfCardsPage() {
        SelenideElement spLink = $(salaryProjectLink);
        actions().moveToElement(spLink).build().perform();
        $(registerOfCardsLink).click();
        return new RegisterOfCardPage();
    }

}