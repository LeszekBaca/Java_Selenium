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

    public WebElement servicesTab(){
        return driver.findElement(By.xpath("//a[@href='https://www.alan-systems.com/pl/uslugi/' and text()='USŁUGI ']"));
    }

    public WebElement servicesDropListSoftwareTesting(){
        return driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[@class='menu-item menu-item-type-post_type menu-item-object-page menu-item-9975']"));
    }
}
