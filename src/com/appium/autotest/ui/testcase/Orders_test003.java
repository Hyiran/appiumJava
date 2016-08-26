package com.appium.autotest.ui.testcase;



import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.appium.autotest.ui.constants.constantsValue;
import com.appium.autotest.ui.method.commonCleaning;
import com.appium.autotest.ui.method.onceCleaning;
import com.appium.autotest.ui.method.threeCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test003 extends initializerValue {

	commonCleaning commonCleaning = new commonCleaning();
	onceCleaning onceCleaning = new onceCleaning();
	threeCleaning threeCleaning = new threeCleaning();
	@Test
	//周期预约
	public void threetest() throws Exception,
			InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			commonCleaning.Cleaning(constantsValue.everyday, driver);
			commonCleaning.optionForward(constantsValue.cycle, driver);
			threeCleaning.aunt(driver);
			threeCleaning.daayTime(constantsValue.Bigbermorgenx, driver);
			threeCleaning.time(driver);
			threeCleaning.payMode(constantsValue.cash, driver);
			for (int i = 0; i <5; i++) {
				threeCleaning.abrogate(driver);
			}
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
			AssertJUnit.fail("周期预约失败");
		}
	}
}
