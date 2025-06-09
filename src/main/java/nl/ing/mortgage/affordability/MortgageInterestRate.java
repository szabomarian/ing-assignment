package nl.ing.mortgage.affordability;

import java.time.LocalDateTime;

public record MortgageInterestRate(int maturityPeriod, float interestRate, LocalDateTime lastUpdate) {
}
