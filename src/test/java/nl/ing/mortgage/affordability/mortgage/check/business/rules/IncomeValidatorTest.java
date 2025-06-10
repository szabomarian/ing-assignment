package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nl.ing.mortgage.affordability.mortgage.check.business.rules.IncomeValidator.INCOME_MULTIPLIER;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IncomeValidatorTest {
    private final IncomeValidator incomeValidator = new IncomeValidator();

    @ParameterizedTest
    @MethodSource("getQualifyingIncomesAndLoanedAmounts")
    void testPositiveScenarios(float income, float loanAmount) {
        assertTrue(incomeValidator.qualifies(income, loanAmount));
    }

    @ParameterizedTest
    @MethodSource("getNonQualifyingIncomesAndLoanedAmounts")
    void testNegativeScenarios(float income, float loanAmount) {
        assertFalse(incomeValidator.qualifies(income, loanAmount));
    }

    private static Stream<Arguments> getQualifyingIncomesAndLoanedAmounts() {
        float income = 40000.00F;
        return Stream.of(
                Arguments.of(income, INCOME_MULTIPLIER * income),
                Arguments.of(income, INCOME_MULTIPLIER * income - 1F),
                Arguments.of(income, income + 1F)
        );
    }

    private static Stream<Arguments> getNonQualifyingIncomesAndLoanedAmounts() {
        float income = 40000.00F;
        return Stream.of(
                Arguments.of(income, (INCOME_MULTIPLIER + 1F) * income),
                Arguments.of(income, INCOME_MULTIPLIER * income + 1F)
        );
    }

}