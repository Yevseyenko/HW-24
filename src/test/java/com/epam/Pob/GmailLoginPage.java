package com.epam.Pob;


import com.epam.customElement.Button;
import com.epam.customElement.Input;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailLoginPage {
   private static final Logger log =LogManager.getLogger("log4j2");
    @FindBy(css = "a.gb_we.gb_Aa.gb_Fb[target='_top']")
    private Button mailBtn;
    @FindBy(id = "identifierId")
    private Input emailInput;
    @FindBy(id = "identifierNext")
    private Button nextLoginBtn;

    public GmailLoginPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void clickingingEmail() {
        log.info("Choosing email button");
        mailBtn.click();
    }

    public void enteringLogin(String login) {
        log.info("Entering login" + login);
        emailInput.sendKeys(login);
    }

    public void clickingLoginNextBtn() {
        log.info("Clicking next button");
        nextLoginBtn.click();
    }
}
