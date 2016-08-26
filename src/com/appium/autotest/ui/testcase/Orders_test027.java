package com.appium.autotest.ui.testcase;


import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.appium.autotest.ui.method.FurnitureCare;
import com.appium.autotest.ui.method.commonCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test027 extends initializerValue {
	
	commonCleaning commonCleaning = new commonCleaning();
	FurnitureCare FurnitureCare = new FurnitureCare();

	//地板抛光打蜡下单
	@Test
	public void twenty_seventest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			FurnitureCare.Furniture("地板抛光打蜡", driver);
			FurnitureCare.Reservation("地板抛光打蜡", driver);
			FurnitureCare.confirmation(driver);
			FurnitureCare.timeSlot(driver);
			FurnitureCare.payMode(driver);
			FurnitureCare.checkWaxing(driver);
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
			AssertJUnit.fail("地板抛光打蜡下单失败");
		}
	}


	
	
}
