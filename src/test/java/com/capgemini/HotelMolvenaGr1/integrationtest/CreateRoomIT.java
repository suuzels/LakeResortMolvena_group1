package com.capgemini.HotelMolvenaGr1.integrationtest;

import com.capgemini.HotelMolvenaGr1.controller.RoomController;
import com.capgemini.HotelMolvenaGr1.model.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateRoomIT {

    private MockMvc mockMvc;

    @Autowired
    private RoomController roomController;

    @Before
    public void setUp() {

        // the model and such


        // the spring controller
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.roomController).build();
    }

    @Test
    public void testAFirst() {
        Assert.assertNotNull(this.mockMvc);
        Assert.assertNotNull(this.roomController);
    }

    @Test
    public void testBCreateBook() throws Exception {

        Room room = new Room();
        room.setRoomName("Saturn");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(room);

        MvcResult result = this.mockMvc.perform(post("/api/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andDo(print())
                .andExpect(jsonPath("$.roomName", is(room.getRoomName())))
//                .andExpect(jsonPath("$.id", is((int) room.getId())))
                .andExpect(status().isCreated())
                .andReturn();

        String resultAsString = result.getResponse().getContentAsString();

        System.err.println(resultAsString);

        Room persistedRoom = mapper.readValue(resultAsString, Room.class);

        System.err.println(persistedRoom.getId());

    }

    @Test
    public void testCGetTheSavedBook() {

    }
}
