package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoconts {
	public WebDriver driver;
	
	static {
		System.setProperty("CHROME_KEY","CHROME_VALUE");
		System.setProperty("GECKO_key","GECKO_VALUE");
	}
	
	@BeforeMethod
	public void openApplication() {
		driver=new ChromeDriver();
		AutoUtil.getProperty(CONFIG_PATH,"appURL");
		driver.get("appURL");
		String sITO=AutoUtil.getProperty(CONFIG_PATH,"ITO");
		Long ITO1=Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(ITO1, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void closeApplication(ITestResult iTestResult) {
		String testName=iTestResult.getName();
		if(iTestResult.getStatus()==2) {
			AutoUtil.getPhoto(driver, PHOTO_PATH, testName);
		}
		driver.quit();	
	}

}
