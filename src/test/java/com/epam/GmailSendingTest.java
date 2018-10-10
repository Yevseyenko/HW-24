package com.epam;


import com.epam.businessLayer.businessObjects.EmailBusinessObject;
import com.epam.businessLayer.businessObjects.LoginBusinessObject;
import com.epam.utils.driverConfig.DriverPool;
import com.epam.model.Email;
import com.epam.model.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static com.epam.dataproviders.DataProviderXLS.getXLSUsersAndMessages;

public class GmailSendingTest {


    @DataProvider(name = "usersXLSData", parallel = true)
    public Object[][] usersData() {
        return getXLSUsersAndMessages();
    }

    @Test(dataProvider = "usersXLSData")
    public void sendingEmail(User user, Email email) {
        String login = user.getLogin();
        String password = user.getPassword();
        String receiver = email.getReceiver();
        String subject = email.getSubject();
        String text = email.getText();
        WebDriver driver = DriverPool.getDriver();
        LoginBusinessObject loginBO = new LoginBusinessObject(driver);
        EmailBusinessObject emailBO = new EmailBusinessObject(driver);
        loginBO.authorisationEmail(login, password);
        emailBO.writeLetterAndSubmit(receiver, subject, text);
        emailBO.selectSentLetter(subject, text);
        Assert.assertTrue(emailBO.getSubject().equals(subject));
        Assert.assertTrue(emailBO.getTextEmail().equals(text));
        emailBO.deleteSentLetter();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverPool.quit();
    }
}
