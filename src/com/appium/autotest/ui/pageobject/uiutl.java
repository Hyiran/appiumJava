package com.appium.autotest.ui.pageobject;

import com.appuim.autotest.ui.testbase.initializerValue;

public class uiutl extends initializerValue {

	/**
	 * 向上滑动
	 * 
	 * @param
	 */
	public void swipUp() {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 1000);
	}

	/**
	 * 向下滑动
	 * 
	 * @param
	 */
	public void swipDown() {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, 1000);
	}

	/**
	 * 向左滑动
	 * 
	 * @param
	 */
	public void swipLeft() {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, 1000);
	}

	/**
	 * 向右滑动
	 * 
	 * @param
	 */
	public void swipRight() {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, 1000);
	}

	/**
	 * ClassName+index
	 * 
	 * @param
	 */
	public boolean classid( String classname,int index) throws Exception{
		boolean flag = true;
		try {
			Thread.sleep(5000);
			driver.findElementByAndroidUIAutomator("new UiSelector().className("
					+ classname + ").index(" + index + ")");
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * id
	 * 
	 * @param
	 */
	public boolean id(int index) throws Exception{
		boolean flag = true;
		try {
			Thread.sleep(5000);
			driver.findElementByAndroidUIAutomator("new UiSelector().index("
					+ index + ")");
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * contentdesc
	 * 
	 * @param
	 */
	public boolean contentdesc(String dec) throws Exception{
		boolean flag = true;
		try {
			Thread.sleep(5000);
			driver.findElementByAccessibilityId(dec);
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * package
	 * 
	 * @param
	 */
	public boolean packageName(String name) throws Exception{
		boolean flag = true;
		try {
			Thread.sleep(5000);
			driver.findElementByAndroidUIAutomator("new UiSelector().packageName("
					+ name + ")");
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * className
	 * 
	 * @param
	 */
	public boolean className(String name)throws Exception {
		boolean flag = true;
		try {
			Thread.sleep(5000);
			driver.findElementByAndroidUIAutomator("new UiSelector().className("
					+ name + ")");
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * ClassName&dec属性定位控件
	 * 
	 * @param
	 */
	public boolean classdec(String name,String dec) throws Exception{
		boolean flag = true;
		try {
			Thread.sleep(5000);
			driver.findElementByAndroidUIAutomator("new UiSelector().className("
					+ name + ").description(" + dec + ")");
			return flag;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * package&dec属性定位控件
	 * 
	 * @param
	 */
	public boolean packgedec(String packge,String dec) throws Exception{
		boolean flag = true;
		try {
			Thread.sleep(5000);
			driver.findElementByAndroidUIAutomator("new UiSelector().packageName("
					+ packge + ").description(" + dec + ")");
			return flag;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * clickable属性定位控件
	 * 
	 * @param
	 */
	public boolean click(Boolean clickable) throws Exception{
		boolean flag = true;
		try {
			Thread.sleep(5000);
			driver.findElementByAndroidUIAutomator("new UiSelector().clickable("
					+ clickable + ")");
			return flag;
		} catch (Exception e) {
			return false;
		}
	}
}
