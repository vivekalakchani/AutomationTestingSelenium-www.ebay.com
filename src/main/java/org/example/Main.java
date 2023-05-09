package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class Main {

    protected static WebDriver driver;

    protected static WebDriverWait wait;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser) {

        //Check if parameter passed as 'chrome'

        if (browser.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            // Create a new instance of the Chrome driver
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);



        }

        //Check if parameter passed from TestNG is 'firefox'
       else if (browser.equalsIgnoreCase("firefox")) {

            //set path to geckodriver.exe
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            // Create a new instance of the Firefox driver
            driver = new FirefoxDriver();


        }

        //Check if parameter passed from TestNG is 'Edge'
        else if(browser.equalsIgnoreCase("Edge")){
            //set path to Edge.exe
            System.setProperty("webdriver.edge.driver","src/main/resources/drivers/msedgedriver.exe");
            // Create a new instance of the Edge driver
            driver = new EdgeDriver();

        }

        else {
            // cannot detect the web browser
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();


    }

    //End the program
    @AfterTest
    public void closedBrowser() {
        //close the web browser
        driver.quit();
    }

}