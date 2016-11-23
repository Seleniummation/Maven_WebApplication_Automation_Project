package amazon.driverman;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class aDriver {

    protected static WebDriver driver;

    public static void baseURL() throws IOException {

        Properties p = new Properties();
        FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "//" + "src//main//resources//global.properties");
        p.load(fi);
        p.getProperty("browser");

        if (p.getProperty("browser").contains("firefox")) {

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\" + "src\\main\\resources\\Tools\\geckodriver.exe");


            driver = new FirefoxDriver();

        } else if (p.getProperty("browser").contains("chrome"))

        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\" + "src\\main\\resources\\Tools\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);

        } else

        {
            //System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\" + "src\\main\\resources\\Tools\\IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\" + "src\\main\\resources\\Tools\\32bit\\IEDriverServer.exe");

            driver = new InternetExplorerDriver();
        }

        driver.get(p.getProperty("url1"));
        //driver.get(p.getProperty("url2"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


    }






    public static void closeBrowser() {
        driver.quit();


    }
}
