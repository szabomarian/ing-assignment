package nl.ing.mortgage.affordability.mortgage.check;

public record MortgageAffordabilityRequest(
        Float income,
        int maturityPeriod,
        Float loanValue,
        Float homeValue
) {
}
