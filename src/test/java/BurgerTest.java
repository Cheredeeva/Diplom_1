import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    ArrayList<Ingredient> ingredients;
    @Mock
    Bun bun;
    @Mock
    Ingredient meat;
    @Mock
    Ingredient ketchup;
    @Mock
    Ingredient cheese;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(bun.getName()).thenReturn("bulochka");
        when(bun.getPrice()).thenReturn(100.f);

        when(cheese.getType()).thenReturn(IngredientType.FILLING);
        when(cheese.getName()).thenReturn("cheese");
        when(cheese.getPrice()).thenReturn(70.f);

        when(ketchup.getType()).thenReturn(IngredientType.SAUCE);
        when(ketchup.getName()).thenReturn("ketchup");
        when(ketchup.getPrice()).thenReturn(10.f);

        when(meat.getType()).thenReturn(IngredientType.FILLING);
        when(meat.getName()).thenReturn("meat");
        when(meat.getPrice()).thenReturn(50.f);

    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = ingredients;
        burger.addIngredient(cheese);
        Mockito.verify(ingredients).add(cheese);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = ingredients;
        int index = 45;
        burger.removeIngredient(index);
        Mockito.verify(ingredients).remove(index);
    }

    @Test
    public void moveIngredientTest() {
        // given
        Burger burger = new Burger();
        burger.ingredients = new ArrayList<>(List.of(
                meat,
                ketchup,
                cheese
        ));

        // when
        burger.moveIngredient(2, 0);

        // then
        List<Ingredient> expectedIngredients = List.of(
                cheese,
                meat,
                ketchup
        );
        Assert.assertEquals(expectedIngredients, burger.ingredients);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.bun = bun;
        burger.ingredients = new ArrayList<>(List.of(
                meat,
                ketchup,
                cheese
        ));

        String expectedReceipt = "(==== bulochka ====)\n" +
                "= filling meat =\n" +
                "= sauce ketchup =\n" +
                "= filling cheese =\n" +
                "(==== bulochka ====)\n" +
                String.format("\nPrice: %f\n", 330.f);

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
