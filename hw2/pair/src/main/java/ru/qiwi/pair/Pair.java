package ru.qiwi.pair;

public class Pair<One, Two> {

    private final One first;

    private final Two second;

    private Pair(One first, Two second) {
        this.first = first;
        this.second = second;
    }


    public static <One, Two> Pair<One, Two> of(One first, Two second) {
        return new Pair<>(first, second);

    }

    public One getFirst() {
        return first;
    }

    public Two getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) {
            return first == ((Pair<?, ?>) obj).getFirst() && second == ((Pair<?, ?>) obj).getSecond();
        } else {
            return false;
        }
    }
}
