import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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

    public SelenideElement getHead() {
        SelenideElement head = $(this.head);
        return head;
    }

    public RegisterForSalaryPage clickCreateButton() {
        $(createButton).click();
        return this;
    }

    public RegisterForSalaryPage clickCreateRegisterForSalaryButton(){
        $(createRegisterForSalaryButton).click();
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
    private By saveButtonOnAccrualInformationWindow = By.xpath("//div[@class=\"modal-form__footer-2b_\"]//span[text() = 'Сохранить']/..");
    private By addButton = By.xpath("//span[@class=\"btn__text-1VJ\" and text() = 'Добавить']");
    private By nameEmployeeField = By.xpath("//input[@name=\"employee\"]");
    private By employeeSNILSField = By.xpath("//input[@name=\"employee.snils\"]");
    private By employeeCardNumberField = By.xpath("//input[@name=\"employee.cardNumber\"]");
    private By employeeAccountNumberField = By.xpath("//input[@name=\"employee.accountNumber\"]");
    private By bankBIKField = By.xpath("//input[@name=\"bank\"]");
    private By addSelect = By.xpath("//li[contains(text(), \"Добавить\")]");
    private By amountField = By.xpath("//input[@name=\"amount\"]");


    public SelenideElement getNameOfRegisterSalaryForm() {
        return $(formHead).waitUntil(Condition.visible, 5000);
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
        $(By.xpath("//span[@class = \"label__title-25W\" and text() = '" + month + "']")).
                waitUntil(Condition.visible, 5000).click();
        //выбираем год
        $(reportingPeriodYearField).click();
        $(By.xpath("//span[@class = \"label__title-25W\" and text() = '" + year + "']")).click();

    }

    public void fillPayerBankBranchField(String bank){
        $(payerBankBranchField).setValue(bank);
        $(By.xpath("//div[@class=\"portal-3eO\"]//li[text() = '" +
                bank + "']")).waitUntil(Condition.visible, 5000).click();
    }

    public void fillPayerOrganizationField(String organization){
        $(payerOrganizationField).setValue(organization);
        $(By.xpath("//li[@class='cataloged-input-item-3xW' and text() = '" +
                organization + "']")).waitUntil(Condition.visible, 5000).click();
    }

    public void fillAssigneeField(String assignee){
        $(assigneeField).setValue(assignee);
        $(By.xpath("//li[contains(text(), 'Добавить: " +
                assignee + "')]")).waitUntil(Condition.visible, 5000).click();
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
        $(attachFileLink).sendKeys(file.getAbsolutePath());
    }

    public void fillPayrollAmountAndTotalField(String payrollAmount, String total) {
        $(payrollAmountField).setValue(payrollAmount);
        $(totalField).setValue(total);
    }


    public void fillRegisterForSalaryFormWithFile(){
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

    public void fillAccrualInformationField() {
        fillNameEmployeeField("Ефремов Автотест Тестович");
        fillEmployeeSNILSField("23592650988");
        fillEmployeeCardNumberField("3333555566667777");
        fillEmployeeAccountNumberField("12345810912321231313");
        fillBankBIKField("040037470");
        fillAmountField("1000");
        clickSaveButtonOnAccrualInformationWindow();
    }

    private void fillAmountField(String amount) {
        $(amountField).setValue(amount);
    }

    private void fillBankBIKField(String bik) {
        $(bankBIKField).setValue(bik);
        $(addSelect).click();
    }

    public void fillEmployeeSNILSField(String snils) {
        $(employeeSNILSField).setValue(snils);
    }

    public void fillNameEmployeeField(String name) {
        $(nameEmployeeField).setValue(name);
        $(addSelect).click();
    }

    private void fillEmployeeCardNumberField(String cardNumber) {
        $(employeeCardNumberField).setValue(cardNumber);
    }

    private void fillEmployeeAccountNumberField(String accountNumber) {
        $(employeeAccountNumberField).setValue(accountNumber);
    }

    private void clickAddButton() {
        $(addButton).click();
    }

    public void clickSave() {
        $(saveButton).click();
    }

    private void clickSaveButtonOnAccrualInformationWindow() {
        $(saveButtonOnAccrualInformationWindow).click();
    }

    public void fillRegisterForSalaryFormWithPerson() {
        String docNumber = "666" + random.nextInt(999999);
        fillDocumentNumberField(docNumber);
        fillDocumentDateField("14112019");
        fillReportingPeriod("Январь", "2017");
        fillPayerBankBranchField("БАНК ВТБ (ПАО)");
        fillPayerOrganizationField("АО \"Торговый дом \"ПЕРЕКРЕСТОК\"");
        fillAssigneeField("Ефремов Тест");
        fillAssigneePhoneNumberField("9998765432");
        fillPaymentCurrencyCode("EUR");
        clickAddButton();
        fillAccrualInformationField();

    }



}
