import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://next-episode.net/");
    }

    private final By loginButtonLocator = By.xpath("//a[@id='link2' and @class='link2']");
    private final By consentCookieButtonLocator = By.xpath("//button[@aria-label='Consent']");
    private final By settingsButtonLocator = By.xpath("//a[@href='/settings']");
    private final By logoutButtonLocator = By.xpath("//a[@href='/logout']");


    public LoginPage goToLoginPage() {
        this.waitAndReturnElement(loginButtonLocator).click();
        return new LoginPage(driver);
    }

    public SettingsPage goToSettingsPage() {
        this.waitAndReturnElement(settingsButtonLocator).click();
        return new SettingsPage(driver);
    }

    public MainPage logout() {
        this.waitAndReturnElement(logoutButtonLocator).click();
        return this;
    }

    public Boolean isSignInButtonVisible() {
        return this.waitAndReturnElement(loginButtonLocator).isDisplayed();
    }

    public MainPage consentToCookies() {
        if (this.waitForElementToAppear(consentCookieButtonLocator, 5)) {
            this.waitAndReturnElement(consentCookieButtonLocator).click();
        }

        return this;
    }
}
