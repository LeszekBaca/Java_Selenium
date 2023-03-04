package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AtmsWatch {

    WebDriver driver;

    String fourthDotUrl = "https://www.alan-systems.com/pl/atms-watch/";

    public AtmsWatch(WebDriver driver) {
        this.driver = driver;
    }

    public String getFourthDotUrl() {
        return fourthDotUrl;
    }

    public WebElement FindOutMorePushButton(){
        return driver.findElement(By.xpath("//a[@href='/pl/atms-watch/' and @class='btn-transparent' and text()='zobacz więcej']"));
    }
}
