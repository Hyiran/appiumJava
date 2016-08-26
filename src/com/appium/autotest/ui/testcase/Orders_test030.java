package com.appium.autotest.ui.testcase;


import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import com.appium.autotest.ui.method.FurnitureCare;
import com.appium.autotest.ui.method.commonCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;


public class Orders_test030 extends initializerValue {

	commonCleaning commonCleaning = new commonCleaning();
	FurnitureCare FurnitureCare = new FurnitureCare();
	
	//床品除螨下单
		@Test
		public void Thirtytest() throws Exception, InterruptedException {
			try {
				commonCleaning.CheckHome(driver);
				FurnitureCare.Furniture("床品除螨", driver);
				FurnitureCare.MenuSelect(driver, "床品除螨", "单人床除螨");
				FurnitureCare.confirmation(driver);
				FurnitureCare.timeSlot(driver);
				FurnitureCare.payMode(driver);
				FurnitureCare.checkBed(driver);
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
				AssertJUnit.fail("床品除螨下单失败");
			}
		}

}
