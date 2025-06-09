package nl.ing.mortgage.affordability;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping("/api/interest-rates")
public class InterestRateController {

    public record InterestRate(int maturityPeriod, float interestRate, LocalDateTime lastUpdate) {}
    @GetMapping
    public Set<InterestRate> get(){
        return Collections.emptySet();
    }
}
