package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


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
        roomMemory.save(room1);
        roomMemory.save(room2);
        roomMemory.save(room3);

        System.out.println(roomMemory.getAllRooms());

        System.out.println(List.copyOf(roomMemory.getAllRooms()).stream()
                .map(Room::getResidents)
                .map(sSet -> sSet.stream().map(Student::getName).collect(Collectors.toList())));
    }
}
