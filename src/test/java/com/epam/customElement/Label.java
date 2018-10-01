package com.epam.customElement;

import org.openqa.selenium.WebElement;

public class Label extends Element {
    public Label(WebElement webElement) {
        super(webElement);
    }

    @Override
    public String getText() {
        waitBeforeAction(3000);
          return super.webElement.getText();
    }

}