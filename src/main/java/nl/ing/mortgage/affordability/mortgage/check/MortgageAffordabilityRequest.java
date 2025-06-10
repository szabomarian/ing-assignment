package nl.ing.mortgage.affordability.mortgage.check;

public record MortgageAffordabilityRequest(
        Float income,
        int maturityPeriodInYears,
        Float loanValue,
        Float homeValue
) {
}
