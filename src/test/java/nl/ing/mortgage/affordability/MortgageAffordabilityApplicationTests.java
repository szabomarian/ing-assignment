package nl.ing.mortgage.affordability;

import nl.ing.mortgage.affordability.interest.rate.InterestRateController;
import nl.ing.mortgage.affordability.mortgage.check.MortgageCheckerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MortgageAffordabilityApplicationTests {

    @Autowired
    private InterestRateController interestRateController;

    @Autowired
    private MortgageCheckerController mortgageCheckerController;

    @Test
    void interestRateControllerIsInitialized() {
        assertNotNull(interestRateController);
    }

    @Test
    void mortgageCheckerControllerIsInitialized() {
        assertNotNull(mortgageCheckerController);
    }

}
