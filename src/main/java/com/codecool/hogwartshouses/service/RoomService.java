package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;

import java.util.Set;

public interface RoomService {
    public Set<Room> getAllRooms();
    public void addRoom(Room room);
    public Room getRoomById(Long id);
    public void deleteRoom(Long id);
    public void updateRoom(Long id, Room room);
}
