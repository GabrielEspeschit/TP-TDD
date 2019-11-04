import org.junit.Assert;

public class Dollar {
    int amount = 10;

    Dollar(int amount) {
    }

    void times(int multiplier) {
    }

    public void testMultiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        Assert.assertEquals(10, five.amount);
    }
}