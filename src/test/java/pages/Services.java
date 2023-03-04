package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Services {
    WebDriver driver;

   String thirdDotUrl = "https://www.alan-systems.com/pl/uslugi/";


    public Services(WebDriver driver) {
        this.driver = driver;
    }

    public String getThirdDotUrl() {
        return thirdDotUrl;
    }


    public WebElement FindOutMorePushButton(){
        return driver.findElement(By.xpath("//a[@href='/pl/uslugi/' and @class='btn-transparent' and text()='zobacz więcej']"));
    }
}
