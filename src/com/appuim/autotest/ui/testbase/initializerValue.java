package com.appuim.autotest.ui.testbase;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class initializerValue {
	
	public static AndroidDriver<WebElement> driver;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@BeforeSuite
	// 针对所有测试，只执行一次，且必须为static void
	public void AutoTest() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("deviceName", "HUAWEI MT7-CL00");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.e.jiajie.user");
		capabilities.setCapability("appActivity",
				".activity.LaunchActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}
	@AfterSuite
	public static void teardoun() {
		driver.quit();
	}
}
