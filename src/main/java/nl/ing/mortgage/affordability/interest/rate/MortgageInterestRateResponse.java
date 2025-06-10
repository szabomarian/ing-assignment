package nl.ing.mortgage.affordability.interest.rate;

import java.time.LocalDateTime;

public record MortgageInterestRateResponse(int maturityPeriodInYears, float interestRate, LocalDateTime lastUpdate) {
}
