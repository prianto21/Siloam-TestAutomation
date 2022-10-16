package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//@FindBy(id = "logout")
//WebElement txt_logout;
//WebDriver driver;
//
//public homePage_PF(WebDriver driver) {
//	this.driver = driver;
//	PageFactory.initElements(driver,this);
//}
//
//public void checkLogoutIsDisplayed() {
//	txt_logout.isDisplayed();
//}
public class DashboardSalesPage {
	@FindBy(xpath = "//h1[normalize-space()='Home']")
	@CacheLookup
	WebElement txt_home;
	WebDriver driver;
	
	public DashboardSalesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkHome() {
//		assertEquals(txt_home.getText(), "Home");
		System.out.println(txt_home);
	}
	
}

