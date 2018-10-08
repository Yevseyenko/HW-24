package com.epam.customElement;

import org.openqa.selenium.WebElement;

public class Input extends Element {
    public Input(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void sendKeys(CharSequence... keys) {
        super.clear();
        super.sendKeys(keys);
    }
}
