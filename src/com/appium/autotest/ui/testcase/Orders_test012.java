package com.appium.autotest.ui.testcase;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.appium.autotest.ui.method.HomeMaintenance;
import com.appium.autotest.ui.method.commonCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test012 extends initializerValue{
	
	
	commonCleaning commonCleaning = new commonCleaning();
	HomeMaintenance HomeMaintenance = new HomeMaintenance();
	//家具维修下单
	@Test
	public void twelvetest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			HomeMaintenance.Maintenance("家具维修", driver);
			HomeMaintenance.Reservation("家具维修", driver);
			HomeMaintenance.MenuSelect(driver, "门/门五金维修", "门密封条更换维修");
			HomeMaintenance.confirmation(driver);
			HomeMaintenance.timeSlot(driver);
			HomeMaintenance.payMode(driver);
			HomeMaintenance.checkFurniture(driver);
			HomeMaintenance.abrogate(driver);
			HomeMaintenance.del(driver);
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
			AssertJUnit.fail("家具维修下单失败");
		}
	}

}
