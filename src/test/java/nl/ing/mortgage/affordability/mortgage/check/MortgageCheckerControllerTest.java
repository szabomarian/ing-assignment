package nl.ing.mortgage.affordability.mortgage.check;

import nl.ing.mortgage.affordability.model.AffordabilityDecision;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MortgageCheckerController.class)
class MortgageCheckerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MortgageAffordabilityService affordabilityService;

    @Test
    void urlShouldBeCorrect() throws Exception {
        var anyValidRequestAsJson = """
                {
                    "income":50000,
                    "maturityPeriodInYears": 20,
                    "loanValue": 100000,
                    "homeValue": 150000
                }
                """;
        when(affordabilityService.checkMortgageRequest(any())).thenReturn(AffordabilityDecision.notAffordable());
        this.mockMvc.perform(post("/api/mortgage-check")
                .contentType(APPLICATION_JSON)
                .content(anyValidRequestAsJson)
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void affordabilityServiceShouldBeCalled() throws Exception {
        var anyValidRequestAsJson = """
                {
                    "income":50000,
                    "maturityPeriodInYears": 20,
                    "loanValue": 100000,
                    "homeValue": 150000
                }
                """;
        when(affordabilityService.checkMortgageRequest(any())).thenReturn(AffordabilityDecision.notAffordable());
        this.mockMvc.perform(post("/api/mortgage-check")
                .contentType(APPLICATION_JSON)
                .content(anyValidRequestAsJson)
        );
        verify(affordabilityService, times(1)).checkMortgageRequest(any());
    }


}