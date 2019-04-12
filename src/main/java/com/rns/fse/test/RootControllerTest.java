package com.rns.fse.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;
import com.rns.fse.FseApplication;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FseApplication.class)
@WebIntegrationTest
public class RootControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
		@Before
		public void setUp(){
			this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		}

	@Test
	public void testGetSchoolDetails() {
		
		String fetchSchoolUrl = new StringBuilder().append("/").append("getAllSchoolDetails").toString();
		try {
			mockMvc.perform(get(fetchSchoolUrl))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andDo(print())
			.andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetRequestDetails() {
		String fetchRequestUrl = new StringBuilder().append("/").append("getAllRequestDetails").toString();
		try {
			mockMvc.perform(get(fetchRequestUrl))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andDo(print())
			.andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetOrgzanitaionDetails() {
		String fetchOrganizationUrl = new StringBuilder().append("/").append("getAllOrganizationDetails").toString();
		try {
			mockMvc.perform(get(fetchOrganizationUrl))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andDo(print())
			.andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetEmployeeDetails() {
		String fetchEmployeeUrl = new StringBuilder().append("/").append("getAllEmployeeDetails").toString();
		try {
			mockMvc.perform(get(fetchEmployeeUrl))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andDo(print())
			.andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
