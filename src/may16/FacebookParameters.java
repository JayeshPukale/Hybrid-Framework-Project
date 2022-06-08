package may16;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FacebookParameters {
WebDriver driver;
@Parameters({"Url"})
@BeforeTest
public void setUp(String Appurl)
{
	driver =  new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(Appurl);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Parameters({"fname","sname","email","renteremail","password","bday","bmonth","byear"})
@Test
public void createAccount(String firstname, String surname, String email, String reemail,
		String pass, String birthday, String birthmonth, String birthyear)throws Throwable
{
	driver.findElement(By.linkText("Create New Account")).click();
	WebDriverWait mywait = new WebDriverWait(driver, 10);
	mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
	driver.findElement(By.name("firstname")).sendKeys(firstname);
	driver.findElement(By.name("lastname")).sendKeys(surname);
	driver.findElement(By.name("reg_email__")).sendKeys(email);
	driver.findElement(By.name("reg_email_confirmation__")).sendKeys(reemail);
	driver.findElement(By.name("reg_passwd__")).sendKeys(pass);
	new Select(driver.findElement(By.name("birthday_day"))).selectByVisibleText(birthday);
	new Select(driver.findElement(By.name("birthday_month"))).selectByVisibleText(birthmonth);
	new Select(driver.findElement(By.name("birthday_year"))).selectByVisibleText(birthyear);
	driver.findElement(By.xpath("//input[@value=\"2\"]")).click();
	driver.findElement(By.xpath("//button[@name=\"websubmit\"]")).click();
	Thread.sleep(6000);
}
@AfterTest
public void tearDown()
{
	driver.close();
}
}
