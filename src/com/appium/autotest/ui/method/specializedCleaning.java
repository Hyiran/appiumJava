package com.appium.autotest.ui.method;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.appium.autotest.ui.pageobject.uiutl;

public class specializedCleaning {

	commonCleaning commonCleaning = new commonCleaning();
	uiutl uiutl = new uiutl();

	/**
	 * 专业保洁选择
	 * 
	 * @param String
	 *            新居开荒，厨房高温保洁，卫生间保洁，窗纱更换，擦玻璃，地面净化除菌
	 * @return boolean
	 * @throws exception
	 */
	public void ZYCleaning(String name, AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {

		System.out.println("日常/周期保洁，选择中");
		try {
			commonCleaning.logInfo("点击专业保洁");
			driver.findElementByAccessibilityId("专业保洁专业保洁 Link").click();
			commonCleaning.sleep(3000);
			commonCleaning.logInfo("正在选择...");
			String[] cleaning = { "新居开荒", "厨房高温保洁", "窗纱更换", "擦玻璃", "地面净化除菌",
					"卫生间保洁" };
			for (int i = 0; i < cleaning.length; i++) {
				commonCleaning.logInfo("第" + i + "次对比");
				if (name == cleaning[i]) {
					driver.findElementByAccessibilityId(name).click();
					commonCleaning.sleep(3000);
					break;
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("专业保洁选择测试失败");
		}
	}
	/**
	 * 预约界面
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void Reservation(String name, AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {
		try {
			WebElement ae = driver.findElementByAccessibilityId(name);
			WebElement se = driver.findElementByAccessibilityId("立即预约");
			if (ae.equals(ae)) {
				if (commonCleaning.verifyEquals("立即预约", driver)) {
					se.click();
					commonCleaning.sleep(3000);
				} 
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("预约界面测试失败");
		}
	}

	/**
	 * 订单确认界面
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void confirmation(AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {
		try {
			WebElement ae = driver.findElementByAccessibilityId("订单确认");
			commonCleaning.sleep(3000);
			if (ae.equals(ae)) {
				commonCleaning.logInfo("订单确认界面识别成功");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("订单确认界面失败");
		}

	}

	/**
	 * 预约保洁时间段选择
	 * 
	 * @param String
	 *            text （时间段选择，1-5时间段）
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void timeSlot(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			commonCleaning.sleep(3000);
			WebElement ae = driver.findElementByAccessibilityId("请选择时间");
			commonCleaning.logInfo("点击选择时间段");
			ae.click();
			commonCleaning.sleep(3000);
			commonCleaning.logInfo("点击可选择最后一天");
			driver.tap(1, 868, 944, 500);
			commonCleaning.sleep(3000);
			commonCleaning.logInfo("正在选择...");
			driver.tap(1, 156, 1101, 500);
			commonCleaning.sleep(3000);
			driver.tap(1, 992, 816, 500);
			commonCleaning.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("预约保洁时间段选择失败");
		}
	}

	/**
	 * 支付方式选择 payMode
	 * 
	 * @param String
	 *            text （现金支付，在线支付）
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void payMode(AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {
		commonCleaning.sleep(5000);
		commonCleaning.logInfo("订单确认界面");
		try {
			if (uiutl.contentdesc("订单确认")) {
				driver.findElementByAccessibilityId("确认提交").click();
				for (int i = 0; i < 20; i++) {
					commonCleaning.logInfo("第"+i+"次等待");
					if (uiutl.contentdesc("订单详情")) {
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("支付方式选择测试失败");
		}

	}
	/**
	 * 确认提交
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void submit(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		WebElement ae = driver.findElementByAccessibilityId("确认提交");
		if (ae.equals(ae)) {
			commonCleaning.logInfo("确认提交识别成功");
			commonCleaning.logInfo("点击确认提交");
			ae.click();
			commonCleaning.sleep(10000);
		} else {
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("确认提交失败");
		}
	}

	/**
	 * 新居开荒订单确认
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void checkHome(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);
			WebElement ae = driver.findElementByAccessibilityId("新居开荒待指派");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("识别新居开荒待指派");
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("识别新居开荒待指派失败");
		}
	}
	/**
	 * 取消订单
	 * 
	 * @param String
	 *            text （driver）
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void abrogate(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		commonCleaning.logInfo("点击全部订单");
		try {
			driver.findElementByAccessibilityId("全部订单").click();
			commonCleaning.sleep(3000);
			if (commonCleaning.verifyEquals("取消并退款", driver)) {

				commonCleaning.logInfo("识别到取消并退款");
				int x = Integer.parseInt(commonCleaning.getXmlValue(
						"CancelOrderx", "value")[0]);
				int y = Integer.parseInt(commonCleaning.getXmlValue(
						"CancelOrdery", "value")[0]);
				driver.tap(1, x, y, 500);
				commonCleaning.sleep(3000);
				commonCleaning.logInfo("选择我不需要服务了");
				driver.findElementByAccessibilityId("不需要服务了").click();
				commonCleaning.sleep(3000);
				commonCleaning.logInfo("点击确认取消");
				driver.findElementByAccessibilityId("确认取消").click();
				commonCleaning.sleep(3000);
				commonCleaning.logInfo("点击确定");
				driver.findElementByAccessibilityId("确定").click();
				commonCleaning.sleep(20000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("取消订单测试失败");
		}
	}
	
	/**
	 * 删除订单
	 * 
	 * @param String
	 *            text （driver）
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void del(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			if (commonCleaning.verifyEquals("删除订单", driver)) {
				commonCleaning.logInfo("识别到删除订单");
				commonCleaning.logInfo("点击全部订单");
				commonCleaning.sleep(10000);
				driver.findElementByAccessibilityId("全部订单").click();
				commonCleaning.sleep(3000);
				commonCleaning.logInfo("删除订单");
				int x = Integer.parseInt(commonCleaning.getXmlValue("delx",
						"value")[0]);
				int y = Integer.parseInt(commonCleaning.getXmlValue("dely",
						"value")[0]);
				driver.tap(1, x, y, 500);
				commonCleaning.sleep(3000);
				commonCleaning.logInfo("确定");
				driver.findElementByAccessibilityId("确定").click();
				commonCleaning.sleep(3000);
				driver.pressKeyCode(AndroidKeyCode.BACK);
				commonCleaning.sleep(3000);
			}

		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("删除订单测试失败");
			// TODO: handle exception
		}

	}
	
	
	/**
	 * 卫生间保洁订单确认
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void kitwashroom(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);

			WebElement ae = driver.findElementByAccessibilityId("卫生间保洁待指派");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("卫生间保洁订单确认成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("卫生间保洁订单确认失败");
		}
	}
	
	/**
	 * 厨房高温保洁订单确认
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void kitchen(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);

			WebElement ae = driver.findElementByAccessibilityId("厨房高温保洁待指派");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("厨房高温保洁订单确认成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("厨房高温保洁订单确认失败");
		}
	}
	/**
	 * 擦玻璃保洁订单确认
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void wipeGlass(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);
			WebElement ae = driver.findElementByAccessibilityId("擦玻璃待指派");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("擦玻璃订单确认成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("擦玻璃订单确认失败");
		}
	}
	/**
	 * 地面净化除菌订单确认
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void groundCleaningSterilization(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);
			WebElement ae = driver.findElementByAccessibilityId("地面净化除菌待指派");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("地面净化除菌订单确认成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("地面净化除菌订单确认失败");
		}
	}
	/**
	 * 纱窗更换下单
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	
	public void Windows(AndroidDriver<WebElement> driver)throws Exception,InterruptedException{
		
		try {
			WebElement ae = driver.findElementByAccessibilityId("窗纱更换");
			WebElement se = driver.findElementByAccessibilityId("平推窗纱");
			//WebElement de = driver.findElementByAccessibilityId("隐形窗纱");
			commonCleaning.logInfo("识别纱窗更换服务界面");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("识别纱窗更换服务界面成功");
				commonCleaning.logInfo("点击平推纱窗");
				se.click();
				commonCleaning.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("纱窗更换下单失败");
		}	
	}
	/**
	 * 纱窗更换订单确认
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void WindowsCheck(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);
			WebElement ae = driver.findElementByAccessibilityId("窗纱更换待指派");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("窗纱更换订单确认成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("窗纱更换订单确认失败");
		}
	}
}
