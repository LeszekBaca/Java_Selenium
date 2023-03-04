package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cream {

    WebDriver driver;

    String sixthDotUrl = "https://www.alan-systems.com/pl/cream/";

    public Cream(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getSixthDotUrl() {
        return sixthDotUrl;
    }

    public WebElement FindOutMorePushButton(){
        return driver.findElement(By.xpath("//a[@href='/pl/cream/' and @class='btn-transparent' and text()='zobacz więcej']"));
    }
}
