import org.junit.Assert;

public class Dollar {
    int amount;

    Dollar(int amount) {
        this.amount = amount;
    }

    int times(int multiplier) {
        return amount * multiplier;
    }

    public void testMultiplication() {
        Dollar five = new Dollar(5);
        Assert.assertEquals(new Dollar(10), five.times(2));
        Assert.assertEquals(new Dollar(15), five.times(3));
    }

    public void testEquality() {
        Assert.assertTrue(new Dollar(5).equals(new Dollar(5)));
        Assert.assertFalse(new Dollar(5).equals(new Dollar(6)));
    }

    public boolean equals(Object object) {
        Dollar dollar = (Dollar) object;
        return amount == dollar.amount;
    }

    class Franc {
        private int amount;

        Franc(int amount) {
            this.amount = amount;
        }

        Franc times(int multiplier) {
            return new Franc(amount * multiplier);
        }

        public boolean equals(Object object) {
            Franc franc = (Franc) object;
            return amount == franc.amount;
        }
    }

    public void testFrancMultiplication() {
        Franc five = new Franc(5);
        Assert.assertEquals(new Franc(10), five.times(2));
        Assert.assertEquals(new Franc(15), five.times(3));
    }

    class Money  {
        protected int amount;

        public boolean equals(Object object)  {
            Money money = (Money) object;
            return amount == money.amount;
        }
    }

    public void testEquality() {
        Assert.assertTrue(new Dollar(5).equals(new Dollar(5)));
        Assert.assertFalse(new Dollar(5).equals(new Dollar(6)));
        Assert.assertTrue(new Franc(5).equals(new Franc(5)));
        Assert.assertFalse(new Franc(5).equals(new Franc(6)));
    }
}
