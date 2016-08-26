package com.appium.autotest.ui.method;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.appium.autotest.ui.pageobject.uiutl;

public class commonCleaning {

	uiutl uiutl = new uiutl();

	/**
	 * 日常保洁
	 * 
	 * @param String
	 *            日常保洁/周期保洁
	 * @return boolean
	 * @throws exception
	 */
	public void Cleaning(String name, AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {

		System.out.println("日常/周期保洁，选择中");
		try {
			if (name == "日常保洁") {
				driver.findElementByAccessibilityId(".日常保洁家庭保洁 预约随心. Link")// 
						.click();
				sleep(2000);
				System.out.println("点击日常保洁成功");
			} else if (name == "周期保洁") {
				driver.findElementByAccessibilityId(".周期保洁一次下单 清洁无忧. Link")// 
						.click();
				sleep(2000);
				;
				System.out.println("点击周期保洁成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			screen(driver);
			sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			sleep(10000);
			AssertJUnit.fail("日常保洁测试失败");
		}
	}

	/**
	 * 启动界面检查
	 * 
	 * @param String
	 *            (启动后延时等待20s)
	 * @return boolean
	 * @throws exception
	 */
	public void CheckHome(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		System.out.println("查看是成功登陆app");
		try {
			System.out.println("启动后延时等待20s");
			for (int i = 0; i < 30; i++) {
				logInfo("第" + i + "次对比");
				sleep(2000);
				//WebElement ae = driver.findElementByAccessibilityId("订单 Link");
				if (verifyEquals("订单 Link", driver)) {  // Link
					sleep(5000);
					System.out.println("启动界面成功");
					sleep(3000);
					driver.tap(1, 116, 1716, 500);//4.4x
					//driver.tap(1, 142, 1838, 500);//6.0x
					sleep(10000);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			screen(driver);
			sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			sleep(10000);
			AssertJUnit.fail("启动界面测试失败加载超时");
		}
	}

	/**
	 * 预约保洁
	 * 
	 * @param String
	 *            单次预约/双周预约/周期预约
	 * @return boolean
	 * @throws exception
	 */
	public void optionForward(String name, AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {

		try {
			System.out.println("确认切换至预约保洁界面");
			sleep(2000);
			driver.findElementByAccessibilityId("预约保洁");
			sleep(2000);
			System.out.println("确认切换至预约保洁界面成功");
			sleep(2000);
			System.out.println("单次预约/双周预约/周期预约选择中");
			sleep(2000);
			if (name == "单次预约") {
				driver.findElementByAccessibilityId("单次预约").click();
				sleep(2000);
				System.out.println("点击单次预约");
			} else if (name == "双周预约") {
				driver.findElementByAccessibilityId("双周预约").click();
				sleep(2000);
				System.out.println("点击双周预约");
			} else if (name == "周期预约") {
				driver.findElementByAccessibilityId("周期预约").click();
				sleep(2000);
				System.out.println("点击周期预约");
			}
		} catch (Exception e) {
			e.printStackTrace();
			screen(driver);
			sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			sleep(10000);
			AssertJUnit.fail("预约保洁测试失败");

		}
	}

	/**
	 * 等待时间
	 * 
	 * @param String
	 *            (时长 int)
	 * @return boolean
	 * @throws exception
	 */
	public void sleep(int x) throws Exception, InstantiationException {

		Thread.sleep(x);
		System.out.println("等待时间为" + x + "毫秒");
	}

	/***
	 * 解析XML
	 * 
	 * @param file
	 * @param value
	 * @param attr
	 * @return String[]
	 */
	public String[] getXmlValue(String value, String attr) {
		try {
			System.out.println("【通过XML获得变量值】");
			System.out.println("getXmlValue: 开始");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder
					.parse("file:///Users/zhangchao/Documents/workspace/AutoUserTest4x/xml/uiautomator.xml"); // 获取到xml文件 4.4x	
			String s;
			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			XPathExpression expr = xpath.compile("//param"); // 获取节点名称
			NodeList nodes = (NodeList) expr.evaluate(doc,
					XPathConstants.NODESET);
			ArrayList<String> sp = new ArrayList<String>();
			for (int i = 0; i < nodes.getLength(); i++) {
				Node nd = nodes.item(i);
				if (nd.getAttributes().getNamedItem("name").getNodeValue()
						.equals(value)) {
					s = nd.getAttributes().getNamedItem(attr).getNodeValue();
					// System.out.println("--getXmlValue-- :" + s);
					sp.add(s);
				}
			}
			String[] array = (String[]) sp.toArray(new String[0]);
			// System.out.println(array.length);
			return array;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("getXmlValue: 结束");
		return null;
	}

	/**
	 * 异常屏幕截图
	 * 
	 * @param String
	 *            text （driver）
	 * @return UiObject
	 * @throws UiObjectNotFoundException
	 */
	public void screen(AndroidDriver<WebElement> driver) {
		// 截屏并保存至本地
		File screen = driver.getScreenshotAs(OutputType.FILE);
		File screenFile = new File(
				"file:///Users/zhangchao/Documents/workspace/AutoUserTest4x/"
						+ getCurrentDateTime() + ".png");
		try {
			FileUtils.copyFile(screen, screenFile); // commons-io-2.0.1.jar中的api
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getCurrentDateTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");// 设置日期格式
		return df.format(new Date());
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
				int x1 = Integer.parseInt(getXmlValue("Todayx", "value")[0]);
				int x2 = Integer.parseInt(getXmlValue("Today", "value")[0]);
				System.out.println("时间今天");
				driver.tap(1, x1, x2, 500);
			} else if (name == "明天") {
				driver.findElementByAccessibilityId("明天").click();
				sleep(3000);
				System.out.println("时间明天");
			} else if (name == "后天") {
				int x3 = Integer
						.parseInt(getXmlValue("bermorgenx", "value")[0]);
				int x4 = Integer
						.parseInt(getXmlValue("bermorgeny", "value")[0]);
				System.out.println("时间后天");
				driver.tap(1, x3, x4, 500);

			} else if (name == "大后天") {
				int x5 = Integer
						.parseInt(getXmlValue("Bigbermorgenx", "value")[0]);
				int x6 = Integer
						.parseInt(getXmlValue("Bigbermorgeny", "value")[0]);
				System.out.println("时间大后天");
				driver.tap(1, x5, x6, 500);
			}
		} catch (Exception e) {
			e.printStackTrace();
			screen(driver);
			sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			sleep(10000);
			AssertJUnit.fail("服务日期选择测试失败");
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
				logInfo("循环点击时间点");
				driver.findElementByAccessibilityId(StringsArray[i]).click();
				logInfo("点击确认选择");
				sleep(3000);
				if (uiutl.contentdesc("确认选择")) {
					driver.findElementByAccessibilityId("确认选择").click();
					sleep(10000);
				} else if (uiutl.contentdesc("提交订单")) {
					driver.findElementByAccessibilityId("提交订单").click();
					sleep(10000);
				}
				sleep(3000);
				if (uiutl.contentdesc("请先选择时间段")) {
					logInfo("点击确定");
					driver.findElementByAccessibilityId("确定").click();
					sleep(10000);
				} else if (uiutl.contentdesc("首次服务时间")) {
					int x1 = Integer.parseInt(getXmlValue("auntx", "value")[0]);
					int x2 = Integer.parseInt(getXmlValue("aunty", "value")[0]);
					driver.tap(1, x1, x2, 500);
					sleep(5000);
					driver.findElementByAccessibilityId("提交订单").click();
					sleep(10000);
				} else if (uiutl.contentdesc("订单确认")) {
					break;
				} else if (uiutl.contentdesc("额外任务")) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			screen(driver);
			sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			sleep(10000);
			AssertJUnit.fail("可选时间段检索测试失败");
			// TODO: handle exception
		}
	}

	/**
	 * LOG
	 * 
	 * @param message
	 */
	public void logInfo(String message) {
		System.out.println("====" + message + "====");
	}

	/**
	 * 比较两个对象是否一致。
	 * 
	 * @param actual
	 *            the actual object.
	 * @return
	 */
	public boolean verifyEquals(String name, AndroidDriver<WebElement> driver) {
		boolean flag = true;
		try {
			for (int i = 0; i < 30; i++) {
				logInfo("第"+i+"次循环");
				sleep(1000);
				WebElement ae = driver.findElementByAccessibilityId(name);
				if (ae.equals(ae)) {
					break;
				}
			}
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 地址时间选择
	 * 
	 * @param mapview
	 * 
	 * @param String
	 *            (地址选择/时间选择。地址暂时选择默认地址)
	 * @return boolean
	 * @throws exception
	 */
	public void localTime(String name, AndroidDriver<WebElement> driver)
			throws Exception, InterruptedException {
		try {
			System.out.println("地点/时间选择");
			if (name == "地址选择") {
				driver.findElementByAccessibilityId("大悦城(朝阳)离开了").click();
				sleep(2000);
				System.out.println("点击地点");
				sleep(2000);
				driver.findElementByAccessibilityId("大悦城(朝阳)离开了").click();
				sleep(2000);
				System.out.println("选择地点");
			} else if (name == "时间选择") {
				int x1 = Integer.parseInt(getXmlValue("Timex", "value")[0]);
				int x2 = Integer.parseInt(getXmlValue("Timey", "value")[0]);
				driver.tap(1, x1, x2, 500);
				sleep(2000);
				System.out.println("时间点击");
			}
		} catch (Exception e) {
			e.printStackTrace();
			screen(driver);
			sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			sleep(10000);
			AssertJUnit.fail("地址时间选择");
			// TODO: handle exception
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
			sleep(3000);
			logInfo("阿姨选择");
			// driver.findElementByAndroidUIAutomator("使用推荐阿姨").click();
			WebElement aunty = driver
					.findElementByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").description(\"使用推荐阿姨\")");
			aunty.click();
			logInfo("点击选择");
			sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			screen(driver);
			sleep(10000);
			driver.startActivity("com.e.jiajie.user", ".activity.LaunchActivity");
			sleep(10000);
			AssertJUnit.fail("阿姨选择失败");
		}

	}

	/**
	 * @Description：左右滑屏找到符号条件的object
	 * @param classname
	 * @param text
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public boolean search_scrollHor(String text,
			AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		commonCleaning commonCleaning = new commonCleaning();
		boolean flag = false;
		commonCleaning.logInfo("【水平滑动寻找控件】");
		commonCleaning.logInfo("search_scrollHor: 开始");
		// WebElement e1 = driver.findElementByAccessibilityId(text);
		int i = 0, j = 0;
		do {

			if (uiutl.contentdesc(text)) {

				flag = true;
				break;
			} else {
				i++;
				driver.swipe(962, 946, 146, 946, 2000);
				sleep(5000);
				System.out.println(i);
			}
		} while (i < 10);
		// 如果对象不存在，向右滑动寻找
		do {

			if (uiutl.contentdesc(text)) {
				flag = true;
				break;
			} else {
				j++;
				driver.swipe(146, 946, 962, 946, 2000);
				sleep(5000);
				System.out.println(j);

			}
		} while (i < 10);
		commonCleaning.logInfo("search_scrollVHor: 结束");
		return flag;
	}

	/**
	 * @Description：上下滑屏找到符号条件的object
	 * @param classname
	 * @param text
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public boolean search_scrollVer(String text,
			AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		boolean flag = false;
		commonCleaning commonCleaning = new commonCleaning();
		commonCleaning.logInfo("【垂直滑动寻找控件】");
		commonCleaning.logInfo("search_scrollHor: 开始");
		int i = 0, j = 0;
		do {

			if (uiutl.contentdesc(text)) {
				flag = true;
				break;

				// return flag;
			} else {
				i++;
				driver.swipe(497, 1400, 497, 545, 2000);
				sleep(5000);
				// uiutl.swipUp(driver);
				System.out.println(i);
			}
		} while (i < 10);
		// 如果对象不存在，向右滑动寻找
		do {
			if (uiutl.contentdesc(text)) {
				flag = true;
				break;
				// return flag;
			} else {
				j++;
				driver.swipe(497, 545, 497, 1400, 2000);
				sleep(5000);
				// uiutl.swipDown(driver);
				System.out.println(j);
			}
		} while (j < 10);
		commonCleaning.logInfo("search_scrollVHor: 结束");
		return flag;
	}

	/**
	 * @Description：滑动订单页至最顶端
	 * @param classname
	 * @param text
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public void searchUP(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		int i = 0;
		do {
			System.out.println("第" + i + "次滑动");
			i++;
			driver.swipe(497, 545, 497, 1400, 2000);
			sleep(3000);
			// uiutl.swipDown(driver);
			System.out.println(i);
		} while (i <= 10);
	}

	/**
	 * @Description：滑动订单页至最顶端
	 * @param classname
	 * @param text
	 * @return
	 * @throws UiObjectNotFoundException
	 */
	public void searchDow(AndroidDriver<WebElement> driver) throws Exception,
			InterruptedException {
		int i = 0;
		do {
			System.out.println("第" + i + "次滑动");
			i++;
			driver.swipe(497, 1400, 497, 545, 2000);
			sleep(3000);
			// uiutl.swipDown(driver);
			System.out.println(i);
		} while (i <= 10);
	}
}
