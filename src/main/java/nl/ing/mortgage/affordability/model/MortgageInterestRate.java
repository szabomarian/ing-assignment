package nl.ing.mortgage.affordability.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

@Getter
public enum MortgageInterestRate {

    TEN_YEARS_MORTGAGE(10, 2.3F, LocalDateTime.of(2024, 10, 10, 0, 0, 0, 0)),
    TWENTY_YEARS_MORTGAGE(20, 2.8F, LocalDateTime.of(2025, 3, 10, 0, 0, 0, 0)),
    THIRTY_YEARS_MORTGAGE(30, 3.5F, LocalDateTime.of(2025, 4, 10, 0, 0, 0, 0));

    final int maturityPeriodInYears;
    final float interestRatePercentage;
    final LocalDateTime lastUpdate;

    MortgageInterestRate(int maturityPeriodInYears, float interestRatePercentage, LocalDateTime lastUpdate) {
        if (lastUpdate.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("Last update can only be in the past");
        }
        if (maturityPeriodInYears < 0) {
            throw new IllegalArgumentException("The maturity period must be greater than zero");
        }
        this.maturityPeriodInYears = maturityPeriodInYears;
        this.interestRatePercentage = interestRatePercentage;
        this.lastUpdate = lastUpdate;
    }

    public static Optional<MortgageInterestRate> byMaturityPeriodInYears(int maturityPeriodInYears) {
        return Stream.of(MortgageInterestRate.values())
                .filter(mortgageInterestRate -> mortgageInterestRate.getMaturityPeriodInYears() == maturityPeriodInYears)
                .findFirst();
    }

}
