package nl.ing.mortgage.affordability.mortgage.check;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnnuityMortgageCalculatorTest {

    @Test
    void test10YearCalculation() {
        var calculator = new AnnuityMortgageCalculator();
        assertEquals(4154.55, calculator.calculate(350000, 7.5F, 10));
    }

    @Test
    void test20YearCalculation() {
        var calculator = new AnnuityMortgageCalculator();
        assertEquals(2819.57, calculator.calculate(350000, 7.5F, 20));
    }

    @Test
    void test30YearCalculation() {
        var calculator = new AnnuityMortgageCalculator();
        assertEquals(1031.21, calculator.calculate(216000, 4F, 30));
    }

}