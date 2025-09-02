package com.gitlab.rmarzec.tests;

import com.gitlab.rmarzec.base.BaseTest;
import org.testng.annotations.Test;



public class Task1Test extends BaseTest {

    @Test
    public void OpenOnetTest(){
        openTestPage("https://www.onet.pl/");
    }
}
