package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SportsBetting {

    WebDriver driver;

    String secondDotUrl ="https://www.alan-systems.com/pl/zaklady-sportowe/";

    public SportsBetting(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getSecondDotUrl() {
        return secondDotUrl;
    }

    public WebElement FindOutMorePushButton(){
        return driver.findElement(By.xpath("//a[@href='/pl/zaklady-sportowe/' and text()='zobacz więcej']"));
    }
}
