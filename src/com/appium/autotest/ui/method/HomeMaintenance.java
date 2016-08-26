package com.appium.autotest.ui.method;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.appium.autotest.ui.pageobject.uiutl;

public class HomeMaintenance {

	commonCleaning commonCleaning = new commonCleaning();
	uiutl uiutl = new uiutl();

	/**
	 * 家庭维修选择
	 * 
	 * @param String
	 *            灯具维修，水电维修。房屋维修，家具维修
	 * @return boolean
	 * @throws exception
	 */
	public void Maintenance(String name, AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {
		try {
			commonCleaning.logInfo("点击家庭维修");
			driver.findElementByAccessibilityId("家庭维修家庭维修 Link").click();
			commonCleaning.sleep(3000);
			commonCleaning.logInfo("正在选择...");
			String[] cleaning = { "灯具维修", "水电维修", "房屋维修", "家具维修" };
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
			AssertJUnit.fail("家庭维修选择测试失败");
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
			if (ae.equals(ae)) {
				commonCleaning.logInfo("预约界面识别正常");
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
	 * 二级菜单选择
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void MenuSelect(AndroidDriver<WebElement> driver, String name,
			String text) throws Exception, InterruptedException {
		try {
			commonCleaning.logInfo("二级菜单选择");
			WebElement ae = driver.findElementByAccessibilityId(name);
			WebElement se = driver.findElementByAccessibilityId(text);
			WebElement de = driver.findElementByAccessibilityId("确认项目");
			commonCleaning.logInfo("开始识别" + name + "控件");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("识别到" + name + "控件");
				commonCleaning.logInfo("点击" + name + "控件");
				ae.click();
				commonCleaning.sleep(3000);
				commonCleaning.logInfo("识别" + text + "控件");
				if (se.equals(se)) {
					commonCleaning.logInfo("识别到" + text + "控件");
					commonCleaning.logInfo("点击数量+控件");
					driver.tap(1, 987, 496, 500);
					commonCleaning.sleep(3000);
					commonCleaning.logInfo("点击确认项目");
					de.click();
					commonCleaning.sleep(3000);
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("二级菜单选择测试失败");
			// TODO: handle exception
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
	public void payMode(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		commonCleaning.sleep(5000);
		commonCleaning.logInfo("订单确认界面");
		try {
			if (uiutl.contentdesc("订单确认")) {
				driver.findElementByAccessibilityId("确认提交").click();
				for (int i = 0; i < 20; i++) {
					commonCleaning.logInfo("第" + i + "次等待");
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
	 * 灯具维修订单确认
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void checkLampe(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);
			WebElement ae = driver.findElementByAccessibilityId("灯具维修待指派");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("灯具维修待指派");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("识别灯具维修待指派失败");
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
	 * 水电维修订单确认
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void checkWater(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);
			WebElement ae = driver.findElementByAccessibilityId("水电维修待指派");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("水电维修待指派");
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("识别水电维修指派失败");
		}
	}
	/**
	 * 家具维修订单确认
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void checkFurniture(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);
			WebElement ae = driver.findElementByAccessibilityId("家具维修待指派");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("家具维修待指派");
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("识别家具维修指派失败");
		}
	}
	
	/**
	 * 房屋维修订单确认
	 * 
	 * 
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void checkHouse(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			driver.pressKeyCode(AndroidKeyCode.BACK);
			commonCleaning.sleep(10000);
			WebElement ae = driver.findElementByAccessibilityId("房屋维修待指派");
			if (ae.equals(ae)) {
				commonCleaning.logInfo("房屋维修待指派");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("识别房屋维修指派失败");
		}
	}
}