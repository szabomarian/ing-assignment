package nl.ing.mortgage.affordability.interest.rate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MortgageInterestRateController.class)
class MortgageInterestRateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MortgageInterestRateRepository mortgageInterestRateRepository;

    @Test
    void urlShouldBeCorrect() throws Exception {
        when(mortgageInterestRateRepository.list()).thenReturn(Collections.emptySet());
        this.mockMvc.perform(get("/api/interest-rates")).andDo(print()).andExpect(status().isOk());
    }


}