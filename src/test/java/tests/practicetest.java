package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtils;

public class practicetest extends ExcelUtils{

	
	@DataProvider(name="logindata")
	public Object[][] getData() throws Exception
	{
		return ExcelUtils.getData("testdata.xlsx", "Sheet1");
	}
	
	@Test(dataProvider = "logindata")
	public void login(String user,String pass)
	{
		System.out.println("Login with user: "+user+" & pass:"+pass);
	}
}
