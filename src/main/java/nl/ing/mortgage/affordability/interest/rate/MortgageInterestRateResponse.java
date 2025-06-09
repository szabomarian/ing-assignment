package nl.ing.mortgage.affordability.interest.rate;

import java.time.LocalDateTime;

public record MortgageInterestRateResponse(int maturityPeriod, float interestRate, LocalDateTime lastUpdate) {
}
