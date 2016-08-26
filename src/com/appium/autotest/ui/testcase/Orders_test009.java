package com.appium.autotest.ui.testcase;

import io.appium.java_client.android.AndroidKeyCode;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.appium.autotest.ui.method.commonCleaning;
import com.appium.autotest.ui.method.specializedCleaning;
import com.appuim.autotest.ui.testbase.initializerValue;

public class Orders_test009 extends initializerValue{
	
	
	commonCleaning commonCleaning = new commonCleaning();
	specializedCleaning specializedCleaning = new specializedCleaning();
	//纱窗更换下单
	@Test
	public void ninetest() throws Exception, InterruptedException {
		try {
			commonCleaning.CheckHome(driver);
			specializedCleaning.ZYCleaning("窗纱更换", driver);
			specializedCleaning.Windows(driver);
			specializedCleaning.confirmation(driver);
			specializedCleaning.timeSlot(driver);
			specializedCleaning.payMode(driver);
			specializedCleaning.WindowsCheck(driver);
			specializedCleaning.abrogate(driver);
			specializedCleaning.del(driver);
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
			AssertJUnit.fail("纱窗更换下单失败");
		}
	}

}
