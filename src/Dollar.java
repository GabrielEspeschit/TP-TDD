import org.junit.Assert;

public class Dollar extends Money {
    int amount;

    Dollar(int amount) {
        this.amount = amount;
    }

    Money times(int multiplier)  {
        return new Dollar(amount * multiplier);
    }

    public void testMultiplication() {
        Money five = Money.dollar(5);
        Assert.assertEquals(Money.dollar(10), five.times(2));
        Assert.assertEquals(Money.dollar(15), five.times(3));
    }

    public void testEquality() {
        Assert.assertTrue(new Dollar(5).equals(new Dollar(5)));
        Assert.assertFalse(new Dollar(5).equals(new Dollar(6)));
    }

    public boolean equals(Object object) {
        Dollar dollar = (Dollar) object;
        return amount == dollar.amount;
    }
}


class Franc extends Money {
    private int amount;
    Franc(int amount) {
        this.amount= amount;
    }
    Money times(int multiplier)  {
        return new Franc(amount * multiplier);
    }
    public boolean equals(Object object) {
        Franc franc = (Franc) object;
        return amount == franc.amount;
    }

    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        Assert.assertEquals(new Franc(10), five.times(2));
        Assert.assertEquals(new Franc(15), five.times(3));
    }
}

abstract class Money {
    protected int amount;

    abstract Money times(int multiplier);

    static Dollar dollar(int amount)  {
        return new Dollar(amount);
    }

    static Money franc(int amount) {
        return new Franc(amount);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }

    public void testEquality() {
        Assert.assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        Assert.assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        Assert.assertTrue(Money.franc(5).equals(Money.franc(5)));
        Assert.assertFalse(Money.franc(5).equals(Money.franc(6)));
        Assert.assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    public void testFrancMultiplication() {
        Money five = Money.franc(5);
        Assert.assertEquals(Money.franc(10), five.times(2));
        Assert.assertEquals(Money.franc(15), five.times(3));
    }

}