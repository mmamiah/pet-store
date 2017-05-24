package com.mms.rbc.controllers;

import com.mms.rbc.service.PetService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * IntegrationTest for PetController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(locations = "spring-context/restApiApplicationContext.xml")
//@EnableJpaRepositories(basePackages = "com.mms.rbc.dao")
//@DataJpaTest
@Ignore
public class PetControllerTest {
	
	@Mock
	private PetService petServiceMock;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	@Before
	public void setup () {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(webApplicationContext);
		this.mockMvc = builder.build();
	}

	@Test
	public void shouldRetrieveAPet() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/pet/1")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(builder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}
	
}