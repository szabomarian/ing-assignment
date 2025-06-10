package nl.ing.mortgage.affordability.mortgage.check;

import jakarta.servlet.http.HttpServletRequest;
import nl.ing.mortgage.affordability.model.MortgageInterestRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
        validateMortgageAffordabilityRequest(mortgageAffordabilityRequest);
        return new MortgageAffordabilityResponse(mortgageAffordabilityService.checkMortgageRequest(mortgageAffordabilityRequest));
    }

    //This method is not tested at all and ideally it should be part of a validation service, maybe by using the @Valid annotation
    private static void validateMortgageAffordabilityRequest(MortgageAffordabilityRequest mortgageAffordabilityRequest) {
        if (mortgageAffordabilityRequest.loanValue() <= 0) {
            throw new NegativeNumberException("loanValue");
        }
        if (mortgageAffordabilityRequest.income() <= 0) {
            throw new NegativeNumberException("income");
        }
        if (mortgageAffordabilityRequest.homeValue() <= 0) {
            throw new NegativeNumberException("homeValue");
        }
        if (MortgageInterestRate.byMaturityPeriodInYears(mortgageAffordabilityRequest.maturityPeriodInYears()).isEmpty()) {
            throw new InvalidMaturityPeriodException();
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NegativeNumberException.class)
    @ResponseBody
    Object handleNegativeNumberException(HttpServletRequest req, NegativeNumberException ex) {
        var response = new HashMap<String, String>();
        response.put("error", ex.getFieldName() + " must be a positive number");
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidMaturityPeriodException.class)
    @ResponseBody
    Object handleInvalidMaturityPeriodException(HttpServletRequest req, InvalidMaturityPeriodException ex) {
        var response = new HashMap<String, String>();
        response.put("error", "The maturityPeriodInYears is not valid");
        return response;
    }

}
