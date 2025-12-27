
package KodnestAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeTest(alwaysRun = true)  // Add alwaysRun = true
    public void setUpTest() {
        System.out.println(">>> BEFORE TEST - Starting driver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)  // Add alwaysRun = true
    public void tearDownTest() {
        System.out.println(">>> AFTER TEST - Quitting driver");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}