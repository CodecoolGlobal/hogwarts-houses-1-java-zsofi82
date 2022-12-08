package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.repository.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService{

    private final RoomDAO<Room> roomDAO;
    @Autowired
    public RoomServiceImpl(RoomDAO<Room> roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }
    @Override
    public void createRoom(Room room) {
        roomDAO.createRoom(room);
    }

    @Override
    public void assignStudentToRoom(Room room, Student student) {
        Set<Student> residents = room.getResidents();
        if (residents.size() < room.getCapacity()) residents.add(student);
        else throw new ArithmeticException("The room is full");
        room.setResidents(residents);
    }
    @Override
    public Room getRoomById(Long roomID) {
        return roomDAO.getById(roomID);
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomDAO.deleteRoomById(roomId);
    }

    @Override
    public void updateRoom(Long roomId, Room newRoom) {
        roomDAO.updateRoomById(roomId, newRoom);
    }

    @Override
    public List<Room> getAllAvailableRooms() {
        return roomDAO.getAllAvailableRooms();
    }

    @Override
    public List<Room> getAllRoomsWithNoCatOrOwlOwners() {
        return roomDAO.getAllRoomsWithNoCatOrOwlOwners();
    }


}
