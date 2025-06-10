package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import org.springframework.stereotype.Service;

@Service
class HomeValueValidator {
    public boolean qualifies(Float homeValue, Float loanAmount) {
        return homeValue.compareTo(loanAmount) >= 0;
    }
}
