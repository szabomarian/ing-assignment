package nl.ing.mortgage.affordability.mortgage.check;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MortgageCheckerController.class)
class MortgageCheckerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void urlShouldBeCorrect() throws Exception {
        this.mockMvc.perform(post("/api/mortgage-check")).andDo(print()).andExpect(status().isOk());
    }

}