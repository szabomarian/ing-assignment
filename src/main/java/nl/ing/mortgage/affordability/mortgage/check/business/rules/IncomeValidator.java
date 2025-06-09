package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import java.math.BigDecimal;

class IncomeValidator {

    public static final BigDecimal INCOME_MULTIPLIER = BigDecimal.valueOf(4L);

    public boolean isValid(BigDecimal income, BigDecimal loanAmount) {
        return getMaximumBorrowingAmount(income).compareTo(loanAmount) >= 0;
    }

    private static BigDecimal getMaximumBorrowingAmount(BigDecimal income) {
        return income.multiply(INCOME_MULTIPLIER);
    }
}
