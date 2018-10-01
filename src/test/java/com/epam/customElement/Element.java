package com.epam.customElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class Element {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        webElement.click();
    }

    public void clear() {
        webElement.clear();
    }


    public void sendKeys(CharSequence... keys) {
        webElement.sendKeys(keys);
    }

    public void submit() {
        webElement.submit();
    }

    public String getText() {
        return webElement.getText();
    }

    public String getAttribute(String a) {
        return webElement.getAttribute(a);
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public WebElement findElement(By selector) {
        return webElement.findElement(selector);
    }

    public Dimension getSize() {
        return webElement.getSize();
    }

    public boolean isDiplayed() {
        return webElement.isDisplayed();
    }

    public String getCssValue(String s) {
        return webElement.getCssValue(s);
    }

    public boolean isEnable() {
        return webElement.isEnabled();
    }

    public boolean isSelected() {
        return webElement.isSelected();
    }

    public String getTagName() {
        return webElement.getTagName();
    }

    public void waitBeforeAction(int timeInMiliseconds) {
        try {
            Thread.sleep(timeInMiliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
