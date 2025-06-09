package nl.ing.mortgage.affordability;

import java.time.LocalDateTime;

public record MortgageInterestRateResponse(int maturityPeriod, float interestRate, LocalDateTime lastUpdate) {
}
