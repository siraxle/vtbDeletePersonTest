import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegisterOfCardPage {
    public RegisterOfCardPage() { }

    private By head = By.xpath("//span[text() = 'Реестры на выпуск карт']");

    public SelenideElement getHead() {
        SelenideElement head = $(this.head);
        return head;
    }

}
