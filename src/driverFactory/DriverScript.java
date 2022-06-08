package driverFactory;

import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunction.FunctionLibrary;
import constant.AppUtil;
import utilities.ExcelFileUtil;

public class DriverScript extends AppUtil{
	String inputpath = "D:\\Testing Tools\\automation testing\\Hybrid_FrameWork\\TestInput\\HybridTest.xlsx";
	String outputpath = "D:\\Testing Tools\\automation testing\\Hybrid_FrameWork\\TestOutput\\HybridResults1.xlsx";
	String TCSheet = "MasterTestCases";
	String TSSheet = "TestSteps";
	@Test
	public void StartTest()throws Throwable
	{
		boolean res=false;
		String tcres="";
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//count no of rows in TCSheet and TSSheet
		int TCCount =xl.rowCount(TCSheet);
		int TSCount =xl.rowCount(TSSheet);
		Reporter.log(TCCount+"    "+TSCount,true);
		for(int i=1;i<=TCCount;i++)
		{
			String executionstatus =xl.getcelldata(TCSheet, i, 2);
			if(executionstatus.equalsIgnoreCase("Y"))
			{
				//read tcid  cccel
				String tcid =xl.getcelldata(TCSheet, i, 0);
				for(int j=1;j<=TSCount;j++)
				{
					//read tsid cell
				String tsid =xl.getcelldata(TSSheet, j, 0);
				if(tcid.equalsIgnoreCase(tsid))
				{
					//read keyword cell
					String keyword =xl.getcelldata(TSSheet, j, 4);
					if(keyword.equalsIgnoreCase("AdminLogin"))
					{
						String para1 =xl.getcelldata(TSSheet, j, 5);
						String para2 =xl.getcelldata(TSSheet, j, 6);
						res =FunctionLibrary.verifyLogin(para1, para2);
					}
					else if(keyword.equalsIgnoreCase("NewBranch"))
					{
						String para1 =xl.getcelldata(TSSheet, j, 5);
						String para2 =xl.getcelldata(TSSheet, j, 6);
						String para3 =xl.getcelldata(TSSheet, j, 7);
						String para4 =xl.getcelldata(TSSheet, j, 8);
						String para5 =xl.getcelldata(TSSheet, j, 9);
						String para6 =xl.getcelldata(TSSheet, j, 10);
						String para7 =xl.getcelldata(TSSheet, j, 11);
						String para8 =xl.getcelldata(TSSheet, j, 12);
						String para9 =xl.getcelldata(TSSheet, j, 13);
						FunctionLibrary.clickBranches();
						res = FunctionLibrary.verifyBranchCreation(para1, para2, para3, para4, para5, para6, para7, para8, para9);
					}
					else if(keyword.equalsIgnoreCase("BranchUpdate"))
					{
						String para1 =xl.getcelldata(TSSheet, j, 5);
						String para2 =xl.getcelldata(TSSheet, j, 6);
						String para6 =xl.getcelldata(TSSheet, j, 10);
						FunctionLibrary.clickBranches();
						res =FunctionLibrary.verifyBranchUpdate(para1, para2, para6);
					}
					else if(keyword.equalsIgnoreCase("NewRole"))
					{
						String para1 =xl.getcelldata(TSSheet, j, 5);
						String para2 =xl.getcelldata(TSSheet, j, 6);
						String para3 =xl.getcelldata(TSSheet, j, 7);
						FunctionLibrary.clickRoles();
						res = FunctionLibrary.verifyRolesCreation(para1, para2, para3);
					}
					else if(keyword.equalsIgnoreCase("RolesUpdate"))
					{
						String para1 =xl.getcelldata(TSSheet, j, 5);
						String para2 =xl.getcelldata(TSSheet, j, 6);
						String para3 =xl.getcelldata(TSSheet, j, 7);
						FunctionLibrary.clickRoles();
						res =FunctionLibrary.verifyRoleUpdate(para1, para2, para3);
					}
					else if(keyword.equalsIgnoreCase("AdminLogout"))
					{
						res= FunctionLibrary.verifyLogout();
					}
					String tsres="";
					if(res)
					{
						tsres="Pass";
						xl.setCellData(TSSheet, j, 3, tsres, outputpath);
					}
					else
					{
						tsres="Fail";
						xl.setCellData(TSSheet, j, 3, tsres, outputpath);
					}
					tcres=tsres;			
				}
					
				}
				//write as tcres in mastertestcases sheet
				xl.setCellData(TCSheet, i, 3, tcres, outputpath);
			}
			else
			{
				//write as blocked which tc is flag n
				xl.setCellData(TCSheet, i, 3, "Blocked", outputpath);
			}
		}
	}

	}





















