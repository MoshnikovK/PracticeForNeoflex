package ru.neoflex.practice.FunctionalTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.neoflex.practice.controller.CalculateController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculateController.class)
public class CalcControllerFunctionalTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void getAllResult() throws Exception {
        mockMvc.perform(get("/api/calc/all")).andExpect(status().isNoContent()).andDo(print());
    }
    @Test
    void getPlusTest() throws  Exception{
        int a = 5;
        int b = 6;
        mockMvc.perform(get("/api/calc/plus/{a}/{b}",a,b)).andExpect(status().isCreated()).andDo(print());
    }
    @Test
    void getMinusTest() throws  Exception{
        int a = 10;
        int b = 6;
        mockMvc.perform(get("/api/calc/minus/{a}/{b}",a,b)).andExpect(status().isCreated()).andDo(print());
    }
}
