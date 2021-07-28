package com.example.demo.business.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import com.example.demo.business.UserBusiness;
import com.example.demo.controller.UserController;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserApiTest01_01_Autowired {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	UserBusiness userBusiness;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void getUsers_success() throws Exception {
		// Arrange
		String username = "my-username";
		String expectedResponse = "any-response";
		when(userBusiness.getBusinessName(any())).thenReturn(expectedResponse);

		// Action
		RequestBuilder request = MockMvcRequestBuilders.get("/users?username=" + username);
		MvcResult result = mockMvc.perform(request) //
				.andExpect(status().is2xxSuccessful()) //
				.andReturn();

		// Assert
		MockHttpServletResponse response = result.getResponse();
		assertEquals(expectedResponse, response.getContentAsString());
	}

	@Test
	public void getUsers_username_is_missing() throws Exception {
		// Arrange
		int expectedStatus = 400;
		String expectedResponse = "Required request parameter 'username' for method parameter type String is not present";

		// Action
		RequestBuilder request = MockMvcRequestBuilders.get("/users");
		MvcResult result = mockMvc.perform(request).andExpect(status()//
				.is4xxClientError())//
				.andReturn();

		// Assert
		MockHttpServletResponse response = result.getResponse();
		assertEquals(expectedStatus, response.getStatus());
		assertEquals(expectedResponse, response.getErrorMessage());
	}

	@Test(expected = NestedServletException.class)
	public void getUsers_username_Exception() throws Exception {
		// Arrange
		when(userBusiness.getBusinessName(any())).thenThrow(RuntimeException.class);

		// Action
		RequestBuilder request = MockMvcRequestBuilders.get("/users?username=any-name");
		mockMvc.perform(request)//
				.andExpect(status().is5xxServerError())//
				.andReturn();

	}
}
