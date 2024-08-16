package FreightNetwork;

import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AutomateFreightNet {
    WebDriver driver;


    @BeforeSuite
    public void SearchUrl() {
        driver = new ChromeDriver();
        driver.navigate().to("https://freightnetwork.enlivendesigners.com");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void NavigateToContactPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contact = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Contact")));
        contact.click();
        driver.findElement(By.name("form_fields[name]")).sendKeys("Riimza");
        driver.findElement(By.xpath("//*[@id=\"form-field-email\"]")).sendKeys("rimza.imthaz@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/main/article/div/div/div[2]/div/div[1]/div[3]/div/form/div/div[3]/input")).sendKeys("0762825058");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/main/article/div/div/div[2]/div/div[1]/div[3]/div/form/div/div[4]/input")).sendKeys("AutoTestRun");
        driver.findElement(By.id("form-field-message")).sendKeys("This is An Automated message");
        driver.findElement(By.xpath("//*[@id=\"post-551\"]/div/div/div[2]/div/div[1]/div[3]/div/form/div/div[6]/button")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       // driver.navigate().back();
    }
    @Test(priority = 2)
    public void NavigateToGetAQuote(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement GetAQuote = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ast-desktop-header\"]/div/div/div/div/div[2]/div[2]/div/a[1]/div")));
        GetAQuote.click();

    }

    @Test(priority = 3)
    public void VerifyTitle(){
        driver.getTitle();
        //String actualTitle = driver.getTitle();

    }


    @AfterSuite
    public void Exit(){
       // driver.quit();
    }


}
