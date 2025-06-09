package nl.ing.mortgage.affordability.mortgage.check;

import java.math.BigDecimal;

public class HomeValueValidator {
    public boolean isValid(BigDecimal homeValue, BigDecimal loanAmount) {
        return homeValue.compareTo(loanAmount) >= 0;
    }
}
