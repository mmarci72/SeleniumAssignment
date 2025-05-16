import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException, URISyntaxException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new RemoteWebDriver(new URI("http://selenium:4444/wd/hub").toURL(), options);
        driver.manage().window().maximize();
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
