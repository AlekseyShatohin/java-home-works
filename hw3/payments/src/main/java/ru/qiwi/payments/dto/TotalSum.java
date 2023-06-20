package ru.qiwi.payments.dto;

public class TotalSum {
    private final double from;

    private final double to;

    public TotalSum (
            double from,
            double to
    ) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }
}
