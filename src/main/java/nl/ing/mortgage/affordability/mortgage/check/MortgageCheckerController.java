package nl.ing.mortgage.affordability.mortgage.check;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mortgage-check")
public class MortgageCheckerController {

    @PostMapping
    public MortgageAffordabilityResponse check(MortgageAffordabilityRequest mortgageAffordabilityRequest) {
        return new MortgageAffordabilityResponse();
    }
}
