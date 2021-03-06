package com.appium.autotest.ui.testcase;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.appium.autotest.ui.method.ElectricalCleaning;
import com.appium.autotest.ui.method.commonCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test020 extends initializerValue{
	
	commonCleaning commonCleaning = new commonCleaning();
	ElectricalCleaning ElectricalCleaning = new ElectricalCleaning();

	// 洗衣机清洗下单
	@Test
	public void twentytest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			ElectricalCleaning.Electrical("洗衣机清洗", driver);
			ElectricalCleaning.MenuSelect(driver, "波轮洗衣机");
			ElectricalCleaning.confirmation(driver);
			ElectricalCleaning.timeSlot(driver);
			ElectricalCleaning.payMode(driver);
			ElectricalCleaning.checkWashing(driver);
			ElectricalCleaning.abrogate(driver);
			ElectricalCleaning.del(driver);
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
