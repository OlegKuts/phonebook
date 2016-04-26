package com.lardi.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import java.security.Principal;
import org.springframework.web.servlet.View;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;

import com.lardi.domain.Address;
import com.lardi.domain.Note;
import com.lardi.service.NoteService;
import com.lardi.utils.TestUtils;
import com.lardi.utils.form.NoteForm;

@RunWith(MockitoJUnitRunner.class)
public class NoteControllerTest {

	@Mock
	private NoteService noteServiceMock;

	@Mock
	private View mockView;

	@InjectMocks
	private NoteController controller;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = standaloneSetup(controller).setSingleView(mockView).build();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void newNoteTest() throws Exception {
		mockMvc.perform(get("/notes/new")).andExpect(status().isOk()).andExpect(view().name("new"));

	}

	@Test
	public void createValidNoteTest() throws Exception {
		doNothing().when(noteServiceMock).addNote(any(NoteForm.class), any(Principal.class));
		mockMvc.perform(post("/notes/create").params(TestUtils.getValidNoteParams())).andExpect(status().isOk())
				.andExpect(view().name("redirect:/notes"));
		verify(noteServiceMock, times(1)).addNote(any(NoteForm.class), any(Principal.class));
		verifyNoMoreInteractions(noteServiceMock);

	}

	@Test
	public void createInvalidNoteTest() throws Exception {
		Note invalidNote = TestUtils.getInvalidTestNote();
		doNothing().when(noteServiceMock).addNote(any(NoteForm.class), any(Principal.class));
		mockMvc.perform(post("/notes/create").param("note.name", invalidNote.getName())).andExpect(status().isOk())
				.andExpect(view().name("new"));
		verify(noteServiceMock, times(0)).addNote(any(NoteForm.class), any(Principal.class));
		verifyZeroInteractions(noteServiceMock);

	}

	@Test
	public void editNoteTest() throws Exception {
		Long id = 1L;
		Address address = TestUtils.getTestAddress();
		Note note = TestUtils.getValidTestNote();
		note.setAddress(address);
		when(noteServiceMock.findById(eq(id), any(Principal.class))).thenReturn(note);
		mockMvc.perform(get("/notes/edit/{id}", id)).andExpect(status().isOk()).andExpect(view().name("edit"))
				.andExpect(model().attribute("noteForm", hasProperty("note", is(note))))
				.andExpect(model().attribute("noteForm", hasProperty("address", is(address))));

		verify(noteServiceMock, times(1)).findById(eq(id), any(Principal.class));
		verifyNoMoreInteractions(noteServiceMock);

	}

	@Test
	public void updateValidNoteTest() throws Exception {
		doNothing().when(noteServiceMock).updateNote(any(NoteForm.class));
		mockMvc.perform(post("/notes/update").params(TestUtils.getValidNoteParams())).andExpect(status().isOk())
				.andExpect(view().name("redirect:/notes"));
		verify(noteServiceMock, times(1)).updateNote(any(NoteForm.class));
		verifyNoMoreInteractions(noteServiceMock);

	}

	@Test
	public void updateInvalidNoteTest() throws Exception {
		Note invalidNote = TestUtils.getInvalidTestNote();
		doNothing().when(noteServiceMock).updateNote(any(NoteForm.class));
		mockMvc.perform(post("/notes/update").param("note.name", invalidNote.getName())).andExpect(status().isOk())
				.andExpect(view().name("edit"));
		verify(noteServiceMock, times(0)).updateNote(any(NoteForm.class));
		verifyZeroInteractions(noteServiceMock);

	}

	@Test
	public void deleteNoteTest() throws Exception {
		Long id = 1L;
		doNothing().when(noteServiceMock).deleteNote(eq(id), any(Principal.class));
		mockMvc.perform(post("/notes/delete/{id}", id)).andExpect(status().isOk())
				.andExpect(view().name("redirect:/notes"));
		verify(noteServiceMock, times(1)).deleteNote(eq(id), any(Principal.class));
		verifyNoMoreInteractions(noteServiceMock);

	}

}
