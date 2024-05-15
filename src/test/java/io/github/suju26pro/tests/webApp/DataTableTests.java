package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.DataTablesPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class DataTableTests extends TestSuiteSetup {

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        final MainPage mainPage = new MainPage();
        mainPage.clickLink("Sortable Data Tables");
    }

    @Test
    public void testDataTable () {
        final DataTablesPage dataTablesPage = new DataTablesPage();
        dataTablesPage.printTableRecords();
        assertEquals(dataTablesPage.getTableData().get(0).get("Last Name"), "Smith");
        assertEquals(dataTablesPage.getTableData().get(1).get("First Name"), "Frank");

    }

}