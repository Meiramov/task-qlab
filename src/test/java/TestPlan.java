import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", UtilityClass.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "LoginPage")
    public static void loginPage() {
        driver.get(UtilityClass.BASE_URL);
        LoginPage webForm = new LoginPage(driver);
        driver.manage().window().maximize();

        webForm.enterLoginValue();
        webForm.enterPasswordButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webForm.enterPassword();
        webForm.enterLoginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test(testName = "MailPage")
    public void mailPage() throws InterruptedException {

        MailPage webForm = new MailPage(driver);

        webForm.mailComposeButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webForm.mailReceiverInput();
        webForm.mailTitleInput();
        webForm.mailContentInput();
        webForm.mailSendButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webForm.mailAssertion();
    }

    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

//    private void sleep(long m) {
//        try {
//            Thread.sleep(m);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}
