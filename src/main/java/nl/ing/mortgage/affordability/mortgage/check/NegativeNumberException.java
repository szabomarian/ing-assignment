package nl.ing.mortgage.affordability.mortgage.check;

import lombok.Getter;

@Getter
public class NegativeNumberException extends RuntimeException {
    private final String fieldName;

    public NegativeNumberException(String fieldName) {
        this.fieldName = fieldName;
    }
}
