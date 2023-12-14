package StepDefn;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;
import webdriverfactory.DriverFactory;

import java.sql.Driver;

public class ApplnHooks {

    private WebDriver driver;
    private DriverFactory driverFactory  = new DriverFactory();

    private ConfigReader configReader = new ConfigReader();

    @Before
    public void getBrowser(){
       // driverFactory;
        driver = driverFactory.init_Driver(configReader.getConfigProp("browser"));

    }

    @After(order = 0)
    public void closeBrowser(){
        DriverFactory.getDriver().close();
        DriverFactory.getDriver().quit();
    }

    @After(order = 1)
    public void takeScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            byte[] sourcePath = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",scenario.getName().replace(" ","_"));
        }
    }
}
