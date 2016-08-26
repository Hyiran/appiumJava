package com.appium.autotest.ui.method;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;

import com.appium.autotest.ui.pageobject.uiutl;



public class ComminRevise {

	uiutl uiutl = new uiutl();
	commonCleaning commonCleaning = new commonCleaning();
	
	/**
	 * 订单时间修改
	 * 
	 * @param String
	 *            修改时间
	 * @return boolean
	 * @throws exception
	 */
	public void Revise(String name, AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {
		WebElement ae = driver.findElementByAccessibilityId("修改时间");
		WebElement se = driver.findElementByAccessibilityId("订单详情");
		if (se.equals(ae)) {
			commonCleaning.logInfo("识别到订单详情");
			commonCleaning.sleep(2000);
			commonCleaning.logInfo("点击修改时间");
			ae.click();	
		} else {

		}
	}
}
