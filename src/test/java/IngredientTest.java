import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    @Test
    public void getPriceTest() {
        float expectedPrice = 100;
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "", expectedPrice);
        Assert.assertEquals(expectedPrice, ingredient.getPrice(), 1e-6);
    }

    @Test
    public void getNameTest() {
        String expectedName = "love";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, expectedName, 55);
        Assert.assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        IngredientType expectedType = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(expectedType, "", 0);
        Assert.assertEquals(expectedType, ingredient.getType());
    }
}
