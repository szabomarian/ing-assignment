package nl.ing.mortgage.affordability.model;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AffordabilityDecisionTest {
    @Test
    void affordableReturnsEmptyMonthlyAmountAndFalseAffordableFlag() {
        var notAffordableDecision = AffordabilityDecision.notAffordable();
        assertFalse(notAffordableDecision.isAffordable());
        assertEquals(Optional.empty(), notAffordableDecision.getMonthlyAmount());
    }

    @Test
    void affordableReturnsMonthlyAmountAndTrueAffordableFlag() {
        float monthlyAmount = 500F;
        var notAffordableDecision = AffordabilityDecision.affordable(monthlyAmount);
        assertTrue(notAffordableDecision.isAffordable());
        assertEquals(monthlyAmount, notAffordableDecision.getMonthlyAmount().get());
    }

}