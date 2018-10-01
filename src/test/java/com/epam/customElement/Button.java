package com.epam.customElement;

import org.openqa.selenium.WebElement;

public class Button extends Element {

    public Button(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        super.isDiplayed();
        super.click();
    }
}
