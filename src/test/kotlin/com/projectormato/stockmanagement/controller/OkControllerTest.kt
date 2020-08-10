package com.projectormato.stockmanagement.controller;

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.util.*


@SpringBootTest
@AutoConfigureMockMvc
internal class HelloControllerTest {

    @Autowired
    private var mockMvc: MockMvc? = null
    @Autowired
    var webApplicationContext: WebApplicationContext? = null

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext!!).build()
    }

    @Test
    fun okTest() {
        val mvcResult = mockMvc!!.perform(MockMvcRequestBuilders.get("/ok"))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        Assertions.assertEquals(Objects.requireNonNull(mvcResult.modelAndView)!!.viewName, "ok")
    }
}