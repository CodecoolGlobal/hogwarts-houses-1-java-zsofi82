package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;

import java.util.Set;

public interface RoomDAO {
    Set<Room> getAllRooms();
    void save(Room room);
    Room getById(Long id);
    void deleteRoomById(Long id);

    void updateRoomById(Long id, Room room);
}