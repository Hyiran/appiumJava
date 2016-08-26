package com.appium.autotest.ui.testcase;

import org.testng.annotations.Test;

import com.appium.autotest.ui.method.commonCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;
public class test extends initializerValue {
	commonCleaning commonCleaning = new commonCleaning();
	@Test
	public void onetest() throws Exception, InterruptedException  {
		commonCleaning.CheckHome(driver);
		commonCleaning.screen(driver);
		
	}
}
