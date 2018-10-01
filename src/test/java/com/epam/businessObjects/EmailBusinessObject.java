package com.epam.businessObjects;

import com.epam.Pob.GmailEmailPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class EmailBusinessObject {

    public GmailEmailPage gmailEmailPage;

    public WebDriver driver;

    public EmailBusinessObject(WebDriver driver) {
        this.driver = driver;
        this.gmailEmailPage = new GmailEmailPage(driver);

    }

    public void writingLetterAndSubmit(String reciver, String subject, String text) {
        gmailEmailPage.clickingMailBtn();
        gmailEmailPage.clickingWriteBtn();
        gmailEmailPage.enteringEmail(reciver, subject, text);
        gmailEmailPage.clickingEmailSendBtn();
    }

    public void selectingSentLetter(String subject, String text) {
        gmailEmailPage.gettingSent();
        gmailEmailPage.enteringFirstLetter(driver);
        gmailEmailPage.verifyingSentLetter(subject, text);
        Assert.assertEquals(subject, gmailEmailPage.gettingSubject());
    }

    public void deletingSentLetter() {
        gmailEmailPage.deletingDeliveredMessage(driver);
    }

    public String getSubject() {
        return gmailEmailPage.gettingSubject();
    }

    public String getTextEmail() {
        return gmailEmailPage.gettingText();
    }
}
