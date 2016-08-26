package com.appium.autotest.ui.method;



import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.appium.autotest.ui.pageobject.uiutl;

public class threeCleaning {

	commonCleaning commonCleaning = new commonCleaning();
	uiutl uiutl = new uiutl();
	/**
	 * 支付方式选择 payMode
	 * 
	 * @param String
	 *            text （现金支付，在线支付）
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void payMode(String name, AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {
		try {
			if (commonCleaning.verifyEquals("订单确认", driver)) {
				commonCleaning.logInfo("订单确认界面");
				commonCleaning.logInfo("选择支付方式");
				commonCleaning.sleep(3000);
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
			AssertJUnit.fail("支付方式选择测试失败");
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
		commonCleaning.sleep(10000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		commonCleaning.sleep(10000);
		commonCleaning.logInfo("待服务");
		try {
			//driver.findElementByAccessibilityId("待服务5").click();
			driver.tap(1, 684, 275, 500);
			commonCleaning.sleep(3000);
			if (commonCleaning.verifyEquals("取消并退款修改时间", driver)) {
				commonCleaning.logInfo("识别取消并退款修改时间");
				int x = Integer.parseInt(commonCleaning.getXmlValue(
						"CancelOrderx1", "value")[0]);
				int y = Integer.parseInt(commonCleaning.getXmlValue(
						"CancelOrdery1", "value")[0]);
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
				commonCleaning.sleep(5000);
			
			}else {
				AssertJUnit.fail("取消订单测试失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			AssertJUnit.fail("取消订单测试失败");
		}
	}

	/**
	 * 阿姨选择
	 * 
	 * @param String
	 *            text （阿姨）
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void aunt(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			commonCleaning.sleep(10000);
			commonCleaning.logInfo("阿姨选择");
			if (commonCleaning.verifyEquals("测试3", driver)) {
				driver.findElementByAccessibilityId("测试3").click();
				commonCleaning.logInfo("点击选择");
				commonCleaning.sleep(3000);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("阿姨选择失败");
		}

	}

	/**
	 * 服务日期选择
	 * 
	 * @param String
	 *            (今天/明天/后天/大后天)
	 * @return boolean
	 * @throws exception
	 */
	public void daayTime(String name, AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {
		try {
			System.out.println("今天/明天/后天/大后天选择");
			driver.findElementByAccessibilityId("选择服务时间");
			System.out.println("选择服务时间界面");
			if (name == "今天") {
				int x1 = Integer.parseInt(commonCleaning.getXmlValue("Todayx1",
						"value")[0]);
				int x2 = Integer.parseInt(commonCleaning.getXmlValue("Todayy1",
						"value")[0]);
				System.out.println("时间今天");
				driver.tap(1, x1, x2, 500);
				commonCleaning.sleep(3000);
			} else if (name == "明天") {
				driver.findElementByAccessibilityId("明天").click();
				commonCleaning.sleep(3000);
				System.out.println("时间明天");
			} else if (name == "后天") {
				int x3 = Integer.parseInt(commonCleaning.getXmlValue(
						"bermorgenx1", "value")[0]);
				int x4 = Integer.parseInt(commonCleaning.getXmlValue(
						"bermorgeny1", "value")[0]);
				System.out.println("时间后天");
				driver.tap(1, x3, x4, 500);
				commonCleaning.sleep(3000);

			} else if (name == "大后天") {
				int x5 = Integer.parseInt(commonCleaning.getXmlValue(
						"Bigbermorgenx1", "value")[0]);
				int x6 = Integer.parseInt(commonCleaning.getXmlValue(
						"Bigbermorgeny1", "value")[0]);
				System.out.println("时间大后天");
				driver.tap(1, x5, x6, 500);
				commonCleaning.sleep(3000);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("服务日期选择测试失败");
		}
	}

	/**
	 * 服务时间选择
	 * 
	 * @param String
	 *            (8：00-10：00)
	 * @return boolean
	 * @throws exception
	 */
	public void time(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		try {
			int x = Integer.parseInt(commonCleaning.getXmlValue("time1x",
					"value")[0]);
			int y = Integer.parseInt(commonCleaning.getXmlValue("time1y",
					"value")[0]);
			driver.tap(1, x, y, 500);
			if (commonCleaning.verifyEquals("确认选择", driver)) {
				driver.findElementByAccessibilityId("确认选择").click();
				commonCleaning.sleep(10000);
			}
			if (commonCleaning.verifyEquals("首次服务时间", driver)) {
				 int x1 = Integer.parseInt(commonCleaning.getXmlValue("auntx",
				 "value")[0]);
				 int x2 = Integer.parseInt(commonCleaning.getXmlValue("aunty",
				 "value")[0]);
				 driver.tap(1, x1, x2, 500);
				 commonCleaning.sleep(5000);
				 driver.findElementByAccessibilityId("确认选择").click();
				 commonCleaning.sleep(10000);
			}
			if (commonCleaning.verifyEquals("订单确认", driver)) {
				System.out.println("订单确认成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonCleaning.screen(driver);
			commonCleaning.sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			commonCleaning.sleep(10000);
			AssertJUnit.fail("服务时间选择测试失败");
		}
	}
}
