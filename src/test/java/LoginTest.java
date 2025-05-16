import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class LoginTest extends BaseTest {
    public LoginPage loginPage;

    @Before
    @Override
    public void setUp() throws MalformedURLException, URISyntaxException {
        super.setUp();
        MainPage mainPage = new MainPage(driver);
        loginPage = mainPage
                .consentToCookies()
                .goToLoginPage();
    }

    @Test
    public void testTypeUsername() {
        String username = "test";

        loginPage.typeUsername(username);
        assertEquals(username, loginPage.getTypedUsername());
    }

    @Test
    public void testTypePassword() {
        String password = "test";

        loginPage.typePassword(password);
        assertEquals(password, loginPage.getTypedPassword());
    }

    @Test
    public void testInvalidLogin() {
        String username = "test";
        String password = "invalidPassword";

        MainPage mainPage = loginPage.signInAs(username, password);
        assertTrue(mainPage.isSignInButtonVisible());
    }

    @Test
    public void testLogin() {
        String username = "test";
        String password = "test";

        MainPage mainPage = loginPage.signInAs(username, password);
        assertTrue(mainPage.getBodyText().contains("hey there"));
    }
}
