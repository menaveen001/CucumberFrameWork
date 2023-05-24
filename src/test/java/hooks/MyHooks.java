package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;

	@Before
	public void setUp() {
		Properties pro = ConfigReader.initializeProperties();
		
		driver = DriverFactory.initializeBrowser(pro.getProperty("browser"));

		driver.get(pro.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario) {
	String scenarioNmae = scenario.getName().replaceAll(" ", "_");
	if(scenario.isFailed()) {
	byte[] srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	scenario.attach(srcScreenshot, "image/png", scenarioNmae);
		
	}
		driver.quit();
	}
}
