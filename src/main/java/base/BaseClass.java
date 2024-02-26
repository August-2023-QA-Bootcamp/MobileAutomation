package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import loggers.Loggers;

import static constant.IValue.*;
import static constant.CommonKey.*;
import static constant.CapsKey.*;
import page.nativeapp.demo.INativeHomePgae;
import page.nativeapp.demo.NativeAndroidHomePage;
import page.nativeapp.demo.NativeIOSHomePage;
import page.nativeapp.demo.NativeItemPage;
import page.nativeapp.nyt.NYTHomePage;
import page.webview.AndroidHomePage;
import page.webview.IHomePage;
import page.webview.IOSHomePage;
import util.Configuration;
import util.Configuration.Type;

public class BaseClass {
	
	protected static WebDriver driver;
	protected static DesiredCapabilities caps;
	
	protected static IHomePage homePage;
	protected static INativeHomePgae nativeHomePage;
	protected static NativeItemPage itemPage;
	protected static NYTHomePage nytHomePage;
	
	static Configuration commonConfig;
	static Configuration capsConfig;
	
	@BeforeAll
	public static void setUp() throws MalformedURLException {
		commonConfig = new Configuration(Type.COMMON);
		capsConfig = new Configuration(Type.DESIRE_CAPS);
		
		caps = new DesiredCapabilities();
		
		boolean installReq = Boolean.parseBoolean(commonConfig.get(INSTALL));
		boolean remote = Boolean.parseBoolean(commonConfig.get(REMOTE));
		
		String urlString = null;
		
		Loggers.log("Execution : " + commonConfig.get(EXECUTION));
		if (!remote) {
			if (commonConfig.get(EXECUTION).equals(BROWSER.getValue())) {
				browserExecution();
			} else if (commonConfig.get(EXECUTION).equals(APP)) {
				appExecution(installReq);
			}
		}
		
		Loggers.log("Remote Lunch ? " + remote);
		urlString = getAppiumUrl(remote, installReq);
		
		Loggers.log("URL " + urlString);
		
		URL url = new URL(urlString);
		
		driver = new RemoteWebDriver(url,caps);
		initPageObject();
		int wait = Integer.parseInt(commonConfig.get(WAIT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
		
		if(!installReq) {
			Loggers.log("Web App URL " + commonConfig.get(URL));
			driver.get(commonConfig.get(URL));
		}
	}
	
	public static String getAppiumUrl(boolean remote, boolean installReq) {
		if(remote) {
			if(installReq) {
				caps.setCapability(APP, capsConfig.get(BS_APP_ID));
			}else {
				caps.setCapability(BS_BROWSER, FIREFOX);
			}
		
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(BS_OS, capsConfig.get(PLATFORM));
			map.put(BS_OS_VER, capsConfig.get(PLATFORM_VER));
			map.put(BS_DEVICE, capsConfig.get(DEVICE_NAME));
			
			caps.setCapability(BS_OPTS, map);
			
			return commonConfig.get(REMOTE_URL);
		}else {
			Loggers.log("Platform " + capsConfig.get(PLATFORM));
			if(capsConfig.get(PLATFORM).equalsIgnoreCase(ANDROID)) {
				caps.setPlatform(Platform.ANDROID);
			}
			return commonConfig.get(LOCAL_URL);
		}
	}
	
	public static void browserExecution() {
		String browser = commonConfig.get(BROWSER);
		if(browser.equals(FIREFOX)) {
			Loggers.log("Browser : " + browser);
			fireFoxCaps();
		}
	}
	
	public static void appExecution(boolean installReq) {
		Loggers.log("Instanllation ? " + installReq);
		if(installReq) {
			caps.setCapability("appium:fullReset", true);
			String filePath = new File(capsConfig.get(APP_PATH)).getAbsolutePath();
			caps.setCapability("appium:app", filePath);
			Loggers.log("App Absolute File Path : " + filePath);
		}else {
			caps.setCapability(APPIUM_APP_PACKAGE, capsConfig.get(APP_PACKAGE));
			caps.setCapability(APPIUM_APP_ACTIVITY, capsConfig.get(APP_ACTIVITY));
		}
	}
	
	public static void fireFoxCaps() {
		caps.setCapability(APPIUM_APP_PACKAGE, commonConfig.get(BROWSER_PACKAGE));
		caps.setCapability(APPIUM_APP_ACTIVITY, commonConfig.get(BROWSER_ACTIVITY));
	}
	
	public static void initPageObject() {
		String platform = capsConfig.get(PLATFORM);
		if(platform.equalsIgnoreCase(IOS)) {
			homePage = new IOSHomePage(driver);
			nativeHomePage = new NativeIOSHomePage(driver);
		}else if(platform.equalsIgnoreCase(ANDROID)) {
			homePage = new AndroidHomePage(driver);
			nativeHomePage = new NativeAndroidHomePage(driver);
			itemPage = new NativeItemPage(driver);
			nytHomePage = new NYTHomePage(driver);
		}
	}
	
	@AfterEach
	public void cleanUp() {
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public Configuration getCommonConfig() {
		return commonConfig;
	}
	
	public Configuration getCapsConfig() {
		return capsConfig;
	}
	
}
