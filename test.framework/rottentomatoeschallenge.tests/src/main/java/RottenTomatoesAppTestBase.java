import org.junit.Before;
import rottentomateschallenge.automation.RottenTomatoesDriver;

import java.util.HashMap;

public class RottenTomatoesAppTestBase extends WebdriverTestBase {

    RottenTomatoesDriver app;
    public RottenTomatoesAppTestBase(HashMap<String, String> expectedResults) {
        super(expectedResults);
    }

    @Before
    public void setUp() {
        app = new RottenTomatoesDriver(driver);
        app.start();
    }
}
