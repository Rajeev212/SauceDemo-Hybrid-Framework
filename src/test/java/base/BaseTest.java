package base;

import java.io.FileInputStream;

import java.util.Properties;
import org.testng.annotations.*;

import utils.DriverFactory;

import org.openqa.selenium.WebDriver;

public class BaseTest {
	
	
	public static WebDriver driver;
	protected Properties prop;
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser) throws Exception {

	    prop = new Properties();
	    FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
	    prop.load(fis);

	    driver = DriverFactory.initDriver(browser);
	    driver.get(prop.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
				
		
	}
	


