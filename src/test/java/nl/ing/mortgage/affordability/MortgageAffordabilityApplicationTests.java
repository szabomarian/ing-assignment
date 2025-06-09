package nl.ing.mortgage.affordability;

import nl.ing.mortgage.affordability.interest.rate.MortgageInterestRateController;
import nl.ing.mortgage.affordability.mortgage.check.MortgageCheckerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MortgageAffordabilityApplicationTests {

    @Autowired
    private MortgageInterestRateController mortgageInterestRateController;

    @Autowired
    private MortgageCheckerController mortgageCheckerController;

    @Test
    void interestRateControllerIsInitialized() {
        assertNotNull(mortgageInterestRateController);
    }

    @Test
    void mortgageCheckerControllerIsInitialized() {
        assertNotNull(mortgageCheckerController);
    }

}
