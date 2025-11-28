package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

public class CucumberHooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        System.out.println("Setting up WebDriver and navigating to URL");
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       System.out.println("Navigating to URL: " + ConfigReader.getProperty("url"));
       driver.get(ConfigReader.getProperty("url"));
    }

    @After
    public void teardown() {
        System.out.println("Tearing down WebDriver");
        if (driver != null) {
            driver.quit();
        }
    }
}
