package com.appium.autotest.ui.testcase;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.appium.autotest.ui.method.HomeMaintenance;
import com.appium.autotest.ui.method.commonCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test013 extends initializerValue{
	
	commonCleaning commonCleaning = new commonCleaning();
	HomeMaintenance HomeMaintenance = new HomeMaintenance();
	//房屋维修下单
	@Test
	public void thirteentest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			HomeMaintenance.Maintenance("房屋维修", driver);
			HomeMaintenance.Reservation("房屋维修", driver);
			HomeMaintenance.MenuSelect(driver, "瓷砖维修", "墙面瓷砖脱落维修");
			HomeMaintenance.confirmation(driver);
			HomeMaintenance.timeSlot(driver);
			HomeMaintenance.payMode(driver);
			HomeMaintenance.checkHouse(driver);
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
