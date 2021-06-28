// Page URL: https://e.mail.ru/inbox/?back=1
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MailPage extends PageObject {

    WebDriverWait wait = new WebDriverWait(driver,5);

    private final String RECEIVER_NAME = "meiramovdanik@gmail.com";
    private final String TITLE_NAME = "TEST";
    private final String CONTEXT_VALUE = "Test Test Test";

    @FindBy(xpath = "//*[@class='compose-button__wrapper']")
    private WebElement mail_compose_button;

    @FindBy(xpath = "//div[@class='container--ItIg4']/div[@class='inputContainer--nsqFu']/input")
    private WebElement mail_receiver_input;

    @FindBy(xpath = "//div[@class='container--3QXHv compressed--2KOQl']/div[@class='inputContainer--nsqFu']/input")
    private WebElement mail_title_input;

    @FindBy(xpath = "//div[@class='container--2Rl8H']/div/div[2]/div/div[1]")
    private WebElement mail_content_input;

    @FindBy(xpath = "//div[@class='compose-app__buttons']//span[contains(@title, 'Отправить')]")
    private WebElement mail_send_button;

    @FindBy(xpath = "/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[2]/a")
    private WebElement mail_assert_text;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void mailComposeButton(){
        wait.until(ExpectedConditions.elementToBeClickable(mail_compose_button));
        this.mail_compose_button.click();
    }

    public void mailReceiverInput(){
        wait.until(ExpectedConditions.visibilityOf(mail_receiver_input));
        this.mail_receiver_input.sendKeys(RECEIVER_NAME);
    }

    public void mailTitleInput(){
        wait.until(ExpectedConditions.visibilityOf(mail_title_input));
        this.mail_title_input.sendKeys(TITLE_NAME);
    }

    public void mailContentInput(){
        wait.until(ExpectedConditions.elementToBeClickable(mail_content_input));
        this.mail_content_input.click();
        this.mail_content_input.sendKeys(new String[] {CONTEXT_VALUE});
    }

    public void mailSendButton(){
        wait.until(ExpectedConditions.elementToBeClickable(mail_send_button));
        this.mail_send_button.click();
    }

    public void mailAssertion(){
        wait.until(ExpectedConditions.visibilityOf(mail_assert_text));
        String actualString = this.mail_assert_text.getText();
        Assert.assertTrue(actualString.contains("Письмо отправлено"));
    }
}
