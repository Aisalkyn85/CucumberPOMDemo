package webdriverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    public WebDriver driver;
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public WebDriver init_Driver(String browser){
        if(browser.equalsIgnoreCase("chrome")){
         //   WebDriverManager.chromedriver().setup();
            threadLocal.set(new ChromeDriver());
        }

        else if(browser.equalsIgnoreCase("firefox")){
           // WebDriverManager.firefoxdriver().setup();
            threadLocal.set(new FirefoxDriver());
        }

        else if(browser.equalsIgnoreCase("edge")){
            //WebDriverManager.edgedriver().setup();
            threadLocal.set(new EdgeDriver());
        }

        else {
            System.out.println("Supported Browsers: Chrome, Edge and Firefox");
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getDriver().manage().window().maximize();
        return null;


    }


    public static synchronized WebDriver getDriver(){
        return threadLocal.get();
    }
}
