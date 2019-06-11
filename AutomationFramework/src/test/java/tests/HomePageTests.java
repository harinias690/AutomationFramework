package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import base.Base;

public class HomePageTests extends Base {

	private HomePage hp;

	public HomePageTests() {

	}

	@BeforeMethod
	public void bm() {
		setUp();
		driver.get(p.getProperty("url"));
		hp = new HomePage(driver);
	}

	@Test
	public void verifyPageTitle() {
		reports.createTest("HomePageTests - verifyPageTitle");
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
	}

	@Test(dependsOnMethods = { "verifyPageTitle" })
	public void verfiyRegisterPresence() {
		reports.createTest("HomePageTests - verifyRegisterPresence");
		Assert.assertTrue(hp.getRegisterLinkSize() > 0);
	}

	@AfterMethod
	public void am() {
		tearDown();
	}

}
