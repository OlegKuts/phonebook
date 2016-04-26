package com.lardi.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.View;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.lardi.domain.Note;
import com.lardi.domain.User;
import com.lardi.service.UserService;
import com.lardi.utils.TestUtils;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class NotesRestControllerTest {

	@Mock
	private UserService userServiceMock;

	@Mock
	private View mockView;

	@InjectMocks
	private NotesRestController controller;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = standaloneSetup(controller).setSingleView(mockView).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findNotesTest() throws Exception {
		Note note = TestUtils.getValidTestNote();
		User user = mock(User.class);
		List<Note> list = Arrays.asList(note);
		when(userServiceMock.findByLogin(any(Principal.class))).thenReturn(user);
		when(user.getNotes()).thenReturn(list);
		mockMvc.perform(get("/api/notes")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.[0].name").value(note.getName()));
		verify(userServiceMock, times(1)).findByLogin(any(Principal.class));
		verifyNoMoreInteractions(userServiceMock);
	}
}
