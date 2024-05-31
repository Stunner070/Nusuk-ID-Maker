import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;

public class webTest {

    WebDriver browser;

    @Test
    void t1(){
        browser = new ChromeDriver();
        browser.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium");
        WebElement title = browser.findElement(By.tagName("h1"));
        Assertions.assertEquals("Group: SeleniumHQ Selenium", title.getText());
    }

    @Test
    void t2(){
        browser = new EdgeDriver();
        browser.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium");
        WebElement title = browser.findElement(By.tagName("h1"));
        Assertions.assertEquals("Group: SeleniumHQ Selenium", title.getText());
    }

    @Test
    void t3(){
        browser = new ChromeDriver();
        browser.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium");
        browser.findElement(By.id("query")).sendKeys("selenium");
        WebElement name = browser.findElement(By.className("im-title")).findElement(By.tagName("a"));
        assertEquals("Selenium Java", name.getText());
    }

    @AfterEach
    void closeBrowser(){
        browser.quit();
    }
}
