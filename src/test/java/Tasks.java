import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


public class Tasks {

    private WebDriver driver = new ChromeDriver();
    private HomePage homePage = new HomePage(driver);
    private AtmsKids atmsKids = new AtmsKids(driver);
    private AtmsWatch atmsWatch = new AtmsWatch(driver);
    private Career career = new Career(driver);
    private Cream cream = new Cream(driver);
    private Services services = new Services(driver);
    private SportsBetting sportsBetting = new SportsBetting(driver);
    private SoftwareTesting softwareTesting = new SoftwareTesting(driver);

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Test
    public void checkingDotsOnMainPageTest() throws Exception {
        driver.get(homePage.getBaseUrl());

        for (int i = 0; i < 6; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(homePage.dot(i)));
            homePage.dot(i).click();

            switch (i) {
                case 0: {
                    wait.until(ExpectedConditions.elementToBeClickable(career.FindOutMorePushButton()));
                    career.FindOutMorePushButton().click();
                    Assert.assertEquals(driver.getCurrentUrl(), career.getFirstDotUrl());
                    break;
                }
                case 1: {
                    wait.until(ExpectedConditions.elementToBeClickable(sportsBetting.FindOutMorePushButton()));
                    sportsBetting.FindOutMorePushButton().click();
                    Assert.assertEquals(driver.getCurrentUrl(), sportsBetting.getSecondDotUrl());
                    break;
                }
                case 2: {
                    wait.until(ExpectedConditions.elementToBeClickable(services.FindOutMorePushButton()));
                    services.FindOutMorePushButton().click();
                    Assert.assertEquals(driver.getCurrentUrl(), services.getThirdDotUrl());
                    break;
                }
                case 3: {
                    wait.until(ExpectedConditions.elementToBeClickable(atmsWatch.FindOutMorePushButton()));
                    atmsWatch.FindOutMorePushButton().click();
                    Assert.assertEquals(driver.getCurrentUrl(), atmsWatch.getFourthDotUrl());
                    break;
                }
                case 4: {
                    wait.until(ExpectedConditions.elementToBeClickable(atmsKids.FindOutMorePushButton()));
                    atmsKids.FindOutMorePushButton().click();
                    Assert.assertEquals(driver.getCurrentUrl(), atmsKids.getFifthDotUrl());
                    break;
                }
                case 5: {
                    wait.until(ExpectedConditions.elementToBeClickable(cream.FindOutMorePushButton()));
                    cream.FindOutMorePushButton().click();
                    Assert.assertEquals(driver.getCurrentUrl(), cream.getSixthDotUrl());
                    break;
                }
            }
            driver.get(homePage.getBaseUrl());
        }
    }

    @Test
    public void customerSendFormTest() throws Exception {
        driver.get(homePage.getBaseUrl());
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);

        action.moveToElement(homePage.servicesTab()).perform();
        wait.until(ExpectedConditions.elementToBeClickable(homePage.servicesDropListSoftwareTesting()));
        homePage.servicesDropListSoftwareTesting().click();
        js.executeScript("window.scrollBy(0,1500)");

        if (softwareTesting.getNameAndSurname()
                .equals(softwareTesting.nameAndSurname().getAttribute(softwareTesting.getPlaceholder()))) {
            System.out.println("Element \"Twoje imię i nazwisko *\" exists");
        } else {
            System.out.println("Element \"Twoje imię i nazwisko *\" does not exist");
        }

        Assert.assertEquals(softwareTesting.nameAndSurname().getAttribute(softwareTesting.getPlaceholder()),
                softwareTesting.getNameAndSurname() );

        if (softwareTesting.getEmail().equals(softwareTesting.email().getAttribute(softwareTesting.getPlaceholder()))) {
            System.out.println("Element \"Twój email *\" exists");
        } else {
            System.out.println("Element \"Twój email *\" does not exist");
        }

        Assert.assertEquals(softwareTesting.email()
                .getAttribute(softwareTesting.getPlaceholder()), softwareTesting.getEmail());

        if (softwareTesting.getTelephoneNumber()
                .equals(softwareTesting.telephoneNumber().getAttribute(softwareTesting.getPlaceholder()))) {
            System.out.println("Element \"Twój numer telefonu\" exists");
        } else {
            System.out.println("Element \"Twój numer telefonu\" does not exist");
        }

        Assert.assertEquals(softwareTesting.telephoneNumber().getAttribute(softwareTesting.getPlaceholder()),
                softwareTesting.getTelephoneNumber() );

        if (softwareTesting.getContactWithYouQuestion()
                .equals(softwareTesting.contactWithYouQuestion().getAttribute(softwareTesting.getPlaceholder()))) {
            System.out.println("Element \"Kiedy możemy się z Tobą skontaktować?\" exists");
        } else {
            System.out.println("Element \"Kiedy możemy się z Tobą skontaktować?\" does not exist");
        }

        Assert.assertEquals(softwareTesting.contactWithYouQuestion().getAttribute(softwareTesting.getPlaceholder()),
                softwareTesting.getContactWithYouQuestion());

        if (softwareTesting.sendButton().isDisplayed()) {
            System.out.println("Element \"Wyślij\" is visable");
        } else {
            System.out.println("Element \"Wyślij\" is not visable");
        }

        Assert.assertTrue(softwareTesting.sendButton().isDisplayed());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
