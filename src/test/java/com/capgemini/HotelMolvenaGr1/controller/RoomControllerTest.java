package com.capgemini.HotelMolvenaGr1.controller;

import com.capgemini.HotelMolvenaGr1.model.Room;
import com.capgemini.HotelMolvenaGr1.repository.RoomRepository;
import com.capgemini.HotelMolvenaGr1.service.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 */


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomControllerTest {

    @InjectMocks
    private RoomController roomController;

    @Mock
    private RoomRepository roomRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.roomController).build();
    }

    @Test
    public void testAddRoom() throws Exception {
        Room room = new Room();
        room.setRoomName("Saturn");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(room);

        Mockito.when(this.roomRepository.save(any(Room.class))).thenReturn(room);

        this.mockMvc.perform(post("/api/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(jsonPath("$.id", is(Long.valueOf(room.getId()).intValue())))
                .andExpect(jsonPath("$.roomName", is(room.getRoomName())))
                .andExpect(status().isCreated()
                );
    }

}
