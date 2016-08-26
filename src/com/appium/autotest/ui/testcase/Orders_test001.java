package com.appium.autotest.ui.testcase;


import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.appium.autotest.ui.constants.constantsValue;
import com.appium.autotest.ui.method.commonCleaning;
import com.appium.autotest.ui.method.onceCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test001 extends initializerValue {

	commonCleaning commonCleaning = new commonCleaning();
	onceCleaning onceCleaning = new onceCleaning();

	// 单次预约下单
	@Test
	public void onetest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			commonCleaning.Cleaning(constantsValue.everyday, driver);
			commonCleaning.optionForward(constantsValue.once, driver);
			commonCleaning.aunt(driver);
			commonCleaning.daayTime(constantsValue.Bigbermorgenx, driver);
			onceCleaning.timeSearch(driver);
			onceCleaning.payMode(driver);
			onceCleaning.check(driver);
			onceCleaning.abrogate(driver);
			onceCleaning.del(driver);
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
