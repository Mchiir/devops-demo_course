package com.rca.demo_course.controller;

import com.rca.demo_course.service.MyModulusService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MyModulusController.class)
@DisplayName("MyModulus Controller Integration Tests")
public class MyModulusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MyModulusService myModulusService;

    @Test
    @DisplayName("Modulus endpoint should return correct result")
    void testModulusEndpoint() throws Exception {
        when(myModulusService.modulus(5.0, 2.0)).thenReturn(1.0);

        mockMvc.perform(get("/api/modulus/mod")
                .param("dividend", "5.0")
                .param("divisor", "2.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1.0))
                .andExpect(jsonPath("$.operation").value("modulus"));
    }
}
