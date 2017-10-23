import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

public class KendoPage extends PageJSExtensions {

    private static Actions builder;
    private static Map<String, String> KendoSelectors = ImmutableMap.of(
            "NamePlate", "return $('svg').find(\"text:contains('%s')\").parent()",
            "NamePlatesCount", "return $('svg>g>g>g>g').filter(':has(text)').size()",
            "DiagramLinesCount", "return $('svg>g>g>g>g').not(':has(text)').size()",
            "DiagramLines", "return $('svg>g>g>g>g').not(':has(text)')",
            "ResizeButton", "return $('svg>g>g:nth-of-type(2)>g:nth-of-type(1)>path:nth-of-type(9)')"
    );

    public static void getKendoExampleWebPage(WebDriver driver) {
        driver.get("http://demos.telerik.com/kendo-ui/diagram/index");
        WaitExtensions.waitPageLoad(driver);
    }

    public static String getSelector(String key, String... args) {
        System.out.println(String.format(KendoSelectors.get(key), args));
        return String.format(KendoSelectors.get(key), args);
    }

    public static String get(String key) {
        return KendoSelectors.get(key);
    }


    public static void dragAndDrop(WebDriver driver, WebElement me, WebElement you) {
        builder = new Actions(driver);
        builder.click(me)
                .dragAndDrop(me, you)
                .release()
                .build()
                .perform();
    }

    public static void deleteElement(WebDriver driver, WebElement me) {
        builder = new Actions(driver);
        builder.click(me)
                .sendKeys(Keys.DELETE)
                .build()
                .perform();
    }

    public static void sendCopyPaste(WebDriver driver, WebElement me) {
        builder = new Actions(driver);
        builder.click(me)
                .sendKeys(Keys.CONTROL, Keys.chord("C"))
                .sendKeys(Keys.CONTROL, Keys.chord("V"))
                .build()
                .perform();
    }
}
