package nl.ing.mortgage.affordability.mortgage.check;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import nl.ing.mortgage.affordability.model.AffordabilityDecision;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Getter
public class MortgageAffordabilityResponse {
    private final boolean feasible;
    private final Float monthlyCost;

    private MortgageAffordabilityResponse(boolean feasible, Float monthlyCost) {
        this.feasible = feasible;
        this.monthlyCost = monthlyCost;
    }

    public MortgageAffordabilityResponse(AffordabilityDecision affordabilityDecision) {
        this(
                affordabilityDecision.isAffordable(),
                affordabilityDecision.getMonthlyAmount().orElse(null)
        );
    }
}
