package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.DAO.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService{

    private final RoomDAO roomDAO;

    @Autowired
    public RoomServiceImpl(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public Set<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    public void addRoom(Room room) {
        roomDAO.save(room);
    }

    public Room getRoomById(Long id) {
        return roomDAO.getById(id);
    }

    public void deleteRoom(Long id) {
        roomDAO.deleteRoomById(id);
    }

    public void updateRoom(Long id, Room room) {
        roomDAO.updateRoomById(id, room);
    }
}
