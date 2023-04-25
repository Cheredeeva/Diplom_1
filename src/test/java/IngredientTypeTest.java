import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void valueOfSauceTest() {
        IngredientType sauce = IngredientType.SAUCE;
        Assert.assertEquals(sauce, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void valueOfFillingTest() {
        IngredientType filling = IngredientType.FILLING;
        Assert.assertEquals(filling, IngredientType.valueOf("FILLING"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void valueOfInvalidTest() {
        IngredientType.valueOf("Bulka");
    }
}
