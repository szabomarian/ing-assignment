package nl.ing.mortgage.affordability.mortgage.check;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mortgage-check")
public class MortgageCheckerController {
    private final MortgageAffordabilityService mortgageAffordabilityService;

    @Autowired
    public MortgageCheckerController(final MortgageAffordabilityService mortgageAffordabilityService) {
        this.mortgageAffordabilityService = mortgageAffordabilityService;
    }

    @PostMapping
    public MortgageAffordabilityResponse check(@RequestBody MortgageAffordabilityRequest mortgageAffordabilityRequest) {
        return new MortgageAffordabilityResponse(mortgageAffordabilityService.checkMortgageRequest(mortgageAffordabilityRequest));
    }
}
