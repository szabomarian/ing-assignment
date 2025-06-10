package nl.ing.mortgage.affordability.mortgage.check;

import nl.ing.mortgage.affordability.model.AffordabilityDecision;
import nl.ing.mortgage.affordability.model.MortgageInterestRate;
import nl.ing.mortgage.affordability.mortgage.check.business.rules.MortgageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MortgageAffordabilityService {
    private final MortgageValidator mortgageValidator;
    private final AnnuityMortgageCalculator annuityMortgageCalculator;

    @Autowired
    public MortgageAffordabilityService(final MortgageValidator mortgageValidator) {
        this.mortgageValidator = mortgageValidator;
        this.annuityMortgageCalculator = new AnnuityMortgageCalculator();
    }

    public AffordabilityDecision checkMortgageRequest(MortgageAffordabilityRequest mortgageAffordabilityRequest) {
        if (mortgageValidator.qualifies(mortgageAffordabilityRequest.income(), mortgageAffordabilityRequest.homeValue(), mortgageAffordabilityRequest.loanValue())) {
            return AffordabilityDecision.affordable(annuityMortgageCalculator.calculate(
                    mortgageAffordabilityRequest.loanValue(),
                    MortgageInterestRate.byMaturityPeriodInYears(mortgageAffordabilityRequest.maturityPeriodInYears()).get().getInterestRatePercentage(),
                    mortgageAffordabilityRequest.maturityPeriodInYears()
            ));
        } else {
            return AffordabilityDecision.notAffordable();
        }
    }
}
