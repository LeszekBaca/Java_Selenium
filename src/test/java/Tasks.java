import pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Tasks {

    private WebDriver driver = new ChromeDriver();
    private HomePage homePage = new HomePage(driver);
    private AtmsKids atmsKids = new AtmsKids(driver);
    private AtmsWatch atmsWatch = new AtmsWatch(driver);
    private Career career = new Career(driver);
    private Cream cream = new Cream(driver);
    private Services services = new Services(driver);
    private SportsBetting sportsBetting = new SportsBetting(driver);

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Test
    public void taskFirst() throws Exception {
        driver.get(homePage.getBaseUrl());

        for (int i = 0; i < 6; i++) {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            homePage.dot(i).click();
            Thread.sleep(2000);

            switch (i) {
                case 0: {
                    career.FindOutMorePushButton().click();
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    Assert.assertEquals(driver.getCurrentUrl(), career.getFirstDotUrl());
                    break;
                }
                case 1: {
                    sportsBetting.FindOutMorePushButton().click();
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    Assert.assertEquals(driver.getCurrentUrl(), sportsBetting.getSecondDotUrl());
                    break;
                }
                case 2: {
                    services.FindOutMorePushButton().click();
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    Assert.assertEquals(driver.getCurrentUrl(), services.getThirdDotUrl());
                    break;
                }
                case 3: {
                    atmsWatch.FindOutMorePushButton().click();
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    Assert.assertEquals(driver.getCurrentUrl(), atmsWatch.getFourthDotUrl());
                    break;
                }
                case 4: {
                    atmsKids.FindOutMorePushButton().click();
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    Assert.assertEquals(driver.getCurrentUrl(), atmsKids.getFifthDotUrl());
                    break;
                }
                case 5: {
                    cream.FindOutMorePushButton().click();
                    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                    Assert.assertEquals(driver.getCurrentUrl(), cream.getSixthDotUrl());
                    break;
                }
            }
            driver.get(homePage.getBaseUrl());
        }
    }

    @Test
    public void taskSecond() throws Exception {
        driver.get(homePage.getBaseUrl());
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("//a[@href='https://www.alan-systems.com/pl/uslugi/' and text()='USŁUGI ']"));

        WebElement text = driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li[@class='menu-item menu-item-type-post_type menu-item-object-page menu-item-9975']"));

        action.moveToElement(ele).perform();
        Thread.sleep(2000);
        text.click();
        js.executeScript("window.scrollBy(0,1500)");

        String name = driver.findElement(By.xpath("//input[@type=\"text\" and @name='your-name']")).getAttribute("placeholder");

        if ("Twoje imię i nazwisko *".equals(name)) {
            System.out.println("Element \"Twoje imię i nazwisko *\" exists");
        } else {
            System.out.println("Element \"Twoje imię i nazwisko *\" does not exist");
        }


        String email = driver.findElement(By.xpath("//input[@type=\"email\" and @name='your-email']")).getAttribute("placeholder");

        if ("Twój email *".equals(email)) {
            System.out.println("Element \"Twój email *\" exists");
        } else {
            System.out.println("Element \"Twój email *\" does not exist");
        }


        String tel = driver.findElement(By.xpath("//input[@type=\"tel\" and @name='tel-333']")).getAttribute("placeholder");

        if ("Twój numer telefonu".equals(tel)) {
            System.out.println("Element \"Twój numer telefonu\" exists");
        } else {
            System.out.println("Element \"Twój numer telefonu\" does not exist");
        }


        String contact = driver.findElement(By.xpath("//textarea[@class='wpcf7-form-control wpcf7-textarea']")).getAttribute("placeholder");

        if ("Kiedy możemy się z Tobą skontaktować?".equals(contact)) {
            System.out.println("Element \"Kiedy możemy się z Tobą skontaktować?\" exists");
        } else {
            System.out.println("Element \"Kiedy możemy się z Tobą skontaktować?\" does not exist");
        }


        boolean pushbuttonWyslj = driver.findElement(By.xpath("//input[@type=\"submit\" and @value='Wyślij']")).isDisplayed();

        if (pushbuttonWyslj) {
            System.out.println("Element \"Wyślij\" is visable");
        } else {
            System.out.println("Element \"Wyślij\" is not visable");
        }


        //Thread.sleep(2000);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
