package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class NusukIdMaker {

    static List<File> files;
    static String link = "https://services.nusuk.sa/nusuk-svc/auth/login";
    static PDFFinder pdfFinder = new PDFFinder();

    public static void main(String[] args) throws IOException, InterruptedException {
//        uploadPDFs();
        test1();
    }

    public static void uploadPDFs() throws IOException {
        files = pdfFinder.findPDF();
    }

    public static void test1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(link);
        Thread.sleep(2500);
        WebElement loginbut = driver.findElement(By.xpath("//div[contains(@class, 'collapsed')]"));
        loginbut.click();
    }








}
