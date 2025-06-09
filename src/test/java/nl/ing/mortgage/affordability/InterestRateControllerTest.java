package nl.ing.mortgage.affordability;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(InterestRateController.class)
class InterestRateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void urlShouldBeCorrect() throws Exception {
        this.mockMvc.perform(get("/api/interest-rates")).andDo(print()).andExpect(status().isOk());
    }


}