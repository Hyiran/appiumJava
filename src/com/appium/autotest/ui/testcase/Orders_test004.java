package com.appium.autotest.ui.testcase;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.appium.autotest.ui.method.commonCleaning;
import com.appium.autotest.ui.method.specializedCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test004 extends initializerValue{
	
	commonCleaning commonCleaning = new commonCleaning();
	specializedCleaning specializedCleaning = new specializedCleaning();
	
	// 新居开荒下单
		@Test
		public void fourtest() throws Exception, InterruptedException {
			try {
				commonCleaning.CheckHome(driver);
				specializedCleaning.ZYCleaning("新居开荒", driver);
				specializedCleaning.Reservation("新居开荒", driver);
				specializedCleaning.confirmation(driver);
				specializedCleaning.timeSlot(driver);
				specializedCleaning.payMode(driver);
				specializedCleaning.checkHome(driver);
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
				AssertJUnit.fail("单次预约下单失败");
			}
		}
}
