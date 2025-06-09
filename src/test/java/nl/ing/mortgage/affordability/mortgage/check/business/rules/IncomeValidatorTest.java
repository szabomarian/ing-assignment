package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static nl.ing.mortgage.affordability.mortgage.check.business.rules.IncomeValidator.INCOME_MULTIPLIER;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IncomeValidatorTest {
    private final IncomeValidator incomeValidator = new IncomeValidator();

    @ParameterizedTest
    @MethodSource("getQualifyingIncomesAndLoanedAmounts")
    void testPositiveScenarios(BigDecimal income, BigDecimal loanAmount) {
        assertTrue(incomeValidator.qualifies(income, loanAmount));
    }

    @ParameterizedTest
    @MethodSource("getNonQualifyingIncomesAndLoanedAmounts")
    void testNegativeScenarios(BigDecimal income, BigDecimal loanAmount) {
        assertFalse(incomeValidator.qualifies(income, loanAmount));
    }

    private static Stream<Arguments> getQualifyingIncomesAndLoanedAmounts() {
        BigDecimal income = new BigDecimal("40000.00");
        return Stream.of(
                Arguments.of(income, INCOME_MULTIPLIER.multiply(income)),
                Arguments.of(income, INCOME_MULTIPLIER.multiply(income).subtract(BigDecimal.ONE)),
                Arguments.of(income, income.add(BigDecimal.ONE))
        );
    }

    private static Stream<Arguments> getNonQualifyingIncomesAndLoanedAmounts() {
        BigDecimal income = new BigDecimal("40000.00");
        return Stream.of(
                Arguments.of(income, INCOME_MULTIPLIER.add(BigDecimal.ONE).multiply(income)),
                Arguments.of(income, INCOME_MULTIPLIER.multiply(income).add(BigDecimal.ONE))
        );
    }

}