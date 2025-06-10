package nl.ing.mortgage.affordability.interest.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.Set;

@RestController
public class MortgageInterestRateController {

    private final MortgageInterestRateRepository mortgageInterestRateRepository;

    @Autowired
    public MortgageInterestRateController(final MortgageInterestRateRepository mortgageInterestRateRepository) {
        this.mortgageInterestRateRepository = mortgageInterestRateRepository;
    }

    @GetMapping(value="/api/interest-rates", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<MortgageInterestRateResponse> get() {
        return this.mortgageInterestRateRepository.list();
    }
}
