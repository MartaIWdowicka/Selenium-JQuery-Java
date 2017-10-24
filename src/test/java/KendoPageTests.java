import org.junit.*;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class KendoPageTests extends TestBaseClass {

    @Before
    public void setUp() throws Exception {
        SetUp();
    }

    @Test
    public void keyboardOptionsDeleteCopyPaste() throws Exception {
        KendoPage.getKendoExampleWebPage(driver);
        KendoPageTestParts.linesCountmatch(driver, "6");
        KendoPageTestParts.blocksCountMatch(driver, "7");
        KendoPageTestParts.copyPasteElementWorks(driver, KendoPage.getBlockLocator("Moreno"), KendoPage.getSelector("NamePlatesCount"));
        KendoPageTestParts.deleteElementWorks(driver, KendoPage.getBlockLocator("Moreno"), KendoPage.getSelector("NamePlatesCount"));
        KendoPageTestParts.copyPasteElementWorks(driver, KendoPage.getSelector("DiagramLine"), KendoPage.getSelector("DiagramLinesCount"));
        KendoPageTestParts.deleteElementWorks(driver, KendoPage.getSelector("DiagramLine"), KendoPage.getSelector("DiagramLinesCount"));
    }

    @Test
    public void mouseOptionsDragingAndResisingBlocks() throws Exception {
        KendoPage.getKendoExampleWebPage(driver);
        KendoPageTestParts.dragAndDrop(driver, KendoPage.getBlockLocator("Moreno"), KendoPage.getBlockLocator("Toni"));
        KendoPageTestParts.resize(driver, KendoPage.getBlockLocator("Moreno"));
        KendoPageTestParts.linesCountmatch(driver, "6");
        KendoPageTestParts.blocksCountMatch(driver, "7");
    }

    @After
    public void tearDown() throws Exception {
        TearDown();
    }
}
