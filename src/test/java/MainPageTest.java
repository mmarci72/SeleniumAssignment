import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class MainPageTest extends BaseTest {
    public MainPage mainPage;

    @Before
    @Override
    public void setUp() throws MalformedURLException, URISyntaxException {
        super.setUp();
        mainPage = new MainPage(driver);
    }

    @Test
    public void testTitle() {
        String expectedTitle = "Track the TV shows, episodes and movies you watch - Next Episode";
        assertEquals(expectedTitle, driver.getTitle());
    }

    @Test
    public void testLogout() {
        mainPage.goToLoginPage().signInAs("test", "test").logout();

        assertFalse(mainPage.getBodyText().contains("hey there"));
    }
}
