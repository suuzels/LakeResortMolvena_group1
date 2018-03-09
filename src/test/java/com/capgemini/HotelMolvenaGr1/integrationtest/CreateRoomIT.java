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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

    private long id;


    @Before
    public void setUp() {

        // the spring controller
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.roomController).build();
    }


    @Test
    public void testCreateReadUpdateDelete() throws Exception {

        Room persistedRoom = null;

        // save one
        {
            Room room = new Room();
            room.setRoomName("Saturn");
            room.setRoomNumber(11235);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(room);

            MvcResult result = this.mockMvc.perform(post("/api/rooms")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json)).andDo(print())
                    .andExpect(jsonPath("$.roomName", is(room.getRoomName())))
                    .andExpect(jsonPath("$.roomNumber", is(room.getRoomNumber())))
                    .andExpect(status().isCreated())
                    .andReturn();

            persistedRoom = mapper.readValue(result.getResponse().getContentAsString(), Room.class);

            Assert.assertTrue(persistedRoom.getId() > 0);

        }

        // fetch one
        {
            MvcResult result = this.mockMvc.perform(get("/api/rooms/"+persistedRoom.getId())
                    .contentType(MediaType.APPLICATION_JSON))
                    .andReturn();


            ObjectMapper mapper = new ObjectMapper();
            Room retrievedRoom = mapper.readValue(result.getResponse().getContentAsString(), Room.class);

            Assert.assertEquals(persistedRoom.getId(), retrievedRoom.getId());
            Assert.assertEquals(persistedRoom.getRoomNumber(), retrievedRoom.getRoomNumber());

            this.id = retrievedRoom.getId();
        }

        // update one
        {

            Room room = new Room();
            room.setRoomName("Saturn");
            room.setRoomNumber(11235);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(room);

            MvcResult result = this.mockMvc.perform(put("/api/rooms/"+persistedRoom.getId())
                    .contentType(MediaType.APPLICATION_JSON))
                    .andReturn();
        }



    }
}
