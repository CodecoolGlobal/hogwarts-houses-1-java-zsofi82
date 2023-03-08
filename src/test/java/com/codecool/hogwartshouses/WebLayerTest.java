package com.codecool.hogwartshouses;

import com.codecool.hogwartshouses.controller.RoomController;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static com.codecool.hogwartshouses.model.types.HouseType.GRYFFINDOR;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoomController.class)
public class WebLayerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RoomService roomService;

    @Test
    public void roomsShouldReturnAllRoom() throws Exception {
        when(roomService.getAllRooms()).thenReturn(List.of(Room.builder().capacity(2).houseType(GRYFFINDOR).build()));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/rooms")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].capacity").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].houseType").value("GRYFFINDOR"));
    }
}
