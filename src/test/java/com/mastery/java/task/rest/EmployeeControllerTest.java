package com.mastery.java.task.rest;

import com.mastery.java.task.config.AppConfiguration;
import com.mastery.java.task.config.DataBaseConfig;
import com.mastery.java.task.config.WebConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        WebConfig.class, AppConfiguration.class, DataBaseConfig.class
})
@WebAppConfiguration
public class EmployeeControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void main() throws Exception {
        mvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/pages/index.jsp"))
                .andExpect(model().attributeHasNoErrors("empJSP"))
                .andExpect(view().name("index"))
                .andReturn();
    }

    @Test
    void checkAll() throws Exception {
        mvc.perform(get("/check_all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasNoErrors())
                .andExpect(forwardedUrl("/WEB-INF/pages/page2.jsp"))
                .andExpect(view().name("page2"))
                .andReturn();

    }

}
