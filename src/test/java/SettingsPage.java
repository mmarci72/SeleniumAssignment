import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {
    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    private final By showDatesRadioButtonLocator = By.xpath("//input[@class='radio' and @id='misc1']");
    private final By saveChangesButtonLocator = By.xpath("//a[@title='Save']");
    private final By nextDaysNumberLocator = By.xpath("//input[@id='days1' and @name='days1']");
    private final By logoLocator = By.xpath("//img[@alt='Logo left part']");

    public boolean isShowDatesChecked() {
        return waitAndReturnElement(showDatesRadioButtonLocator).isSelected();
    }

    public SettingsPage checkShowDatesCheckbox() {
        waitAndReturnElement(showDatesRadioButtonLocator).click();

        return this;
    }

    public int getNextDays() {
        return Integer.parseInt(waitAndReturnElement(nextDaysNumberLocator).getAttribute("value"));
    }

    public SettingsPage writeNextDaysFromCurrentWeek(int number) {
        waitAndReturnElement(nextDaysNumberLocator).clear();
        waitAndReturnElement(nextDaysNumberLocator).sendKeys(Integer.toString(number));
        return this;
    }

    public SettingsPage saveChanges() {
        waitAndReturnElement(saveChangesButtonLocator).click();

        return this;
    }

    public MainPage backToMainPage() {
        waitAndReturnElement(logoLocator).click();

        return new MainPage(driver);
    }
}

