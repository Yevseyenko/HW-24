package com.epam;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FailTest {
    private static final Logger log = Logger.getLogger(FailTest.class);

    @Test(enabled=false)
    public void failTest() {
        log.info("Fail test");

        Assert.fail("Test failed");
    }
}
