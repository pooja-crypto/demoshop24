package com.demoshop24.test;

import java.awt.Window;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.demoshop24.base.BasePage;
import com.demoshop24.base.Page;
import com.demoshop24.pages.Header;
import com.demoshop24.utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	Properties prop;
	public Page page;
	static String filePath = System.getProperty("user.dir") + "/src/main/java/" + "//resources/searchKeywordData.xlsx";
	static String sheetName = "SearchPageData";

	@BeforeClass()
	public void loadProperties() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/" + "//resources/config.properties");
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setup() {
		String browser = System.getProperty("browser");
		launchBrowser(browser);
		page.getInstance(Header.class).clickOnLogin();

	}

	private void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("baseurl"));
		page = new BasePage(driver);

	}

	@DataProvider
	public Object[][] getSearchTestData() throws Exception {
		Object[][] data = TestUtil.getTestData(filePath, sheetName);
		return data;
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
