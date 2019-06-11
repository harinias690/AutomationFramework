package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	/**************************************************************************** 
	 * Home Page Objects
	 ****************************************************************************/
		
	@FindBy(xpath = "//a[text()='REGISTER']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[text()='REGISTER']")
	private List<WebElement> registerLinkElements;
	
	
	/**************************************************************************** 
	 * Home Page Constructor
	 ****************************************************************************/
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**************************************************************************** 
	 * Home Page Methods
	 ****************************************************************************/
	public WebElement getRegisterLink() {
		return registerLink;
	}

	public int getRegisterLinkSize() {
		return registerLinkElements.size();
	}
	
}
