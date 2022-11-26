package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCreator {

    @Autowired
    RoomMemory roomMemory;

    public RoomCreator(RoomMemory roomMemory) {
        this.roomMemory = roomMemory;
        initialize();
    }

    public void initialize() {
        Room room1 = Room.builder().id(2022L).build();
        Room room2 = Room.builder().id(2023L).build();
        Room room3 = Room.builder().id(2050L).build();
        roomMemory.save(room1);
        roomMemory.save(room2);
        roomMemory.save(room3);
    }
}
