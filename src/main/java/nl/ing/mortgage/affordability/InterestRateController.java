package nl.ing.mortgage.affordability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/interest-rates")
public class InterestRateController {

    private final MortgageInterestRateRepository mortgageInterestRateRepository;

    @Autowired
    public InterestRateController(final MortgageInterestRateRepository mortgageInterestRateRepository) {
        this.mortgageInterestRateRepository = mortgageInterestRateRepository;
    }

    @GetMapping
    public Set<MortgageInterestRateResponse> get() {
        return this.mortgageInterestRateRepository.list();
    }
}
