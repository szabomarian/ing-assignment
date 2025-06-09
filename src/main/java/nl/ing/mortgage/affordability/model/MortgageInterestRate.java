package nl.ing.mortgage.affordability.model;

import java.time.LocalDateTime;

public enum MortgageInterestRate {

    TEN_YEARS_MORTGAGE(10 * 12, 2.3F, LocalDateTime.of(2024, 10, 10, 0, 0, 0, 0)),
    TWENTY_YEARS_MORTGAGE(20 * 12, 2.8F, LocalDateTime.of(2025, 3, 10, 0, 0, 0, 0)),
    THIRTY_YEARS_MORTGAGE(20 * 12, 3.5F, LocalDateTime.of(2025, 4, 10, 0, 0, 0, 0));

    final int maturityPeriod;
    final float interestRate;
    final LocalDateTime lastUpdate;

    MortgageInterestRate(int maturityPeriodInMonths, float interestRate, LocalDateTime lastUpdate) {
        if (lastUpdate.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Last update can only be in the past");
        }
        this.maturityPeriod = maturityPeriodInMonths;
        this.interestRate = interestRate;
        this.lastUpdate = lastUpdate;
    }

}
