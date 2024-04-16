
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class PlayGroundTests{

    @Test
    public void openUrl() {
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", "D:\\Programming\\testing\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://playground.learnqa.ru/puzzle/triangle");

        WebElement button;

        if(driver.findElement(By.id("show_answ")).isDisplayed()
                && driver.findElement(By.id("show_answ")).isEnabled()){
            button = driver.findElement(By.id("show_answ"));
            button.click();
            assertTrue(driver.findElement(By.id("hide_answ")).isDisplayed()
                    && driver.findElement(By.id("hide_answ")).isEnabled()
                    && driver.findElement(By.id("answ")).isDisplayed());
        }
    }

}
