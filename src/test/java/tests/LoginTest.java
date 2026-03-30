package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.WaitUtils;
import pages.InventoryPage;
import pages.CartPage;
public class LoginTest extends BaseTest {
	
	@DataProvider(name = "loginData")
	public Object[][] getLogindata() throws Exception
	{
		return ExcelUtils.getData("src/test/resources/testdata/TestData.xlsx", "Sheet1");
	}
	
	@Test(groups = "smoke")
	public void validLoginTest()
	{
		LoginPage lp = new LoginPage(driver);
        lp.login(prop.getProperty("username"), prop.getProperty("password"));

        InventoryPage ip = new InventoryPage(driver);

        Assert.assertEquals(ip.getPageTitle(), "Product");
	}
	@Test(groups = "regression")
	public void invalidLoginTest() {

	    LoginPage lp = new LoginPage(driver);
	    lp.login("invalid_user", "wrong_pass");

	    String error = lp.getErrorMessage();

	    Assert.assertTrue(error.contains("Username and password do not match"));
	}
	
	@Test(groups = "smoke")
	public void addToCartTest() {

	    LoginPage lp = new LoginPage(driver);
	    lp.login(prop.getProperty("username"), prop.getProperty("password"));

	    InventoryPage ip = new InventoryPage(driver);
	    ip.addItemToCart();
	    ip.goToCart();
	    
	    WaitUtils wait = new WaitUtils(driver);
	    wait.waitForUrlContains("cart");

	    Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
	}
	
	@Test(groups = "regression")
	public void verifyProductInCartTest() {

	    LoginPage lp = new LoginPage(driver);
	    lp.login(prop.getProperty("username"), prop.getProperty("password"));

	    InventoryPage ip = new InventoryPage(driver);
	    ip.addItemToCart();
	    ip.goToCart();

	    CartPage cp = new CartPage(driver);

	    String product = cp.getProductName();

	    Assert.assertEquals(product, "Sauce Labs Backpack");
	    
	}
	
	@Test(dataProvider = "loginData", groups = "regression")
	public void multipleLoginTest(String user, String pass) {

	    LoginPage lp = new LoginPage(driver);
	    lp.login(user, pass);

	    
	}

}
