package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTest{
        WebDriver tester;
        @BeforeClass
        @Parameters({"Browser","Url"})
        public void sauceTest(String browser,String link) {

            if(browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                tester = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                tester = new EdgeDriver();
            }
            tester.get(link);
            tester.manage().window().maximize();

        }

    @Test
    void accessWebsite() throws InterruptedException {
            tester.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("bsrramu45@gmail.com");
            Thread.sleep(750);
            tester.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
            Thread.sleep(750);
//            tester.findElement(By.xpath("")).sendKeys("password");
//            Thread.sleep(750);
//            tester.findElement(By.xpath("")).click();
//            Thread.sleep(750);

    }

    @Test
    public void testcase1_login() {
        App a = new App();
        Assert.assertEquals(true,a.login_mail("bsrramu45@gmail.com","BHARATHI1@"));

    }


    @Test
    public void testcase2_login() {
        App a = new App();
        Assert.assertEquals(false,a.login_mail("bsrramu45@gmail.com","Sairam1@"));
    }


    @Test
    public void testcase3_login() {
        App a = new App();
        Assert.assertEquals(false,a.login_mail("any@gmail.com","BHARATHI1@"));

    }
    @AfterClass
    void closedriver(){
            tester.close();
    }
}
