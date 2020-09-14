package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        return countEvenOrOdd("Even", numbers);
    }

    public int countOdd() {
        return countEvenOrOdd("Odd", numbers);
    }

    public int countPositive() {
        return countEvenOrOdd("Positive", numbers);
    }

    public int countNegative() {
        return countEvenOrOdd("Negative", numbers);
    }

    public int countEvenOrOdd(String sign, int[] numbers) {
        int count = 0;

        switch (sign) {
            case "Even":
                for (int number : numbers) {
                    if (number % 2 == 0) count++;
                }
                break;
            case "Odd":
                for (int number : numbers) {
                    if (number % 2 == 1) count++;
                }
                break;
            case "Positive":
                for (int number : numbers) {
                    if (number >= 0) count++;
                }
                break;
            case "Negative":
                for (int number : numbers) {
                    if (number < 0) count++;
                }
                break;
        }


        return count;


    }


}
