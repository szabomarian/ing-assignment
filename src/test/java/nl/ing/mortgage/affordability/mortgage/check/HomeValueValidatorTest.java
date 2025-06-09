package nl.ing.mortgage.affordability.mortgage.check;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HomeValueValidatorTest {

    private final HomeValueValidator validator = new HomeValueValidator();

    @Test
    void shouldReturnFalseWhenHomeValueIsGreaterThanTheLoanAmount() {
        assertFalse(validator.isValid(BigDecimal.ONE, BigDecimal.TEN));
    }

    @Test
    void shouldReturnTrueWhenHomeValueIsSmallerThanTheLoanAmount() {
        assertTrue(validator.isValid(BigDecimal.TEN, BigDecimal.ONE));
    }

    @Test
    void shouldReturnTrueWhenHomeValueEqualsTheLoanAmount() {
        assertTrue(validator.isValid(BigDecimal.TEN, BigDecimal.TEN));
    }
}