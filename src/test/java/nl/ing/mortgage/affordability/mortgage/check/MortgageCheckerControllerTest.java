package nl.ing.mortgage.affordability.mortgage.check;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MortgageCheckerController.class)
class MortgageCheckerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void urlShouldBeCorrect() throws Exception {
        var anyValidRequestAsJson = """
                {
                    "income":50000,
                    "maturityPeriod": 20,
                    "loanValue": 100000,
                    "homeValue": 150000
                }
                """;

        this.mockMvc.perform(post("/api/mortgage-check")
                .contentType(APPLICATION_JSON)
                .content(anyValidRequestAsJson)
        ).andDo(print()).andExpect(status().isOk());
    }


}