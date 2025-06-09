package nl.ing.mortgage.affordability.mortgage.check;

import java.math.BigDecimal;

public record MortgageAffordabilityRequest(
        BigDecimal income,
        int maturityPeriod,
        BigDecimal loanValue,
        BigDecimal homeValue
) {
}
