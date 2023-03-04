package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AtmsKids {

    WebDriver driver;

    String fifthDotUrl = "https://www.alan-systems.com/pl/atms-kids/";

    public AtmsKids(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getFifthDotUrl() {
        return fifthDotUrl;
    }

    public WebElement FindOutMorePushButton(){
        return driver.findElement(By.xpath("//a[@href='/pl/atms-kids/' and @class='btn-transparent' and text()='zobacz więcej']"));
    }
}
