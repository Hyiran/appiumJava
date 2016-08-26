package com.appium.autotest.ui.testcase;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.appium.autotest.ui.method.FirstaidService;
import com.appium.autotest.ui.method.commonCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test023 extends initializerValue{

	
	commonCleaning commonCleaning = new commonCleaning();
	FirstaidService FirstaidService = new FirstaidService();

	// 杀虫下单
	@Test
	public void twenty_threetest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			FirstaidService.Firstaid("杀虫", driver);
			FirstaidService.Reservation("杀虫", driver);
			FirstaidService.confirmation(driver);
			FirstaidService.timeSlot(driver);
			FirstaidService.payMode(driver);
			FirstaidService.checkInsecticide(driver);
			FirstaidService.abrogate(driver);
			FirstaidService.del(driver);
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user",
					".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			teardoun();
			AssertJUnit.fail("洗衣机清洗下单失败");
		}
	}

}
