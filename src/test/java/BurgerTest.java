import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import org.junit.Before;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    ArrayList<Ingredient> ingredients;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        Bun expectedBun = new Bun("bulochka", 100);
        burger.setBuns(expectedBun);
        Assert.assertEquals(expectedBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients = ingredients;
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cheese", 50);
        burger.addIngredient(ingredient);
        Mockito.verify(ingredients).add(ingredient);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients  = ingredients;
        int index = 45;
        burger.removeIngredient(index);
        Mockito.verify(ingredients).remove(index);
    }

    @Test
    public void moveIngredientTest() {
        // given
        Burger burger = new Burger();
        Ingredient meat = new Ingredient(IngredientType.FILLING, "meat", 50);
        Ingredient ketchup = new Ingredient(IngredientType.SAUCE, "ketchup", 10);
        Ingredient cheese = new Ingredient(IngredientType.FILLING, "cheese", 70);
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
        Bun bun = new Bun("bulochka", 100);
        burger.bun = bun;
        Ingredient meat = new Ingredient(IngredientType.FILLING, "meat", 50);
        Ingredient ketchup = new Ingredient(IngredientType.SAUCE, "ketchup", 10);
        Ingredient cheese = new Ingredient(IngredientType.FILLING, "cheese", 70);
        burger.ingredients = new ArrayList<>(List.of(
                meat,
                ketchup,
                cheese
        ));

        StringBuilder expectedReceipt = new StringBuilder();
        expectedReceipt.append("(==== bulochka ====)\n");
        expectedReceipt.append("= filling meat =\n");
        expectedReceipt.append("= sauce ketchup =\n");
        expectedReceipt.append("= filling cheese =\n");
        expectedReceipt.append("(==== bulochka ====)\n");
        expectedReceipt.append(String.format("\nPrice: %f\n", 330.f));

        Assert.assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}
