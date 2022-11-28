package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.repository.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class RoomCreator {
    RoomMemory roomMemory;

    @Autowired
    public RoomCreator(RoomMemory roomMemory) {
        this.roomMemory = roomMemory;
        initialize();
    }

    public void initialize() {
        Student Hermione = Student.builder().id(UUID.randomUUID()).name("Hermione Granger").petType(PetType.CAT).build();
        Student Draco = Student.builder().id(UUID.randomUUID()).name("Draco Malfoy").petType(PetType.OWL).build();
        Student Luna = Student.builder().id(UUID.randomUUID()).name("Luna Lovegood").petType(PetType.NONE).build();
        Student Neville = Student.builder().id(UUID.randomUUID()).name("Neville Longbottom").petType(PetType.TOAD).build();

        Room room1 = Room.builder().id(1L).capacity(2).resident(Luna).build();
        Room room2 = Room.builder().id(2L).capacity(2).resident(Neville).build();
        Room room3 = Room.builder().id(3L).capacity(2).build();
        roomMemory.createRoom(room1);
        roomMemory.createRoom(room2);
        roomMemory.createRoom(room3);

    }
}
