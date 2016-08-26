package com.appium.autotest.ui.testcase;


import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.appium.autotest.ui.method.FurnitureCare;
import com.appium.autotest.ui.method.commonCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test024 extends initializerValue{

	commonCleaning commonCleaning = new commonCleaning();
	FurnitureCare FurnitureCare = new FurnitureCare();

	// 皮质沙发保养下单
	@Test
	public void twenty_fourtest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			FurnitureCare.Furniture("皮质沙发保养", driver);
			FurnitureCare.Reservation("皮质沙发保养", driver);
			FurnitureCare.confirmation(driver);
			FurnitureCare.timeSlot(driver);
			FurnitureCare.payMode(driver);
			FurnitureCare.checkCortex(driver);
			FurnitureCare.abrogate(driver);
			FurnitureCare.del(driver);
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
			AssertJUnit.fail("皮质沙发保养下单失败");
		}
	}

}
