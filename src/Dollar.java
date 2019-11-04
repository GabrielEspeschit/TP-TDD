import org.junit.Assert;

class Money {
    public int amount;
    private String currency;

    static Money dollar(int amount)  {
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    String currency() {
        return currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && currency().equals(money.currency());
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public void testDifferentClassEquality() {
        Assert.assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
    }

    public void testEquality() {
        Assert.assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        Assert.assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        Assert.assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }
}

class Franc extends Money {
    Franc(int amount, String currency) {
        super(amount, currency);
    }

    Money times(int multiplier)  {
        return Money.franc(amount * multiplier);
    }
}

class Dollar extends Money {
    Dollar(int amount, String currency)  {
        super(amount, currency);
    }

    Money times(int multiplier)  {
        return Money.dollar(amount * multiplier);
    }
}