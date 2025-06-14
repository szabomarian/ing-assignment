package nl.ing.mortgage.affordability.interest.rate;

import nl.ing.mortgage.affordability.model.MortgageInterestRate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MortgageInterestRateRepository {
    private final Set<MortgageInterestRateResponse> interestRates;

    MortgageInterestRateRepository() {
        this.interestRates = Arrays.stream(MortgageInterestRate.values()).map(mortgageInterestRate -> new MortgageInterestRateResponse(
                mortgageInterestRate.getMaturityPeriodInYears(),
                mortgageInterestRate.getInterestRatePercentage(),
                mortgageInterestRate.getLastUpdate()
        )).collect(Collectors.toUnmodifiableSet());
    }

    public Set<MortgageInterestRateResponse> list() {
        return this.interestRates;
    }
}
