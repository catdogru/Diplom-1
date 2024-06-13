package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    public IngredientType type;
    public String stringValue;

    public IngredientTypeTest(IngredientType type, String stringValue) {
        this.type = type;
        this.stringValue = stringValue;
    }

    @Parameterized.Parameters
    public static Object[][] getFelineData() {
        return new Object[][]{
                {SAUCE, "SAUCE"},
                {FILLING, "FILLING"}
        };
    }

    @Test
    public void valueOfTest() {
        IngredientType valueOf = IngredientType.valueOf(stringValue);
        assertEquals(type, valueOf);
    }
}
