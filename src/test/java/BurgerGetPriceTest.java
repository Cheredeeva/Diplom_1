import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerGetPriceTest {
    private final float bunPrice;
    private final List<Float> ingredientPrices;
    private final float expectedPrice;

    public BurgerGetPriceTest(float bunPrice, List<Float> ingredientPrices, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrices = ingredientPrices;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][]{
                {100, List.<Float>of(10.f, 43.f, 50.f), 303},
                {0, List.<Float>of(10.f, 50.f, 0.f), 60},
        };
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.bun = new Bun("", bunPrice);
        for (float ingredientPrice : ingredientPrices) {
            burger.ingredients.add(new Ingredient(IngredientType.FILLING, "", ingredientPrice));
        }
        Assert.assertEquals(expectedPrice, burger.getPrice(), 1e-6);
    }

}
