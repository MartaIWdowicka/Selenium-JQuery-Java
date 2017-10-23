import org.junit.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class KendoFunctions extends TestBaseClass {

    @Before
    public void setUp() throws Exception {
        SetUp();
    }

    @Test
    public void keyboardOptionsDeleteCopyPaste() throws Exception {
        KendoPage.getKendoExampleWebPage(driver);
        assertEquals("6", PageJSExtensions.javascriptExecutor(driver, KendoPage.get("DiagramLinesCount")));
        assertEquals("7", PageJSExtensions.javascriptExecutor(driver, KendoPage.get("NamePlatesCount")));
        WebElement morenoBlock = PageJSExtensions.getWebElement(driver, KendoPage.getSelector("NamePlate", "Moreno"));
        KendoPage.sendCopyPaste(driver, morenoBlock);
        assertEquals("8", PageJSExtensions.javascriptExecutor(driver, KendoPage.get("NamePlatesCount")));
        KendoPage.deleteElement(driver, morenoBlock);
        assertEquals("7", PageJSExtensions.javascriptExecutor(driver, KendoPage.get("NamePlatesCount")));
        WebElement aLine = PageJSExtensions.getWebElement(driver, KendoPage.getSelector("DiagramLines", ""));
        KendoPage.sendCopyPaste(driver, aLine);
        assertEquals("7", PageJSExtensions.javascriptExecutor(driver, KendoPage.get("DiagramLinesCount")));
        KendoPage.deleteElement(driver, aLine);
        assertEquals("6", PageJSExtensions.javascriptExecutor(driver, KendoPage.get("DiagramLinesCount")));
    }

    @Test
    public void mouseOptionsDragingAndResisingBlocks() throws Exception {
        KendoPage.getKendoExampleWebPage(driver);
        WebElement moreno = PageJSExtensions.getWebElement(driver, KendoPage.getSelector("NamePlate", "Moreno"));
        WebElement toni = PageJSExtensions.getWebElement(driver, KendoPage.getSelector("NamePlate", "Toni"));
        Point previousLocation = moreno.getLocation();
        KendoPage.dragAndDrop(driver, moreno, toni);
        assertNotEquals(previousLocation, moreno.getLocation());
        WebElement resizeButton = PageJSExtensions.getWebElement(driver, KendoPage.getSelector("ResizeButton", ""));
        KendoPage.dragAndDrop(driver, resizeButton, moreno);
        assertNotEquals(moreno.getSize(), toni.getSize());
        assertEquals("6", PageJSExtensions.javascriptExecutor(driver, KendoPage.get("DiagramLinesCount")));
        assertEquals("7", PageJSExtensions.javascriptExecutor(driver, KendoPage.get("NamePlatesCount")));
    }

    @After
    public void tearDown() throws Exception {
        TearDown();
    }
}
