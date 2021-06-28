// Page URL: https://mail.ru
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObject{

    WebDriverWait wait = new WebDriverWait(driver,5);

    private final String LOGIN_NAME = "testing010399";
    private final String PWD_VALUE = "qualityLAB123";

    @FindBy(name = "login")
    private WebElement login_name;

    @FindBy(name = "password")
    private WebElement pwd_value;

    @FindBy(xpath = "//*[@data-testid='enter-password']")
    private WebElement enter_password;

    @FindBy(xpath = "//*[@data-testid='login-to-mail']")
    private WebElement login_to_mail;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLoginValue(){
        wait.until(ExpectedConditions.visibilityOf(login_name));
        this.login_name.sendKeys(LOGIN_NAME);
    }

    public void enterPassword(){
        wait.until(ExpectedConditions.visibilityOf(pwd_value));
        this.pwd_value.sendKeys(PWD_VALUE);
    }

    public void enterPasswordButton(){
        wait.until(ExpectedConditions.elementToBeClickable(enter_password));
        this.enter_password.click();
    }

    public void enterLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(login_to_mail));
        this.login_to_mail.click();
    }
}
