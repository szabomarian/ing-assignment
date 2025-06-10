package nl.ing.mortgage.affordability.mortgage.check;

import nl.ing.mortgage.affordability.model.AffordabilityDecision;
import nl.ing.mortgage.affordability.mortgage.check.business.rules.MortgageValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MortgageAffordabilityServiceTest {

    @Mock
    private MortgageValidator mortgageValidator;

    @InjectMocks
    private MortgageAffordabilityService mortgageAffordabilityService;

    @Test
    void nonAffordableMortgageRequestShouldReturnNonAffordableDecision() {
        var nonAffordableMortgageRequest = new MortgageAffordabilityRequest(1F, 120, 10F, 1F);
        when(mortgageValidator.qualifies(any(), any(), any())).thenReturn(false);
        assertEquals(AffordabilityDecision.notAffordable(), mortgageAffordabilityService.checkMortgageRequest(nonAffordableMortgageRequest));
    }

    @Test
    void affordableMortgageRequestShouldReturnAffordableDecision() {
        var nonAffordableMortgageRequest = new MortgageAffordabilityRequest(1F, 10, 10F, 1F);
        when(mortgageValidator.qualifies(any(), any(), any())).thenReturn(true);
        AffordabilityDecision affordabilityDecision = mortgageAffordabilityService.checkMortgageRequest(nonAffordableMortgageRequest);
        assertNotNull(affordabilityDecision);
        assertTrue(affordabilityDecision.isAffordable());
        assertTrue(affordabilityDecision.getMonthlyAmount().isPresent());
    }
}