package uebung_10_1;

public class MyCustomNumber extends Number {

    private double value;

    public MyCustomNumber(double value) {
        this.value = value;
    }

    public double getSquare() {
        return this.value * this.value;
    }

    @Override
    public int intValue() {
        return (int) this.value;
    }

    @Override
    public long longValue() {
        return (long) this.value;
    }

    @Override
    public float floatValue() {
        return (float) this.value;
    }

    @Override
    public double doubleValue() {
        return (double) this.value;
    }
}
