import org.junit.Assert;

public class main {

    public void testDifferentClassEquality() {
        Assert.assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
    }

    public void testEquality() {
        Assert.assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        Assert.assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        Assert.assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }
}

