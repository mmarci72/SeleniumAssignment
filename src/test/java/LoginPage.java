import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameLocator =  By.xpath("//form[@name='login']//input[@id='username']");
    private final By passwordLocator =  By.xpath("//form[@name='login']//input[@id='password']");
    private final By signInButtonLocator =  By.xpath("//form[@name='login']//a[@class='link2' and text()='Sign In']");


    public String getTypedUsername() {
        return waitAndReturnElement(usernameLocator).getAttribute("value");
    }

    public String getTypedPassword() {
        return waitAndReturnElement(passwordLocator).getAttribute("value");
    }

    public LoginPage typeUsername(String username) {
        waitAndReturnElement(usernameLocator).sendKeys(username);

        return this;
    }

    public LoginPage typePassword(String password) {
        waitAndReturnElement(passwordLocator).sendKeys(password);

        return this;
    }

    public MainPage submitLogin() {
        waitAndReturnElement(signInButtonLocator).click();

        return new MainPage(driver);
    }

    public MainPage signInAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}
