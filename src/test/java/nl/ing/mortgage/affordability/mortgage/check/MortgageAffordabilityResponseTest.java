package nl.ing.mortgage.affordability.mortgage.check;

import nl.ing.mortgage.affordability.model.AffordabilityDecision;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MortgageAffordabilityResponseTest {

    @Test
    void feasibleFieldIsCorrectlyMappedWhenMortgageIsAffordable() {
        MortgageAffordabilityResponse mortgageAffordabilityResponse = new MortgageAffordabilityResponse(AffordabilityDecision.affordable(1F));
        assertTrue(mortgageAffordabilityResponse.isFeasible());
    }

    @Test
    void feasibleFieldIsCorrectlyMappedWhenMortgageIsNotAffordable() {
        MortgageAffordabilityResponse mortgageAffordabilityResponse = new MortgageAffordabilityResponse(AffordabilityDecision.notAffordable());
        assertFalse(mortgageAffordabilityResponse.isFeasible());
    }

    @Test
    void monthlyCostFieldIsCorrectlyMappedWhenMortgageIsAffordable() {
        var monthlyCost = 500F;
        MortgageAffordabilityResponse mortgageAffordabilityResponse = new MortgageAffordabilityResponse(AffordabilityDecision.affordable(monthlyCost));
        assertEquals(monthlyCost, mortgageAffordabilityResponse.getMonthlyCost());
    }

    @Test
    void monthlyCostFieldIsCorrectlyMappedWhenMortgageIsNotAffordable() {
        MortgageAffordabilityResponse mortgageAffordabilityResponse = new MortgageAffordabilityResponse(AffordabilityDecision.notAffordable());
        assertEquals(null, mortgageAffordabilityResponse.getMonthlyCost());
    }
}