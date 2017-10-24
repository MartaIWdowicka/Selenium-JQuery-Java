import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExtensions extends PageJSExtensions {
    private static WebDriverWait pageLoad;
    private static WebDriverWait waiter;

    private static ExpectedCondition<Boolean> expectation = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return javascriptExecutor(driver, "return document.readyState").toString().equals("complete");
                }
            };

    public static void waitPageLoad(WebDriver driver) {
        pageLoad = new WebDriverWait(driver, 20);
        pageLoad.until(expectation);
    }

    public static void waitElementReady(WebDriver driver, final String selector, int timeout) {
        waiter = new WebDriverWait(driver, timeout);
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return getWebElement(driver, selector).isEnabled();
                    }
                };
        waiter.until(expectation);
    }
}
