package com.luxoft.spring.mvc.example12;

import com.luxoft.spring.mvc.example12.controller.OrdersController;
import com.luxoft.spring.mvc.example12.domain.Order;
import com.luxoft.spring.mvc.example12.domain.OrdersRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(OrdersController.class)
@SuppressWarnings("all")
public class Example12ApplicationTests {

    @Autowired
    private MockMvc mvc;                    // this is special mock environment

    @MockBean
    private OrdersRepository repo;          // this is mock or OrdersRepository

    @Test
    public void testThatAllOrderFieldsAreAtPage() throws Exception {
        // set up mock
        given(repo.get("1"))
            .willReturn(new Order("1", "Luxoft", 300.0));       // return special object by id=1

        mvc.perform(get("/order").param("id", "1"))             // builds request
            .andExpect(status().isOk())                         // checks status code
            .andExpect(content().string(
                Matchers.containsString("Luxoft")               // checks that page contains "Luxoft" string
            ));
        // TODO: test page title, order amount and ID
    }

}
