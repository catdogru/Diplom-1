package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.constants.Constants.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    public Bun bun;

    @Mock
    public List<Ingredient> ingredients;

    @Mock
    public Ingredient ingredient;

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger(bun, ingredients);
        burger.addIngredient(ingredient);
        verify(ingredients, times(ONE_INVOCATION)).add(any(Ingredient.class));
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger(bun, ingredients);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        verify(ingredients, times(ONE_INVOCATION)).remove(anyInt());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger(bun, ingredients);
        burger.moveIngredient(0, 1);
        verify(ingredients, times(ONE_INVOCATION)).remove(anyInt());
        verify(ingredients, times(ONE_INVOCATION)).add(anyInt(), any());
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger(bun, List.of(ingredient));
        burger.getPrice();
        verify(bun, times(1)).getPrice();
        verify(ingredient, times(burger.ingredients.size())).getPrice();
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger(bun, List.of(ingredient, ingredient));
        when(bun.getName()).thenReturn(DEFAULT_BUN_NAME);
        when(bun.getPrice()).thenReturn(DEFAULT_BUN_PRICE);
        when(ingredient.getType()).thenReturn(FILLING);
        when(ingredient.getPrice()).thenReturn(DEFAULT_INGREDIENT_PRICE);
        assertFalse("Receipt string should not be empty", burger.getReceipt().isEmpty());
    }
}