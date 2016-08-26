package com.appium.autotest.ui.method;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.appium.autotest.ui.pageobject.uiutl;

public class onceCleaning {

	commonCleaning commonCleaning = new commonCleaning();
	uiutl uiutl = new uiutl();

	/**
	 * 预约保洁时间段选择
	 * 
	 * @param String
	 *            text （时间段）
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void timeSlot(String text, AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {
		try {
			System.out.println("获取传入时间段");
			commonCleaning.sleep(3000);
			System.out.println("点击时间段");
			driver.findElementByAccessibilityId(text).click();
			System.out.println(text + "点击完成");
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("预约保洁时间段选择测试失败");
			// TODO: handle exception
		}

	}

	/**
	 * 服务频次选择
	 * 
	 * @param String
	 *            text （仅此一次/每周一次/每两周一次）
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void ServiceFrequency(AndroidDriver<WebElement> driver, String name)
			throws Exception, InterruptedException {
		try {
			System.out.println("获取传入服务频次");
			driver.findElementByAccessibilityId("服务频次").click();
			System.out.println("点击服务频次");
			commonCleaning.sleep(3000);
			if (name == "仅此一次") {
				driver.findElementByAccessibilityId("仅此一次").click();
				System.out.println("点击仅此一次");
				commonCleaning.sleep(3000);
			} else if (name == "每周一次") {
				driver.findElementByAccessibilityId("每周一次").click();
				System.out.println("点击每周一次");
				commonCleaning.sleep(3000);
			} else if (name == "每两周一次") {
				driver.findElementByAccessibilityId("每两周一次").click();
				System.out.println("点击每两周一次");
				commonCleaning.sleep(3000);
			}
			System.out.println("点击确定");
			commonCleaning.sleep(3000);
			driver.findElementByAccessibilityId("确定").click();
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("服务频次选择测试失败");
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
		// commonCleaning.logInfo("点击下一步");
		// driver.findElementByAccessibilityId("下一步").click();
		// commonCleaning.sleep(5000);
		commonCleaning.logInfo("订单确认界面");
		// driver.findElementByAccessibilityId("订单确认");
		// commonCleaning.logInfo("确认为订单确认界面");
		// commonCleaning.logInfo("选择支付方式");

		try {
			if (uiutl.contentdesc("订单确认")) {
				driver.findElementByAccessibilityId("确认提交").click();
				commonCleaning.sleep(5000);
			}
			for (int i = 0; i < 20; i++) {
				commonCleaning.logInfo("第"+i+"次等待");
				commonCleaning.sleep(2000);
				if (uiutl.contentdesc("订单详情")) {
					break;
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
	 * 确认订单
	 * 
	 * @param String
	 *            text （driver）
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void check(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			commonCleaning.sleep(5000);
			commonCleaning.logInfo("订单查看");
			driver.pressKeyCode(AndroidKeyCode.BACK);	
			//driver.findElementByAccessibilityId("全部订单").click();
			if(commonCleaning.verifyEquals("全部订单", driver))
			{
				commonCleaning.logInfo("点击全部订单");
				driver.findElementByAccessibilityId("全部订单").click();
			}
			commonCleaning.sleep(3000);
			//WebElement se = driver.findElementByAccessibilityId("家庭保洁待服务");
			//WebElement de = driver.findElementByAccessibilityId("待服务");
			if (commonCleaning.verifyEquals("家庭保洁待服务", driver)) {
				commonCleaning.logInfo("确认订单成功");
			} else if (commonCleaning.verifyEquals("待服务", driver)) {
				commonCleaning.logInfo("确认订单成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("确认订单测试失败");
			// TODO: handle exception
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
			if (commonCleaning.verifyEquals("取消并退款修改时间催单", driver)) {
				commonCleaning.logInfo("识别到取消并退款修改时间催单");
				int x = Integer.parseInt(commonCleaning.getXmlValue(
						"CancelOrderx2", "value")[0]);
				int y = Integer.parseInt(commonCleaning.getXmlValue(
						"CancelOrdery2", "value")[0]);
				driver.tap(1, x, y, 500);
				commonCleaning.sleep(5000);
				commonCleaning.logInfo("选择我不需要服务了");
				driver.findElementByAccessibilityId("不需要服务了").click();
				commonCleaning.sleep(5000);
				commonCleaning.logInfo("点击确认取消");
				driver.findElementByAccessibilityId("确认取消").click();
				commonCleaning.sleep(5000);
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
				int x = Integer.parseInt(commonCleaning.getXmlValue("delx2",
						"value")[0]);
				int y = Integer.parseInt(commonCleaning.getXmlValue("dely2",
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

	/***
	 * 可选时间段检索
	 * 
	 * @param file
	 * @param value
	 * @param attr
	 * @return String[]
	 */
	public void timeSearch(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			String[] StringsArray = { "8:00-10:00", "8:30-10:30", "9:00-11:00",
					"9:30-11:30", "10:00-12:00", "10:30-12:30", "11:00-13:00",
					"11:30-13:30", "12:00-14:00", "12:30-14:30", "13:00-15:00",
					"13:30-15:30", "14:00-16:00", "14:30-16:30", "15:00-17:00",
					"15:30-17:30", "16:00-18:00", "16:30-18:30", "17:00-19:00",
					"17:30-19:30", "18:00-20:00" };
			for (int i = 0; i < StringsArray.length; i++) {
				commonCleaning.logInfo("循环点击时间点");
				commonCleaning.sleep(5000);
				driver.findElementByAccessibilityId(StringsArray[i]).click();
				commonCleaning.logInfo("点击确认选择");
				commonCleaning.sleep(3000);
				driver.findElementByAccessibilityId("确认选择").click();
				commonCleaning.sleep(5000);
				if (uiutl.contentdesc("订单确认")) {
					break;
				} else if (uiutl.contentdesc("提示")) {
					commonCleaning.sleep(3000);
					driver.findElementByAccessibilityId("确定").click();
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("可选时间段检索测试失败");
			// TODO: handle exception
		}
	}
}
