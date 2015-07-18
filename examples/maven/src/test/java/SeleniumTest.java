import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 */
public class SeleniumTest {
    static WebDriver driver;

    @BeforeClass
    public static void prepareToTest() {
        driver = new FirefoxDriver();
    }

    @Test
    public void googleTest() throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        Thread.sleep(15000);
        System.out.println("Page title is: " + driver.getTitle());
    }
    @AfterClass
    public static void afetrTest() {
        driver.quit();
    }
}
