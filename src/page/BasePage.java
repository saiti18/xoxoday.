package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.AutoUtil;
import generic.IAutoconts;

public class BasePage {
	public void verifyPageIsDisplay(WebDriver driver,String eResult) {
		String sETO=AutoUtil.getProperty(IAutoconts.CONFIG_PATH,"ETO");
		Long ETO=Long.parseLong(sETO);
		WebDriverWait wait=new WebDriverWait(driver,ETO);
		try {
			wait.until(ExpectedConditions.titleIs(eResult));
			Reporter.log("PASS:Page is display",true);
		}
		catch(Exception e) {
			Reporter.log("FAIL:Page is not display",false);
			Assert.fail();
		}
	}

}
