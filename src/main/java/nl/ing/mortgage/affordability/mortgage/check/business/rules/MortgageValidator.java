package nl.ing.mortgage.affordability.mortgage.check.business.rules;

import org.springframework.stereotype.Service;

@Service
public class MortgageValidator {
    private final HomeValueValidator homeValueValidator = new HomeValueValidator();
    private final IncomeValidator incomeValidator = new IncomeValidator();

    public boolean qualifies(Float income, Float homeValue, Float loanAmount) {
        return getHomeValueValidator().qualifies(homeValue, loanAmount) && getIncomeValidator().qualifies(income, loanAmount);
    }

    HomeValueValidator getHomeValueValidator() {
        return this.homeValueValidator;
    }

    IncomeValidator getIncomeValidator() {
        return this.incomeValidator;
    }


}
