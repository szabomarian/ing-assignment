package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
class HomeValueValidator {
    public boolean qualifies(BigDecimal homeValue, BigDecimal loanAmount) {
        return homeValue.compareTo(loanAmount) >= 0;
    }
}
