package com.appium.autotest.ui.testcase;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.appium.autotest.ui.constants.constantsValue;
import com.appium.autotest.ui.method.commonCleaning;
import com.appium.autotest.ui.method.onceCleaning;
import com.appium.autotest.ui.method.towCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test002 extends initializerValue {

	commonCleaning commonCleaning = new commonCleaning();
	onceCleaning onceCleaning = new onceCleaning();
	towCleaning towCleaning = new towCleaning();

	@Test
	// 双周预约下单
	public void towtest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			commonCleaning.Cleaning(constantsValue.everyday, driver);
			commonCleaning.optionForward(constantsValue.biweekly, driver);
			commonCleaning.aunt(driver);
			commonCleaning.daayTime(constantsValue.Bigbermorgenx, driver);
			commonCleaning.timeSearch(driver);
			towCleaning.payMode(driver);
			towCleaning.check(driver);
			towCleaning.abrogate(driver);
			towCleaning.del(driver);
			towCleaning.abrogate(driver);
			towCleaning.del(driver);
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
			AssertJUnit.fail("双周预约下单失败");

		}
	}
	
}
