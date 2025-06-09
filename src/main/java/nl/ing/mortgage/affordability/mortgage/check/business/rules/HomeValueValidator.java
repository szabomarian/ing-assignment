package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import java.math.BigDecimal;

class HomeValueValidator {
    public boolean qualifies(BigDecimal homeValue, BigDecimal loanAmount) {
        return homeValue.compareTo(loanAmount) >= 0;
    }
}
