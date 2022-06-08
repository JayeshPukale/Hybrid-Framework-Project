package commonFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import constant.AppUtil;

public class FunctionLibrary extends AppUtil{
	//method for login
		public static boolean verifyLogin(String username,String password)
		{
			driver.findElement(By.xpath(config.getProperty("ObjUser"))).sendKeys(username);
			driver.findElement(By.xpath(config.getProperty("ObjPass"))).sendKeys(password);
			driver.findElement(By.xpath(config.getProperty("ObjLoginBtn"))).click();
			String expected ="adminflow";
			String actual =driver.getCurrentUrl();
			if(actual.toLowerCase().contains(expected.toLowerCase()))
			{
				Reporter.log("Login success::"+expected+"     "+actual,true);
				return true;
			}
			else
			{
				Reporter.log("Login Fail::"+expected+"     "+actual,true);
				return false;
			}
		}
		//method for click branches
		public static void clickBranches()throws Throwable
		{
			driver.findElement(By.xpath(config.getProperty("ObjClickBranches"))).click();
			Thread.sleep(3000);
		}
		//method for branch creation
		public static boolean verifyBranchCreation(String branchName,String Address1,String Address2,String Address3,String Area,
				String zipcode,String country,String state,String city)throws Throwable
		{
			driver.findElement(By.xpath(config.getProperty("ObjNewBranch"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(config.getProperty("ObjBranchName"))).sendKeys(branchName);
			driver.findElement(By.xpath(config.getProperty("ObjAddress1"))).sendKeys(Address1);
			driver.findElement(By.xpath(config.getProperty("ObjAddress2"))).sendKeys(Address2);
			driver.findElement(By.xpath(config.getProperty("ObjAddress3"))).sendKeys(Address3);
			driver.findElement(By.xpath(config.getProperty("ObjArea"))).sendKeys(Area);
			driver.findElement(By.xpath(config.getProperty("Objzip"))).sendKeys(zipcode);
			new Select(driver.findElement(By.xpath(config.getProperty("ObjCountry")))).selectByVisibleText(country);
			Thread.sleep(2000);
			new Select(driver.findElement(By.xpath(config.getProperty("Objstate")))).selectByVisibleText(state);
			Thread.sleep(2000);
			new Select(driver.findElement(By.xpath(config.getProperty("Objcity")))).selectByVisibleText(city);
			Thread.sleep(2000);
			driver.findElement(By.xpath(config.getProperty("Objsubmitbtn"))).click();
			Thread.sleep(4000);
			//capture alert message
			String expectedbranchAlert =driver.switchTo().alert().getText();
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			String actualbranchalert ="new Branch with";
			if(expectedbranchAlert.toLowerCase().contains(actualbranchalert.toLowerCase()))
			{
			Reporter.log(expectedbranchAlert,true);
			return true;
			}
			else
			{
				Reporter.log("Branch Creation Fail",true);
				return false;
			}
			
		}
		//method for branch updation
		public static boolean verifyBranchUpdate(String branch,String address,String zip)throws Throwable
		{
			driver.findElement(By.xpath(config.getProperty("ObjEdit"))).click();
			Thread.sleep(3000);
			WebElement ObjBranchName =driver.findElement(By.xpath(config.getProperty("ObjBranch")));
			ObjBranchName.clear();
			ObjBranchName.sendKeys(branch);
			Thread.sleep(3000);
			WebElement ObjAddress =driver.findElement(By.xpath(config.getProperty("ObjAddress")));
			ObjAddress.clear();
			ObjAddress.sendKeys(address);
			Thread.sleep(3000);
			WebElement Objzipcode=driver.findElement(By.xpath(config.getProperty("Objzipcode")));
			Objzipcode.clear();
			Objzipcode.sendKeys(zip);
			Thread.sleep(3000);
			driver.findElement(By.xpath(config.getProperty("ObjupdateBtn"))).click();
			String expectedupdateAlert =driver.switchTo().alert().getText();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			String actualupdateAlert ="Branch updated";
			if(expectedupdateAlert.toLowerCase().contains(actualupdateAlert.toLowerCase()))
			{
				Reporter.log(expectedupdateAlert,true);
				return true;
			}
			else
			{
				Reporter.log("Branch Updation Fail",true);
				return false;
			}
			
		}
		//method for click roles
		public static void clickRoles()throws Throwable
		{
			driver.findElement(By.xpath(config.getProperty("ObjClickRoles"))).click();
			Thread.sleep(3000);
		}
		//method for role creation
		public static boolean verifyRolesCreation(String rolename, String roledesc, String roletype) throws Throwable
		{
			driver.findElement(By.xpath(config.getProperty("ObjNewRole"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(config.getProperty("ObjRoleName"))).sendKeys(rolename);
			driver.findElement(By.xpath(config.getProperty("ObjRoleDesc"))).sendKeys(roledesc);
			new Select(driver.findElement(By.xpath(config.getProperty("ObjRoleType")))).selectByVisibleText(roletype);
			Thread.sleep(2000);
			driver.findElement(By.xpath(config.getProperty("ObjSubmitBtn"))).click();
			Thread.sleep(4000);
			//capture alert message
			String expectedroleAlert =driver.switchTo().alert().getText();
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			String actualrolealert ="New Role with";
			if(expectedroleAlert.toLowerCase().contains(actualrolealert.toLowerCase()))
			{
			Reporter.log(expectedroleAlert,true);
			return true;
			}
			else
			{
				Reporter.log("Role Creation Fail",true);
				return false;
			}
		}
		//method for Roles updation
		public static boolean verifyRoleUpdate(String RName,String RDesc,String RType)throws Throwable
		{
			driver.findElement(By.xpath(config.getProperty("Objedit"))).click();
			Thread.sleep(3000);
			WebElement ObjRoleName =driver.findElement(By.xpath(config.getProperty("ObjRName")));
			ObjRoleName.clear();
			ObjRoleName.sendKeys(RName);
			Thread.sleep(3000);
			WebElement ObjRoleDesc =driver.findElement(By.xpath(config.getProperty("ObjRDesc")));
			ObjRoleDesc.clear();
			ObjRoleDesc.sendKeys(RDesc);
			Thread.sleep(3000);
			WebElement ObjRoleType = driver.findElement(By.xpath(config.getProperty("ObjRtype")));
			ObjRoleType.sendKeys(RType);
			Thread.sleep(3000);
			driver.findElement(By.xpath(config.getProperty("ObjUpdatebtn"))).click();
			String expectedroleupdateAlert =driver.switchTo().alert().getText();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			String actualroleupdateAlert ="Role updated";
			if(expectedroleupdateAlert.toLowerCase().contains(actualroleupdateAlert.toLowerCase()))
			{
				Reporter.log(expectedroleupdateAlert,true);
				return true;
			}
			else
			{
				Reporter.log("Roles Updation Fail",true);
				return false;
			}
			
		}
		public static boolean verifyLogout()throws Throwable
		{
			driver.findElement(By.xpath(config.getProperty("ObjLogout"))).click();
			Thread.sleep(3000);
			if(driver.findElement(By.xpath(config.getProperty("ObjLoginBtn"))).isDisplayed())
			{
				Reporter.log("Logout Success",true);
				return true;
			}
			else
			{
				Reporter.log("Logout Fail",true);
				return false;
			}
		}
	}













