package com.appium.autotest.ui.testcase;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.appium.autotest.ui.method.ElectricalCleaning;
import com.appium.autotest.ui.method.commonCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test018 extends initializerValue {

	commonCleaning commonCleaning = new commonCleaning();
	ElectricalCleaning ElectricalCleaning = new ElectricalCleaning();

	// 空调清洗下单
	@Test
	public void eighteentest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			ElectricalCleaning.Electrical("空调清洗", driver);
			ElectricalCleaning.MenuSelect(driver, "挂式空调");
			ElectricalCleaning.confirmation(driver);
			ElectricalCleaning.timeSlot(driver);
			ElectricalCleaning.payMode(driver);
			ElectricalCleaning.checkConditioning(driver);
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
			AssertJUnit.fail("空调清洗下单失败");
		}
	}

}
