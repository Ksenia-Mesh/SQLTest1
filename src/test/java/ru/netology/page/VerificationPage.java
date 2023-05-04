package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class VerificationPage {

    @FindBy(css="[data-test-id='code'] input")
    private SelenideElement codeField;

    @FindBy(css="[data-test-id='action-verify']")
    private SelenideElement verification;

    @FindBy(css="[data-test-id='error-notification']")
    private SelenideElement errorNotification;

    public void verifyVerificationPageVisibility() {codeField.shouldBe(visible); }

    public void verifyErrorNotificationVisibility() {errorNotification.shouldBe(visible); }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return page(DashboardPage.class);
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}
