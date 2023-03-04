package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    private String baseUrl = "https://www.alan-systems.com/pl/";
//    By firstDotUrl = By.xpath("https://www.alan-systems.com/pl/kariera/");
//    By secondDotUrl = By.xpath("https://www.alan-systems.com/pl/zaklady-sportowe/");
//    By thirdDotUrl = By.xpath("https://www.alan-systems.com/pl/uslugi/");
//    By fourthDotUrl = By.xpath("https://www.alan-systems.com/pl/atms-watch/");
//    By fifthDotrl = By.xpath("https://www.alan-systems.com/pl/atms-kids/");
//    By sixthDotUrl = By.xpath("https://www.alan-systems.com/pl/cream/");



    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public WebElement Dot(int dotNumber){
        return driver.findElement(By.xpath("//ol[contains(@class,'carousel-indicators')]/li[@data-slide-to='"+dotNumber+"']"));
    }


}
