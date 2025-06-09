package nl.ing.mortgage.affordability.mortgage.check;

import nl.ing.mortgage.affordability.model.AffordabilityDecision;
import nl.ing.mortgage.affordability.mortgage.check.business.rules.MortgageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MortgageAffordabilityService {
    private final MortgageValidator mortgageValidator;

    @Autowired
    public MortgageAffordabilityService(final MortgageValidator mortgageValidator) {
        this.mortgageValidator = mortgageValidator;
    }

    public AffordabilityDecision checkMortgageRequest(MortgageAffordabilityRequest mortgageAffordabilityRequest) {
        if (mortgageValidator.qualifies(mortgageAffordabilityRequest.income(), mortgageAffordabilityRequest.homeValue(), mortgageAffordabilityRequest.loanValue())) {
            return AffordabilityDecision.affordable(0F);
        } else {
            return AffordabilityDecision.notAffordable();
        }
    }
}
