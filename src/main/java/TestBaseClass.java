import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class TestBaseClass {
    public static WebDriver driver;
    public static Wait<WebDriver> wait;

    public static void SetUp(){
        //use if chromedriver.exe enviroment variable not set:
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Magnua\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(3000, MILLISECONDS)
                .pollingEvery(100, MILLISECONDS);
    }

    public static void TearDown(){
        driver.quit();
    }
}
