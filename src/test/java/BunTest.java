import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameTest() {
        String expectedName = "bulochka";
        Bun bun = new Bun(expectedName, 100);
        Assert.assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = 100;
        Bun bun = new Bun("bulochka", expectedPrice);
        Assert.assertEquals(expectedPrice, bun.getPrice(), 1e-6);
    }
}
