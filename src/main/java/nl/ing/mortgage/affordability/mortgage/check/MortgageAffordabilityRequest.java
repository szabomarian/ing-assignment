package nl.ing.mortgage.affordability.mortgage.check;

public record MortgageAffordabilityRequest(
        int income,
        int maturityPeriod,
        long loanValue,
        long homeValue
) {
}
