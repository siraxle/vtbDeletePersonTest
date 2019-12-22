import org.openqa.selenium.By;

import java.io.File;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class RegisterForSalaryPage {
    private Random random = new Random();

    public RegisterForSalaryPage() { }

    private By head = By.xpath("//span[text() = 'Реестры на зачисление заработной платы']");
    private By createButton = By.xpath("//span[text() = 'Создать']/parent::button");
    private By createRegisterForSalaryButton =
            By.xpath("//span[text() = 'Реестр на зачисление заработной платы']/parent::button");

    public String getHead() {
        String head = $(this.head).text();
        return head;
    }

    public RegisterForSalaryPage clickCreateButton() {
        $(createButton).click();
        return this;
    }

    public RegisterForSalaryPage clickCreateRegisterForSalaryButton() throws InterruptedException {
        $(createRegisterForSalaryButton).click();
        //как избавиться от Tread.sleep?
        Thread.sleep(500);
        return this;
    }


    private By formHead = By.xpath("//span[contains(text(), 'Реестр на зачисление заработной платы')]");
    private By documentNumberField = By.xpath("//input[@name='documentNumber']");
    private By documentDateField = By.xpath("//input[@name='documentDate']");
    private By reportingPeriodMonthField = By.xpath("//input[@id='reportingPeriodMonth']/../div[@role=\"searchbox\"]");
    private By reportingPeriodYearField = By.xpath("//input[@id='reportingPeriodYear']/../div[@role=\"searchbox\"]");
    private By payerBankBranchField = By.xpath("//input[@name='payerBankBranch']");
    private By payerOrganizationField = By.xpath("//input[@name='payerOrganization']");
    private By assigneeField = By.xpath("//input[@name='assignee']");
    private By assigneePhoneNumberField = By.xpath("//input[@name='assignee.phoneNumber']");
    private By paymentCurrencyCode = By.xpath("//input[@name='paymentCurrencyCode']/../../..");
    private By attachFileButton = By.xpath("//span[text() = 'Прикрепить файл']/..");
    private By attachFileLink = By.xpath("//input[@type='file']");
    private By payrollAmountField = By.xpath("//input[@name=\"payrollCounts.payrollAmount\"]");
    private By totalField = By.xpath("//input[@name=\"payrollCounts.total\"]");
    private By saveButton = By.xpath("//button[@id='SAVE']");

    public String getNameOfRegisterSalaryForm() {
        return $(formHead).text();
    }

    public void fillDocumentNumberField(String docNumber) {
        $(documentNumberField).setValue(docNumber);
    }

    public void fillDocumentDateField(String docDate) {
        $(documentDateField).click();
        $(documentDateField).clear();
        $(documentDateField).setValue(docDate);
    }

    public void fillReportingPeriod(String month, String year){
        //выбираем месяц
        $(reportingPeriodMonthField).click();
        $
                (By.xpath("//ul[@class=\"list-3sC\"]//span[text() = '" + month + "']")).click();
        //выбираем год
        $(reportingPeriodYearField).click();
        $
                (By.xpath("//ul[@class=\"list-3sC\"]//span[text() = '" + year + "']")).click();

    }

    public void fillPayerBankBranchField(String bank) throws InterruptedException {
        $(payerBankBranchField).setValue(bank);
        Thread.sleep(500);
        $(By.xpath("//ul[@class=\"cataloged-input-list-2P5\"]//li[text() = '" +
                bank + "']")).click();
    }

    public void fillPayerOrganizationField(String organization) throws InterruptedException {
        $(payerOrganizationField).setValue(organization);
        Thread.sleep(500);
        $(By.xpath("//ul[@class=\"cataloged-input-list-2P5\"]//li[text() = '" +
                organization + "']")).click();
    }

    public void fillAssigneeField(String assignee) throws InterruptedException {
        $(assigneeField).setValue(assignee);
        Thread.sleep(500);
        $(By.xpath("//li[contains(text(), 'Добавить: " + assignee + "')]")).click();
    }

    public void fillAssigneePhoneNumberField(String phoneNumber) {
        $(assigneePhoneNumberField).setValue(phoneNumber);
    }

    public void fillPaymentCurrencyCode(String currencyCode) {
        $(paymentCurrencyCode).click();
        $(By.xpath("//li[@title=\"" + currencyCode + "\"]")).click();
    }

    public void attachFileInStatement() {
        $(attachFileButton).click();
        File file = new File("files/file.txt");
        $(attachFileLink).
                setValue(file.getAbsolutePath());
    }

    public void fillPayrollAmountAndTotalField(String payrollAmount, String total) {
        $(payrollAmountField).setValue(payrollAmount);
        $(totalField).setValue(total);
    }

    public void fillRegisterForSalaryForm() throws InterruptedException {
        String docNumber = "666" + random.nextInt(999999);
        fillDocumentNumberField(docNumber);
        fillDocumentDateField("14112019");
        fillReportingPeriod("Январь", "2017");
        fillPayerBankBranchField("БАНК ВТБ (ПАО)");
        fillPayerOrganizationField("АО \"Торговый дом \"ПЕРЕКРЕСТОК\"");
        fillAssigneeField("Ефремов Тест");
        fillAssigneePhoneNumberField("9998765432");
        fillPaymentCurrencyCode("EUR");
        attachFileInStatement();
        fillPayrollAmountAndTotalField("77", "1111.00");
    }

    public void clickSave() {
        $(saveButton).click();
    }
}
