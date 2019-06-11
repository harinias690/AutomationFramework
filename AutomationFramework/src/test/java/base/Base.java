package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import reporting.CustomReporter;

import com.aventstack.extentreports.ExtentReports;

public abstract class Base {

	protected WebDriver driver;
	protected Properties p;
	protected ExtentReports reports;

	public Base() {
		reports = CustomReporter.getExtentReports();
		System.out.println("base constructor start");
		p = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir")
							+ "\\src\\test\\resources\\config\\config.properties");
			p.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("base constructor end");
	}

	public void setUp() {
		String browser;
		browser = p.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-infobars");
			System.setProperty("webdriver.chrome.driver",
					p.getProperty("chromedriver"));
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					p.getProperty("geckodriver"));
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver", p.getProperty("iedriver"));
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void tearDown() {
		driver.quit();
	}

}
