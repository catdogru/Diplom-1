package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.constants.Constants.DEFAULT_BUN_NAME;
import static praktikum.constants.Constants.DEFAULT_BUN_PRICE;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getBunData() {
        return new Object[][]{
                {DEFAULT_BUN_NAME + "_1", DEFAULT_BUN_PRICE},
                {DEFAULT_BUN_NAME + "_100500", DEFAULT_BUN_PRICE},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test
    public void getNameTest() {
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        float delta = 0;
        assertEquals(price, bun.getPrice(), delta);
    }
}