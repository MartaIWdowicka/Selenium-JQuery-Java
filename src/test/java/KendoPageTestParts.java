import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class KendoPageTestParts {

    public static void dragAndDrop(WebDriver driver, String draggableSelector, String targetSelector) {
        WebElement dragable = PageJSExtensions.getWebElement(driver, draggableSelector);
        WebElement target = PageJSExtensions.getWebElement(driver, targetSelector);
        Point previousLocation = dragable.getLocation();
        KendoPage.dragAndDrop(driver, dragable, target);
        assertNotEquals(previousLocation, dragable.getLocation());
    }

    public static void resize(WebDriver driver, String resizableSelector) {
        WebElement resizable = PageJSExtensions.getWebElement(driver, resizableSelector);
        Dimension oldSize = resizable.getSize();
        assertNotEquals(oldSize, KendoPage.resize(driver, resizable));
    }

    public static void blocksCountMatch(WebDriver driver, String expected) {
        assertEquals(expected, PageJSExtensions.javascriptExecutor(driver, KendoPage.get("NamePlatesCount")));
    }

    public static void linesCountmatch(WebDriver driver, String expected) {
        assertEquals(expected, PageJSExtensions.javascriptExecutor(driver, KendoPage.get("DiagramLinesCount")));
    }

    public static void copyPasteElementWorks(WebDriver driver, String selectorElementToCopy, String selectorCountElements) {
        WebElement copyMe = PageJSExtensions.getWebElement(driver, selectorElementToCopy);
        int expected = Integer.parseInt(PageJSExtensions.javascriptExecutor(driver, selectorCountElements)) ;
        KendoPage.sendCopyPaste(driver, copyMe);
        assertEquals(expected+1, Integer.parseInt(PageJSExtensions.javascriptExecutor(driver, selectorCountElements)));
    }

    public static void deleteElementWorks(WebDriver driver, String selectorElementToCopy, String selectorCountElements) {
        WebElement deleteMe = PageJSExtensions.getWebElement(driver, selectorElementToCopy);
        int expected = Integer.parseInt(PageJSExtensions.javascriptExecutor(driver, selectorCountElements));
        KendoPage.deleteElement(driver, deleteMe);
        assertEquals(expected-1, Integer.parseInt(PageJSExtensions.javascriptExecutor(driver, selectorCountElements)));
    }
}

