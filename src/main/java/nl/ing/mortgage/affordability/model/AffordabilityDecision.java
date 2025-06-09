package nl.ing.mortgage.affordability.model;

import lombok.EqualsAndHashCode;

import java.util.Optional;

@EqualsAndHashCode
public class AffordabilityDecision {
    private final boolean affordable;
    private final Float monthlyAmount;

    private AffordabilityDecision(boolean isAffordable, Float monthlyAmount) {
        this.affordable = isAffordable;
        this.monthlyAmount = monthlyAmount;
    }

    public static AffordabilityDecision affordable(Float monthlyAmount) {
        return new AffordabilityDecision(true, monthlyAmount);
    }

    public static AffordabilityDecision notAffordable() {
        return new AffordabilityDecision(false, null);
    }

    public boolean isAffordable() {
        return this.affordable;
    }

    public Optional<Float> getMonthlyAmount() {
        return Optional.ofNullable(this.monthlyAmount);
    }

}
