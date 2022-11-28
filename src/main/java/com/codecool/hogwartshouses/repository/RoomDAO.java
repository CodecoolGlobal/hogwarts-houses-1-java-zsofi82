package com.codecool.hogwartshouses.repository;

import com.codecool.hogwartshouses.model.Room;

import java.util.Set;

// RoomDAO will be ObjectRepository<T>
public interface RoomDAO<T> {
    Set<T> getAllRooms();
    void createRoom(T t);
    T getById(Long id);
    void deleteRoomById(Long id);
    void updateRoomById(Long id, T t);
}