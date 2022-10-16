package com.soliam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.DashboardSalesPage;
import pages.LoginPage;

public class UserSales {
	WebDriver driver = null;
	String baseURL = "https://dev.ptdika.com/siloam/";
	LoginPage login;
	DashboardSalesPage dashboard_sales;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/home/ancient/Downloads/chromedriver_linux64/chromedriver");
		this.driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver.navigate().to(baseURL);

	}

	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		login = new LoginPage(driver);
		login.enterUsername("D6200927");
		login.enterPassword("19971023");
		Thread.sleep(1000);

	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		login.clickOnLogin();
	}

	@Then("user is navigate to the homepage sales")
	public void user_is_navigate_to_the_homepage_sales() {
		boolean state=true;
				while(state) {
					try {
						dashboard_sales = new DashboardSalesPage(driver);
						dashboard_sales.checkHome();
						state=false;
						
					}catch (java.lang.NullPointerException e) {
						
					}
				}
		

	}

	@When("klik menu input")
	public void klik_menu_input() {

	}

	@Then("user berada di Form Input")
	public void user_berada_di_Form_Input() {

	}

	@When("user mengisi Nama,Nomor Bpjs,Nomor Ktp,Alamat,Kota Ktp,faskes awal,faskes tujuan dan alasan")
	public void user_mengisi_Nama_Nomor_Bpjs_Nomor_Ktp_Alamat_Kota_Ktp_faskes_awal_faskes_tujuan_dan_alasan() {

	}

	@When("User klik Simpan Data")
	public void user_klik_Simpan_Data() {

	}

	@Then("user berada di form upload document")
	public void user_berada_di_form_upload_document() {

	}

}
