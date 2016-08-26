package com.appium.autotest.ui.testcase;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.appium.autotest.ui.method.commonCleaning;
import com.appium.autotest.ui.method.specializedCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test008 extends initializerValue{
	
	commonCleaning commonCleaning = new commonCleaning();
	specializedCleaning specializedCleaning = new specializedCleaning();
	//地面净化除菌保洁下单
	@Test
	public void eighttest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			specializedCleaning.ZYCleaning("地面净化除菌", driver);
			specializedCleaning.Reservation("地面净化除菌", driver);
			specializedCleaning.confirmation(driver);
			specializedCleaning.timeSlot(driver);
			specializedCleaning.payMode(driver);
			specializedCleaning.groundCleaningSterilization(driver);
			specializedCleaning.abrogate(driver);
			specializedCleaning.del(driver);
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			teardoun();
			AssertJUnit.fail("地面净化除菌下单失败");
		}
	}
}
