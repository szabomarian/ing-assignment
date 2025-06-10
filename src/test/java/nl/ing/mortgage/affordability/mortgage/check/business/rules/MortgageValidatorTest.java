package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MortgageValidatorTest {

    @Spy
    private MortgageValidator mortgageValidator;

    @Mock
    private IncomeValidator incomeValidator;

    @Mock
    private HomeValueValidator homeValueValidator;

    @Test
    void qualifyingIncomeAndQualifyingHomeValueForMortgageShouldReturnTrue() {
        when(mortgageValidator.getHomeValueValidator()).thenReturn(homeValueValidator);
        when(mortgageValidator.getIncomeValidator()).thenReturn(incomeValidator);
        when(incomeValidator.qualifies(any(), any())).thenReturn(true);
        when(homeValueValidator.qualifies(any(), any())).thenReturn(true);
        assertTrue(mortgageValidator.qualifies(10F, 1F, 1F));
    }

    @Test
    void nonQualifyingIncomeAndQualifyingHomeValueForMortgageShouldReturnFalse() {
        when(mortgageValidator.getHomeValueValidator()).thenReturn(homeValueValidator);
        when(mortgageValidator.getIncomeValidator()).thenReturn(incomeValidator);
        when(incomeValidator.qualifies(any(), any())).thenReturn(false);
        when(homeValueValidator.qualifies(any(), any())).thenReturn(true);
        assertFalse(mortgageValidator.qualifies(10F, 1F, 1F));
    }

    @Test
    void qualifyingIncomeAndNonQualifyingHomeValueForMortgageShouldReturnFalse() {
        when(mortgageValidator.getHomeValueValidator()).thenReturn(homeValueValidator);
        assertFalse(mortgageValidator.qualifies(10F, 1F, 1F));
        verify(mortgageValidator, times(0)).getIncomeValidator();
    }

    @Test
    void nonQualifyingIncomeAndNonQualifyingHomeValueForMortgageShouldReturnFalse() {
        when(mortgageValidator.getHomeValueValidator()).thenReturn(homeValueValidator);
        when(homeValueValidator.qualifies(any(), any())).thenReturn(false);
        assertFalse(mortgageValidator.qualifies(10F, 1F, 1F));
        verify(mortgageValidator, times(0)).getIncomeValidator();
    }
}