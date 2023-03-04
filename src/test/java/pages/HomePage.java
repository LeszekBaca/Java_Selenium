package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    private String baseUrl = "https://www.alan-systems.com/pl/";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public WebElement dot(int dotNumber){
        return driver.findElement(By.xpath("//ol[contains(@class,'carousel-indicators')]/li[@data-slide-to='"+dotNumber+"']"));
    }


}
