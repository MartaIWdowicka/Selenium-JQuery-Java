package Tests;

import Extensions.TestBaseClass;
import PageObjects.KendoDemoPage;
import TestParts.KendoPageTestParts;
import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class KendoDemoPageTests extends TestBaseClass {

    @Before
    public void setUp() throws Exception {
        SetUp();
    }

    @Test
    public void keyboardOptionsDeleteCopyPaste() throws Exception {
        KendoDemoPage.getKendoExampleWebPage(driver);
        KendoPageTestParts.linesCountmatch(driver, "6");
        KendoPageTestParts.blocksCountMatch(driver, "7");
        KendoPageTestParts.copyPasteElementWorks(driver, KendoDemoPage.getBlockLocator("Moreno"), KendoDemoPage.getSelector("NamePlatesCount"));
        KendoPageTestParts.deleteElementWorks(driver, KendoDemoPage.getBlockLocator("Moreno"), KendoDemoPage.getSelector("NamePlatesCount"));
        KendoPageTestParts.copyPasteElementWorks(driver, KendoDemoPage.getSelector("DiagramLine"), KendoDemoPage.getSelector("DiagramLinesCount"));
        KendoPageTestParts.deleteElementWorks(driver, KendoDemoPage.getSelector("DiagramLine"), KendoDemoPage.getSelector("DiagramLinesCount"));
    }

    @Test
    public void mouseOptionsDragingAndResisingBlocks() throws Exception {
        KendoDemoPage.getKendoExampleWebPage(driver);
        KendoPageTestParts.dragAndDrop(driver, KendoDemoPage.getBlockLocator("Moreno"), KendoDemoPage.getBlockLocator("Toni"));
        KendoPageTestParts.resize(driver, KendoDemoPage.getBlockLocator("Moreno"));
        KendoPageTestParts.linesCountmatch(driver, "6");
        KendoPageTestParts.blocksCountMatch(driver, "7");
    }

    @After
    public void tearDown() throws Exception {
        TearDown();
    }
}
