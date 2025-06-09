package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
class IncomeValidator {

    public static final BigDecimal INCOME_MULTIPLIER = BigDecimal.valueOf(4L);

    public boolean qualifies(BigDecimal income, BigDecimal loanAmount) {
        return getMaximumBorrowingAmount(income).compareTo(loanAmount) >= 0;
    }

    private static BigDecimal getMaximumBorrowingAmount(BigDecimal income) {
        return income.multiply(INCOME_MULTIPLIER);
    }
}
