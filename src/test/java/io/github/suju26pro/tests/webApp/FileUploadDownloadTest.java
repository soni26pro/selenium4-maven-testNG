package io.github.suju26pro.tests.webApp;

import io.github.suju26pro.pages.theinternet.DownloadPage;
import io.github.suju26pro.pages.theinternet.FileUploadPage;
import io.github.suju26pro.pages.theinternet.MainPage;
import io.github.suju26pro.tests.base.TestSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.suju26pro.drivers.WebDriverFactory.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadDownloadTest extends TestSuiteSetup {

    private String fileName;
    private MainPage mainPage;

    @BeforeClass
    public void testSetup () {
        final String websiteLink = "http://the-internet.herokuapp.com/";
        getDriver().get(websiteLink);
        this.mainPage = new MainPage();
    }

    @Test
    public void testFileDownload () throws InterruptedException {
        final DownloadPage downloadPage = new DownloadPage();
        this.mainPage.clickLink("File Download");
        this.fileName = downloadPage.getDownloadLinkText();
        downloadPage.downloadFile();
        assertTrue(downloadPage.checkFileDownload(this.fileName));
        getDriver().navigate().back();
    }

    @Test
    public void testFileUpload () {
        this.mainPage.clickLink("File Upload");
        final FileUploadPage uploadPage = new FileUploadPage();
        uploadPage.uploadFile(this.fileName);
        assertEquals(uploadPage.successHeader(), "File Uploaded!");
        assertEquals(uploadPage.uploadedFileName(), this.fileName);
    }
}