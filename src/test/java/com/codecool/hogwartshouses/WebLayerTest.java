package com.codecool.hogwartshouses;

import com.codecool.hogwartshouses.controller.RoomController;
import com.codecool.hogwartshouses.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
public class WebLayerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    @Test
    public void roomsShouldReturnAllRoom() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/rooms")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[*].roomId").isNotEmpty());
//
//        when(roomService.getAllRooms()).thenReturn({room1, room2, room3});
//        this.mockMvc.perform(get("rooms"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andReturn();
    }
}
