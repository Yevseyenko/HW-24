package com.epam.businessLayer.businessObjects;

import com.epam.businessLayer.pageObjects.GmailEmailPage;
import org.openqa.selenium.WebDriver;

public class EmailBusinessObject {

    public GmailEmailPage gmailEmailPage;

    public WebDriver driver;

    public EmailBusinessObject(WebDriver driver) {
        this.driver = driver;
        this.gmailEmailPage = new GmailEmailPage(driver);
    }

    public void writeLetterAndSubmit(String reciver, String subject, String text) {
        gmailEmailPage.clickingMailBtn();
        gmailEmailPage.clickingWriteBtn();
        gmailEmailPage.enteringEmail(reciver, subject, text);
        gmailEmailPage.clickingEmailSendBtn();
    }

    public void selectSentLetter(String subject, String text) {
        gmailEmailPage.gettingSent();
        gmailEmailPage.enteringFirstLetter(driver);
    }

    public void deleteSentLetter() {
        gmailEmailPage.deletingDeliveredMessage(driver);
    }

    public String getSubject() {
        return gmailEmailPage.gettingSubject();
    }

    public String getTextEmail() {
        return gmailEmailPage.gettingText();
    }
}
