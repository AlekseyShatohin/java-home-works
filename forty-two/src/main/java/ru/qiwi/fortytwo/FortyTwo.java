package ru.qiwi.fortytwo;

public class FortyTwo extends Number implements Comparable, TheUltimateQuestionOfLifeTheUniverseAndEverything {

    private final int value = 42;

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return (double) value;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (o instanceof FortyTwo) {
            if (value > ((FortyTwo) o).value) {
                return 1;
            } else if (value < ((FortyTwo) o).value) {
                return -1;
            } else {
                return 0;
            }
        }
        throw new ClassCastException();
    }

    @Override
    public void getAnswer() {
        System.out.println(value);
    }
}
