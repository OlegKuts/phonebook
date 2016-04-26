package com.lardi.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.web.servlet.View;

import com.lardi.domain.User;
import com.lardi.service.UserService;
import com.lardi.utils.TestUtils;


@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {
	@Mock
	private UserService userServiceMock;

	@Mock
	private View mockView;

	@InjectMocks
	private RegistrationController controller;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = standaloneSetup(controller).setSingleView(mockView).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void showRegistration() throws Exception {
		mockMvc.perform(get("/registration")).andExpect(status().isOk()).andExpect(view().name("registration"));
	}

	@Test
	public void doValidRegister() throws Exception {
		doNothing().when(userServiceMock).registerUser(any(User.class));
		mockMvc.perform(post("/registration").params(TestUtils.getValidUserParams())).andExpect(status().isOk())
				.andExpect(view().name("redirect:/login?successful"));
		verify(userServiceMock, times(1)).registerUser(any(User.class));
		verifyNoMoreInteractions(userServiceMock);
	}
	
	@Test
	public void doInvalidRegister() throws Exception {
		User invalidUser = TestUtils.getInvalidTestUser();
		doNothing().when(userServiceMock).registerUser(any(User.class));
		mockMvc.perform(post("/registration").param("login", invalidUser.getLogin())).andExpect(status().isOk())
				.andExpect(view().name("registration"));
		verify(userServiceMock, times(0)).registerUser(any(User.class));
		verifyZeroInteractions(userServiceMock);
	}
}
