package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Career {

    WebDriver driver;

    String firstDotUrl = "https://www.alan-systems.com/pl/kariera/";

    public Career(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getFirstDotUrl() {
        return firstDotUrl;
    }

    public WebElement FindOutMorePushButton(){
        return driver.findElement(By.xpath("//a[@href='/pl/kariera/' and text()='dowiedz się więcej']"));
    }
    //driver.findElement(By.xpath("//a[@href='/pl/kariera/' and text()='dowiedz się więcej']")).click();
}
