package com.in6k.mypal;

import com.in6k.mypal.controller.AdminController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;



//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = AdminController.class)
public class AdminControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new AdminController()).build();
    }

    @Test
    public void shouldReturnUserList() throws Exception{
        mockMvc.perform(get("/users")).andExpect(status().isOk()).andExpect(forwardedUrl("/user/list")).andExpect(model().attributeExists("userlist"));
    }
}
