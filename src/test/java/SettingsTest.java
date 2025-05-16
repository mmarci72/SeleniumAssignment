import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SettingsTest extends BaseTest {
    public SettingsPage settingsPage;

    @Before
    @Override
    public void setUp() throws MalformedURLException, URISyntaxException {
        super.setUp();
        MainPage mainPage = new MainPage(driver);
        settingsPage = mainPage
                .consentToCookies()
                .goToLoginPage()
                .signInAs("test", "test")
                .goToSettingsPage();
    }

    @Test
    public void testCheckDates() {
        boolean currentValue = settingsPage.isShowDatesChecked();
        settingsPage.checkShowDatesCheckbox();
        assertEquals(!currentValue, settingsPage.isShowDatesChecked());
    }

    @Test
    public void testWriteDaysFromCurrentWeek() {
       int days = 11;

       settingsPage.writeNextDaysFromCurrentWeek(days);
       assertEquals(days, settingsPage.getNextDays());
    }

    @Test
    public void testSaveChanges() {
        boolean currentValue = settingsPage.isShowDatesChecked();
        int days = 11;

        SettingsPage newSettingsPage = settingsPage
                .checkShowDatesCheckbox()
                .writeNextDaysFromCurrentWeek(days)
                .saveChanges();

        //Navigate away and back to settings page to check whether changes have been saved
        driver.navigate().back();
        driver.navigate().forward();

        assertEquals(days, newSettingsPage.getNextDays());
        assertEquals(!currentValue, settingsPage.isShowDatesChecked());
    }

    @Test
    public void testCorrectlyOpened() {
        assertTrue(settingsPage.getBodyText().contains("Watchlist settings"));
    }
}
