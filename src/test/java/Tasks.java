import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import java.time.Duration;


public class Tasks {

    private ChromeDriver driver;
    private HomePage homePage;
    private AtmsKids atmsKids;
    private AtmsWatch atmsWatch;
    private Career career;
    private Cream cream;
    private Services services;
    private SportsBetting sportsBetting;
    private SoftwareTesting softwareTesting;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        atmsKids = new AtmsKids(driver);
        atmsWatch = new AtmsWatch(driver);
        career = new Career(driver);
        cream = new Cream(driver);
        services = new Services(driver);
        sportsBetting = new SportsBetting(driver);
        softwareTesting = new SoftwareTesting(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
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
