package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;

import java.util.Set;

public interface RoomService {
    Set<Room> getAllRooms();
    void createRoom(Room room);
    void assignStudentToRoom(Room room, Student student);
    Room getRoomById(Long roomID);
    void deleteRoom(Long roomId);
    void updateRoom(Long roomId, Room newRoom);
}
