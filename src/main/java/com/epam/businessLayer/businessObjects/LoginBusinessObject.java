package com.epam.businessLayer.businessObjects;

import com.epam.businessLayer.pageObjects.GmailLoginPage;
import com.epam.businessLayer.pageObjects.GmailPasswordPage;
import org.openqa.selenium.WebDriver;

public class LoginBusinessObject {
    public WebDriver driver;
    public GmailLoginPage gmailLoginPage;
    public GmailPasswordPage gmailPasswordPage;

    public LoginBusinessObject(WebDriver driver) {
        this.driver = driver;
        this.gmailLoginPage = new GmailLoginPage(driver);
        this.gmailPasswordPage = new GmailPasswordPage(driver);
    }

    public void authorisationEmail(String login, String password) {
        gmailLoginPage.clickingingEmail();
        gmailLoginPage.enteringLogin(login);
        gmailLoginPage.clickingLoginNextBtn();
        gmailPasswordPage.enterPassword(password, driver);
        gmailPasswordPage.clickingPasswordNextBtn();
    }
}
