import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import rottentomateschallenge.automation.AutomationException;
import rottentomateschallenge.automation.Browser;
import rottentomateschallenge.automation.RottenTomatoesDriver;
import rottentomateschallenge.automation.WebDriverFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;


@RunWith(Parameterized.class)
public class SeleniumTestBase {

    protected static Properties properties;
    protected static String propertiesFile = "/test.properties";

    HashMap<String, String> expected;

    WebDriver driver;

    public SeleniumTestBase(HashMap<String, String> expectedResults) {
        this.expected = expectedResults;
    }

    @BeforeClass
    public static void initialize() {
        try {
            properties = RottenTomatoesDriver.PropertyLoader.LoadProperties(propertiesFile);
        } catch (Exception e) {
            System.out.println();
            System.out.println("******************************************************");
            System.out.println("You probably need to configure a test.properties file.");
            System.out.println("See the example under src/main/resources");
            System.out.println("******************************************************");
            System.out.println();
        }
    }

    @Before
    public void setUp() throws AutomationException {
        // TODO: get webdriver instance from a factory based on config settings
        driver = new WebDriverFactory(properties).local().browser(Browser.CHROME).getInstance();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    //TODO: get expected results from external data source
    @Parameterized.Parameters
    public static Iterable data() {
        HashMap<String, String> expectedValues = new HashMap<>();
        ArrayList<HashMap<String, String>> expectedResults = new ArrayList<>();
        expectedResults.add(expectedValues);

        return expectedResults;
    }
}
