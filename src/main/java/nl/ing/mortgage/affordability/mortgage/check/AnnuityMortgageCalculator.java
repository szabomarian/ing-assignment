package nl.ing.mortgage.affordability.mortgage.check;


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * I copied this calculator from https://github.com/priyanshum143/Mortgage-Calculator/blob/main/MortgageCalculator.java
 * After some small adjustments to match my requirements, I checked it against the calculation from https://www.hypotheker.nl/en/glossary/mortgage/annuity-mortgage/
 * Also, this stackoverflow page gives the formula of the annuity mortgage: https://stackoverflow.com/questions/1143180/is-there-a-java-api-or-built-in-function-for-solving-annuity-problems
 * The formula is aligned with this implementation, so I consider it correct.
 * Returns the calculation with 2 decimals, always rounding down
 * I did not consider the case of negative interest rate because banks never transferred that benefit to their customers.
 */
public final class AnnuityMortgageCalculator {
    private final static int MONTHS_IN_YEAR = 12;
    private final static float PERCENTAGE = 100F;

    public double calculate(float principal, float annualInterest, int timePeriod) {
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENTAGE;
        int numberOfPayments = timePeriod * MONTHS_IN_YEAR;
        return roundToTwoDecimal((principal * (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments))) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
    }

    private double roundToTwoDecimal(double value) {
        DecimalFormatSymbols dotDecimalSeparatorSymbol = new DecimalFormatSymbols();
        dotDecimalSeparatorSymbol.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat(".00", dotDecimalSeparatorSymbol);
        df.setRoundingMode(RoundingMode.FLOOR);
        return Double.parseDouble(df.format(value));
    }
}