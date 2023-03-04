package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SoftwareTesting {


    private WebDriver driver;
    private String placeholder = "placeholder";

    private String nameAndSurname = "Twoje imię i nazwisko *";

    private String email = "Twój email *";


    private String telephoneNumber = "Twój numer telefonu";


    private String contactWithYouQuestion = "Kiedy możemy się z Tobą skontaktować?";


    public SoftwareTesting(WebDriver driver) {
        this.driver = driver;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getContactWithYouQuestion() {
        return contactWithYouQuestion;
    }

    public WebElement nameAndSurname(){
        return driver.findElement(By.xpath( "//input[@type=\"text\" and @name='your-name']"));
    }
    public WebElement email(){
        return driver.findElement(By.xpath( "//input[@type=\"email\" and @name='your-email']"));
    }

    public WebElement telephoneNumber(){
        return driver.findElement(By.xpath( "//input[@type=\"tel\" and @name='tel-333']"));
    }

    public WebElement contactWithYouQuestion(){
        return driver.findElement(By.xpath( "//textarea[@class='wpcf7-form-control wpcf7-textarea']"));
    }

    public WebElement sendButton(){
        return driver.findElement(By.xpath( "//input[@type=\"submit\" and @value='Wyślij']"));
    }

}
