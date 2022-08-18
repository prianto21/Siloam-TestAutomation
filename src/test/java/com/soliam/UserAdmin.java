package com.soliam;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.Assert;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;

public class UserAdmin {

	WebDriver driver = null;
	String baseURL = "https://dev.ptdika.com/siloam/";

	static ExtentTest extentTest;
	static ExtentReports reports;
	String direktoriFile = System.getProperty("user.dir") + "/test-output/screenshoot/myfile.png";

	@Before
	public void setUp() {
		
		reports = new ExtentReports("src/resources/ReportTest.html");
		extentTest = reports.startTest("Report User Admin");
	}

	@AfterStep
	public void getResultScreenshot(Scenario scenario) throws Exception {
//		System.out.println(scenario.isFailed());
		System.out.println(scenario.getName());

		if (scenario.isFailed()) {
			extentTest.log(LogStatus.FAIL, screenShot(), scenario.getName());
		} else {
			extentTest.log(LogStatus.PASS, screenShot(), scenario.getName());
		}

	}

	@After
	public void endTestStep() {
		reports.endTest(extentTest);
		reports.flush();
		driver.close();
	}

	@Given("User mengakses url")
	public void user_mengakses_url() {
		System.setProperty("webdriver.chrome.driver", "/home/ancient/Downloads/chromedriver_linux64/chromedriver");
		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
	}

	@When("User berada di dalam halaman login")
	public void user_berada_di_dalam_halaman_login() {
		String home = driver.getTitle();
		System.out.println(home);
		assertEquals(home, "Login Form | Dika");
	}

	@When("User memasukan username {string}")
	public void user_memasukan_username(String string) {
		WebElement field_username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		field_username.sendKeys(string);
	}

	@When("User menekan tombol Login")
	public void user_menekan_tombol_Login() {
		driver.findElement(By.xpath("//div[@class='login-buttons']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("User mendapatkan kata informasi pada bagian username")
	public void user_mendapatkan_kata_informasi_pada_bagian_username() {
		String pesanUsername = driver.findElement(By.xpath("//input[@placeholder='Username']"))
				.getAttribute("validationMessage");
		System.out.println(pesanUsername);
		Assert.assertEquals(pesanUsername, "Please fill out this field.");
		extentTest.log(LogStatus.PASS, "Masuk dengan tidak memasukan username");
		

	}

	@When("User memasukan password {string}")
	public void user_memasukan_password(String string) {
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(string);
	}

	@Then("User mendapatkan kata informasi pada bagian password")
	public void user_mendapatkan_kata_informasi_pada_bagian_password() {
		String pesanPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"))
				.getAttribute("validationMessage");
		System.out.println(pesanPassword);
		Assert.assertEquals(pesanPassword, "Please fill out this field.");
		extentTest.log(LogStatus.PASS, "Masuk dengan tidak memasukan password");
	

	}

	@Then("User mendapatkan kata informasi gagal login")
	public void user_mendapatkan_kata_informasi_gagal_login() {
		String pesanGagal = (String) driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissable']")).getText();
		System.out.println(pesanGagal);
		extentTest.log(LogStatus.PASS, "Masuk dengan username salah dan password benar");
		
	}

	@Then("User berhasil login dan berada dalam halaman home")
	public void user_berhasil_login_dan_berada_dalam_halaman_home() {
		String text = driver.getTitle();
		System.out.println(text);
		assertEquals(text, "DIKA | SILOAM | Home");
		extentTest.log(LogStatus.PASS, "Masuk dengan username benar dan password salah");
		
	}

//	View Export
	@Given("user berada di halaman login")
	public void user_berada_di_halaman_login() {
		System.setProperty("webdriver.chrome.driver", "/home/ancient/Downloads/chromedriver_linux64/chromedriver");
		this.driver = new ChromeDriver();
		driver.navigate().to(this.baseURL);
	}

	@When("user input valid username dan password")
	public void user_input_valid_username_dan_password() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admindika");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("d1k4@passw0rd");

	}

	@And("click login")
	public void click_login() {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).submit();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//
	@Then("user berada di dashboard admin")
	public void user_berada_di_dashboard_admin() {
		String Expect = "DIKA | SILOAM | Home";
		String ActualTitle = driver.getTitle();
		AssertJUnit.assertEquals(ActualTitle, Expect);
		
	}

	@When("user klik menu View & Export")
	public void user_klik_menu_View_Export() {
		WebElement menu_view_export = driver
				.findElement(By.xpath("//a[@href='https://dev.ptdika.com/siloam/bd/export_data']"));
		menu_view_export.click();

	}

//
	@Then("user berada di halaman View & Export")
	public void user_berada_di_halaman_View_Export() {
		WebElement info = driver.findElement(By.xpath("//h1[normalize-space()='View & Export']"));
		AssertJUnit.assertEquals(info.getText(), "View & Export");

		
	}

	@When("user klik button export")
	public void user_klik_button_export() {
		WebElement btn_export = driver.findElement(By.xpath("//button[normalize-space()='Export']"));
		btn_export.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Then("user mendapatkan notif error export")
	public void user_mendapatkan_notif_error_export() {
		WebElement export_info = driver.findElement(By.xpath("//div[@role='alert']"));
		AssertJUnit.assertEquals(export_info.getText(),
				"Danger! Mohon isi start_date dan end_date terlebih dahulu!!!\n" + "×");
		
	}

	@When("user klik button download")
	public void user_klik_button_download() {
		WebElement btn_download = driver.findElement(By.xpath("//button[normalize-space()='Download']"));
		btn_download.click();
	}

	@Then("user mendapatkan notif error download")
	public void user_mendapatkan_notif_error_download() {
		WebElement download_info = driver.findElement(By.xpath("//div[@role='alert']"));
		AssertJUnit.assertEquals(download_info.getText(),
				"Danger! Mohon isi start_date dan end_date terlebih dahulu!!!\n" + "×");
		
	}

	@When("user isi start date dan end date")
	public void user_isi_start_date_dan_end_date() {
		WebElement start_date = driver.findElement(By.id("datepicker"));
		start_date.sendKeys("2022-08-01");
		WebElement end_date = driver.findElement(By.id("datepicker2"));
		end_date.sendKeys("2022-08-04");

	}

	@When("klik filter")
	public void klik_filter() {
		WebElement btn_fillter = driver.findElement(By.xpath("//button[normalize-space()='Filter']"));
		btn_fillter.click();
	}

	@Then("user melihat data ditemukan")
	public void user_melihat_data_ditemukan() {
		WebElement Data = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[1]"));
		AssertJUnit.assertEquals(Data.getText(), "View");
		

	}

	@When("user isi start date dan end date invalid")
	public void user_isi_start_date_dan_end_date_invalid() {
		WebElement start_date = driver.findElement(By.id("datepicker"));
		start_date.sendKeys("2022-08-20");
		WebElement end_date = driver.findElement(By.id("datepicker2"));
		end_date.sendKeys("2022-08-30");
	}

	@Then("user melihat data tidak ditemukan")
	public void user_melihat_data_tidak_ditemukan() {
		WebElement info = driver.findElement(By.xpath("//h1[normalize-space()='View & Export']"));
		AssertJUnit.assertEquals(info.getText(), "View & Export");
		
	}

	@When("klik View pada Data")
	public void klik_View_pada_Data() {
		WebElement Data = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/a[1]"));
		Data.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Then("user melihat detail data")
	public void user_melihat_detail_data() {

		WebElement Detail_data = driver.findElement(By.xpath("//li[@class='breadcrumb-item active']"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		AssertJUnit.assertEquals(Detail_data.getText(), "View & Export Data");
		
	}

	@When("klik export")
	public void klik_export() {
		WebElement btn_export = driver.findElement(By.xpath("//button[normalize-space()='Export']"));
		btn_export.click();
	}

	@Then("data berhasil di export")
	public void data_berhasil_di_export() {
		Path path = Paths.get("/home/ancient/Downloads/data_export (7).xls");
		assertTrue(java.nio.file.Files.exists(path));
		
	}

	@Then("user mendapat notif")
	public void user_mendapat_notif() {
		WebElement info = driver.findElement(By.xpath("//div[@role='alert']"));
		AssertJUnit.assertEquals(info.getText(), "Danger! Data Tidak Ada!!!\n" + "×");
		
	}

	@When("klik download")
	public void klik_download() {
		WebElement btn_download = driver.findElement(By.xpath("//button[normalize-space()='Download']"));
		btn_download.click();
	}

	@Then("data berhasil didownload")
	public void data_berhasil_didownload() {
		Path path = Paths.get("/home/ancient/Downloads/20220811 (1).zip.crdownload");
		assertTrue(java.nio.file.Files.exists(path));
		
	}

	@When("klik donwload")
	public void klik_donwload() {
		WebElement btn_download = driver.findElement(By.xpath("//button[normalize-space()='Download']"));
		btn_download.click();
	}

	@Then("user mendapat notif Danger! Data Tidak Ada")
	public void user_mendapat_notif_Danger_Data_Tidak_Ada() {
		WebElement info = driver.findElement(By.xpath("//div[@role='alert']"));
		AssertJUnit.assertEquals(info.getText(), "Danger! Data Tidak Ada!!!\n" + "×");
		
	}

	@Then("user No terisi")
	public void user_No_terisi() {
		WebElement no = driver.findElement(By.xpath("//td[normalize-space()='1']"));
		AssertJUnit.assertEquals(no.getText(), "1");
		
	}

	@Then("user melihat Action \\(View)")
	public void user_melihat_Action_View() {
		WebElement action = driver.findElement(
				By.xpath("//body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
		AssertJUnit.assertEquals(action.getText(), "View");
		

	}

	@Then("user melihat Tanggal Submit")
	public void user_melihat_Tanggal_Submit() {
		WebElement tgl_submit = driver.findElement(By.xpath("// td[normalize-space()='2022-08-01 12:37:48']"));
		AssertJUnit.assertEquals(tgl_submit.getText(), "2022-08-01 12:37:48");
		

	}

	@Then("user melihat Nama")
	public void user_melihat_Nama() {
		WebElement nama = driver.findElement(By.xpath("//td[normalize-space()='ELVA YUNDRA RINDYANA']"));
		AssertJUnit.assertEquals(nama.getText(), "ELVA YUNDRA RINDYANA");
		
	}

	@Then("user melihat Nomor BPJS")
	public void user_melihat_Nomor_BPJS() {
		WebElement no_bpjs = driver.findElement(By.xpath("//td[normalize-space()='1234567890123']"));
		AssertJUnit.assertEquals(no_bpjs.getText(), "1234567890123");
		
	}

	@Then("user melihat Nomor KTP")
	public void user_melihat_Nomor_KTP() {
		WebElement no_ktp = driver.findElement(By.xpath("//td[normalize-space()='0987654345678987']"));
		AssertJUnit.assertEquals(no_ktp.getText(), "0987654345678987");
		
	}

	@Then("user melihat foto Faskes Awal")
	public void user_melihat_foto_Faskes_Awal() {
		WebElement faskes_awal = driver.findElement(
				By.xpath("//body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]"));
		AssertJUnit.assertEquals(faskes_awal.getText(), "Foto Faskes Awal");
		
	}

	@Then("user melihat foto faskes tujuan")
	public void user_melihat_foto_faskes_tujuan() {
		WebElement faskes_tujuan = driver.findElement(
				By.xpath("//body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/a[1]"));
		AssertJUnit.assertEquals(faskes_tujuan.getText(), "Foto Faskes Tujuan");
		
	}

	@Then("user melihat Aggrement")
	public void user_melihat_Aggrement() {
		WebElement no = driver.findElement(
				By.xpath("//body[1]/div[5]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[9]/a[1]"));
		AssertJUnit.assertEquals(no.getText(), "PDF Agreement");
		
	}

	@When("klik refresh")
	public void klik_refresh() {
		WebElement button_refresh = driver.findElement(By.xpath("//a[@title='Refresh']"));
		button_refresh.click();
	}

	@Then("user melihat data terrefresh")
	public void user_melihat_data_terrefresh() {

		WebElement Detail_data = driver.findElement(By.xpath("//li[@class='breadcrumb-item active']"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		AssertJUnit.assertEquals(Detail_data.getText(), "View & Export Data");
		
	}

	public String screenShot() {
		String hasil = null;
		try {
			File dirFile = UserAdmin.ambilGambar(driver, direktoriFile);
			hasil = "<a target='_blank' href='" + dirFile.getAbsolutePath() + "'>" + "<img src='"
					+ dirFile.getAbsolutePath() + "'width = 100 height = 100 /></a>";
		} catch (IOException e) {
			System.out.println("error");
		}

		return hasil;

	}

	public static File ambilGambar(WebDriver webdriver, String filepath) throws IOException {
		TakesScreenshot ss = ((TakesScreenshot) webdriver);
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		File dirFile = new File(filepath);
		FileUtils.copyFile(srcFile, dirFile);

		return dirFile;
	}

}
