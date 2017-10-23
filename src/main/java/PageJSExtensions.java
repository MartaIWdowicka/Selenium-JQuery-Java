import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageJSExtensions {

    public static String javascriptExecutor(WebDriver driver, String script) {
        return ((JavascriptExecutor) driver).executeScript(script).toString();
    }

    public static WebElement getWebElement(WebDriver driver, String jQuerySelector) {
        return (WebElement) ((JavascriptExecutor) driver).executeScript(jQuerySelector + ".get(0);");
    }
}
