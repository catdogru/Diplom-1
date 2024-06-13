package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;
import static praktikum.constants.Constants.DEFAULT_INGREDIENT_NAME;
import static praktikum.constants.Constants.DEFAULT_INGREDIENT_PRICE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] getIngredientType() {
        return new Object[][]{
                {FILLING, DEFAULT_INGREDIENT_NAME + "_1", DEFAULT_INGREDIENT_PRICE},
                {SAUCE, DEFAULT_INGREDIENT_NAME + "_2", DEFAULT_INGREDIENT_PRICE},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void testGetIngredientType() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void testGetName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        float delta = 0;
        assertEquals(price, ingredient.getPrice(), delta);
    }
}