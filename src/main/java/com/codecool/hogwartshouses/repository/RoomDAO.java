package com.codecool.hogwartshouses.repository;

import java.util.List;

// RoomDAO will be ObjectRepository<T>
public interface RoomDAO<T> {
    List<T> getAllRooms();
    void createRoom(T t);
    T getById(Long id);
    void deleteRoomById(Long id);
    void updateRoomById(Long id, T t);
    List<T> getAllAvailableRooms();
    List<T> getAllRoomsWithNoCatOrOwlOwners();
}