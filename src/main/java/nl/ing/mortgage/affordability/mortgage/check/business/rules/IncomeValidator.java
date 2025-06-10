package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import org.springframework.stereotype.Service;

@Service
class IncomeValidator {

    public static final float INCOME_MULTIPLIER = 4L;

    public boolean qualifies(Float income, Float loanAmount) {
        return getMaximumBorrowingAmount(income) >= loanAmount;
    }

    private static float getMaximumBorrowingAmount(float income) {
        return income * INCOME_MULTIPLIER;
    }
}
