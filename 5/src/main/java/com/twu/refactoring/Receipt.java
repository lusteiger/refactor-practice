package com.twu.refactoring;

public class Receipt {
    private static final int FIXED_CHARGE = 50;
    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final double OFF_PEAK_MULTIPLIER = 1.0;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int PRE_RATE_CHANGE_NON_AC_RATE = 15;
    private static final int POST_RATE_CHANGE_NON_AC_RATE = 12;
    private static final int PRE_RATE_CHANGE_AC_RATE = 20;
    private static final int POST_RATE_CHANGE_AC_RATE = 17;
    private static final double SALES_TAX_RATE = 0.1;

    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        double totalCost = 0;

        // fixed charges
        totalCost += FIXED_CHARGE;

        // taxi charges
        int totalKms = taxi.getTotalKms();
        double peakTimeMultiple = taxi.isPeakTime() ? PEAK_TIME_MULTIPLIER : OFF_PEAK_MULTIPLIER;

        double minPeak = Math.min(RATE_CHANGE_DISTANCE, totalKms) *peakTimeMultiple;
        double maxPeak = Math.max(0, totalKms - RATE_CHANGE_DISTANCE) *peakTimeMultiple;

        if(taxi.isAirConditioned()) {
            totalCost +=  PRE_RATE_CHANGE_AC_RATE * minPeak;
            totalCost +=  POST_RATE_CHANGE_AC_RATE * maxPeak;
        } else {
            totalCost += PRE_RATE_CHANGE_NON_AC_RATE * minPeak;
            totalCost += POST_RATE_CHANGE_NON_AC_RATE * maxPeak;
        }

        return totalCost * (1 + SALES_TAX_RATE);
    }
}
