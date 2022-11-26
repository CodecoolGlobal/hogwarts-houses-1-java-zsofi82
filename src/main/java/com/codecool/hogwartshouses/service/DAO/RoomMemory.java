package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class RoomMemory implements RoomDAO {

    private final Set<Room> rooms;

    public RoomMemory() {
        this.rooms = new HashSet<>();
    }

    @Override
    public Set<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public void save(Room room) {
        rooms.add(room);
    }

    @Override
    public Room getById(Long id) {
        return (Room) rooms.stream()
                .filter(room -> room.getId().equals(id));
    }

    @Override
    public void deleteRoomById(Long id) {
        rooms.remove((Room) rooms.stream().filter(room -> room.getId().equals(id)));
    }

    @Override
    public void updateRoomById(Long id, Room room) {
        Room roomToBeChange = (Room) rooms.stream().filter(room1 -> room.getId().equals(id));
        rooms.remove(roomToBeChange);
        rooms.add(room);
    }
}
