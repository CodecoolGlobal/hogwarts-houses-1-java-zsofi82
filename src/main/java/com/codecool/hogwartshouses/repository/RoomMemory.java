package com.codecool.hogwartshouses.repository;

import com.codecool.hogwartshouses.model.Room;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// RoomMemory will be RoomRepository

// @Repository Annotation is a specialization of @Component annotation
// which is used to indicate that the class provides the mechanism for
// storage, retrieval, update, delete and search operation on objects.
@Repository
public class RoomMemory implements RoomDAO<Room> {

    protected final Map<Long, Room> rooms;
    protected Long idCounter;

    public RoomMemory() {
        this.rooms = new HashMap<>();
        this.idCounter = 1L;
    }

    @Override
    public Set<Room> getAllRooms() {
        return new HashSet<>(rooms.values());
    }

    @Override
    public void createRoom(Room room) {
        rooms.put(idCounter++, room);
    }

    @Override
    public Room getById(Long roomId) {
        return rooms.values().stream()
                .filter(room -> room.getId().equals(roomId))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public void deleteRoomById(Long roomId) {
        rooms.values().remove(rooms.values().stream().filter(room -> room.getId().equals(roomId)).findFirst().get());
    }

    @Override
    public void updateRoomById(Long roomId, Room newRoom) {
        Room roomToBeChange = rooms.values().stream().filter(room -> room.getId().equals(roomId)).findFirst().get();
        rooms.values().remove(roomToBeChange);
        rooms.put(idCounter++, newRoom);
    }
}
