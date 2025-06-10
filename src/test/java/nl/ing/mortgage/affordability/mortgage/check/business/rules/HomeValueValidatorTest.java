package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HomeValueValidatorTest {

    private final HomeValueValidator validator = new HomeValueValidator();

    @Test
    void shouldReturnFalseWhenHomeValueIsGreaterThanTheLoanAmount() {
        assertFalse(validator.qualifies(1F, 10F));
    }

    @Test
    void shouldReturnTrueWhenHomeValueIsSmallerThanTheLoanAmount() {
        assertTrue(validator.qualifies(10F, 1F));
    }

    @Test
    void shouldReturnTrueWhenHomeValueEqualsTheLoanAmount() {
        assertTrue(validator.qualifies(10F, 10F));
    }
}