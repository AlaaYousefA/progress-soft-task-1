package com.progressoft.samples;

public class Money {
    public static final Money Zero = new Money(0);
    public static final Money OnePiaster = new Money(0.01);
    public static final Money FivePiasters = new Money(0.05);
    public static final Money TenPiasters = new Money(0.10);
    public static final Money TwentyFivePiasters = new Money(0.25);
    public static final Money FiftyPiasters = new Money(0.50);
    public static final Money OneDinar = new Money(1.00);
    public static final Money FiveDinars = new Money(5.00);
    public static final Money TenDinars = new Money(10.00);
    public static final Money TwentyDinars = new Money(20.00);
    public static final Money FiftyDinars = new Money(50.00);

    private final double value;

    private Money(double value) {
        this.value = Math.round(value * 100.0) / 100.0;
    }

    public double amount() {
        return this.value;
    }

    public Money times(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }
        if (count == 0) {
            return Zero;
        }
        return new Money(this.value * count);
    }

    public static Money sum(Money... items) {
        double total = 0.0;
        for (Money item : items) {
            if (item != null) {
                total += item.value;
            }
        }
        return new Money(total);
    }

    public Money plus(Money other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot add null");
        }
        return new Money(this.value + other.value);
    }

    public Money minus(Money other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot subtract null");
        }
        double result =  this.value - other.value;
        if (result < 0) {
            throw new IllegalArgumentException("Resulting amount cannot be negative");
        }

        return new Money(result);
    }

    @Override
    public String toString() {
        return String.format("%.2f", this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Money)) return false;
        Money other = (Money) obj;
        return Double.compare(this.value, other.value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(this.value);
    }

}
