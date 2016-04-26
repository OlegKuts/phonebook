package com.lardi.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.security.Principal;

import com.lardi.domain.User;
import com.lardi.repository.UserRepository;
import com.lardi.utils.TestUtils;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	@Mock
	private UserRepository userRepositoryMock;

	@InjectMocks
	private UserServiceImpl userService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findByLoginTest(){
		User testUser = TestUtils.getValidTestUser();
		Principal principal = mock(Principal.class);
		when(principal.getName()).thenReturn(testUser.getName());
		when(userRepositoryMock.findByLogin(testUser.getName())).thenReturn(testUser);
		User user = userService.findByLogin(principal);
		assertThat(user, is(equalTo(testUser)));
		verify(userRepositoryMock, times(1)).findByLogin(testUser.getName());
		verifyNoMoreInteractions(userRepositoryMock);
	}
	
	@Test
	public void registerUserTest(){
		User testUser = TestUtils.getValidTestUser();
		testUser.setEnabled(false);
		when(userRepositoryMock.save(any(User.class))).thenReturn(testUser);
		userService.registerUser(testUser);
		assertThat(testUser.isEnabled(), is(true));
		verify(userRepositoryMock, times(1)).save(testUser);
		verifyNoMoreInteractions(userRepositoryMock);
	}
}
