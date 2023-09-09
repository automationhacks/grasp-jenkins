import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HelloWorldTest {
    @Test
    public void aTest() {
        // I always pass️ 😅
        assertTrue(true);

    }

    @Test
    public void aTestThatAlwaysFails() {
        // duh! 🤦‍♂️
        assertTrue(false);
    }

    @Test(groups = "pick_me")
    public void aTestThatShouldBeFilteredAndPasses() {
        assertTrue(true);
    }

    @Test(groups = "pick_me")
    public void aTestThatShouldBeFilteredAndFails() {
        assertTrue(false);
    }

}
