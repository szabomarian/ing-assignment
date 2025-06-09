package nl.ing.mortgage.affordability;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping("/api/interest-rates")
public class InterestRateController {

    @GetMapping
    public Set<MortgageInterestRate> get(){
        return Collections.emptySet();
    }
}
