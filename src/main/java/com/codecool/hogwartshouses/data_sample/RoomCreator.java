package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.repository.RoomMemory;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class RoomCreator {
    RoomMemory roomMemory;

    @Autowired
    public RoomCreator(RoomMemory roomMemory) {
        this.roomMemory = roomMemory;
    }
    @PostConstruct
    public void initialize() {
        Student Hermione = Student.builder().name("Hermione Granger").petType(PetType.CAT).build();
        Student Draco = Student.builder().name("Draco Malfoy").petType(PetType.OWL).build();
        Student Luna = Student.builder().name("Luna Lovegood").petType(PetType.NONE).build();
        Student Neville = Student.builder().name("Neville Longbottom").petType(PetType.TOAD).build();

        Room room1 = Room.builder().capacity(2).houseType(HouseType.GRYFFINDOR).resident(Luna).build();
        Room room2 = Room.builder().capacity(2).houseType(HouseType.HUFFLEPUFF).resident(Neville).build();
        Room room3 = Room.builder().capacity(2).houseType(HouseType.RAVENCLAW).resident(Hermione).build();
        Room room4 = Room.builder().capacity(2).houseType(HouseType.SLYTHERIN).resident(Draco).build();
        roomMemory.createRoom(room1);
        roomMemory.createRoom(room2);
        roomMemory.createRoom(room3);
        roomMemory.createRoom(room4);
    }
}
