package nl.ing.mortgage.affordability.interest.rate;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MortgageInterestRateRepositoryTest {

    private final MortgageInterestRateRepository mortgageInterestRateRepository = new MortgageInterestRateRepository();

    @Test
    public void shouldReturnInterestRateList() {
        Set<MortgageInterestRateResponse> interestRates = mortgageInterestRateRepository.list();
        assertNotNull(interestRates);
        assertFalse(interestRates.isEmpty());
    }

}