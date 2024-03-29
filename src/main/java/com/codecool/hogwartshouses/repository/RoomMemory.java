package com.codecool.hogwartshouses.repository;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.PetType;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
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
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }
    @Override
    public void createRoom(Room room) {
        rooms.put(idCounter++, room);
    }
    @Override
    public Room getById(Long roomId) {
        return rooms.get(roomId);
    }

    @Override
    public void deleteRoomById(Long roomId) {
        rooms.remove(roomId);
    }

    @Override
    public void updateRoomById(Long roomId, Room newRoom) {
        rooms.put(roomId, newRoom);
    }

    @Override
    public List<Room> getAllAvailableRooms() {
        return rooms.values().stream()
                .filter(room -> room.getResidents() == null || room.getResidents().isEmpty())
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> getAllRoomsWithNoCatOrOwlOwners() {
        return rooms.values().stream()
                .filter(room -> room.getResidents() == null || room.getResidents()
                        .stream()
                        .noneMatch(resident -> resident.getPetType().equals(PetType.CAT) || resident.getPetType().equals(PetType.OWL)))
                .collect(Collectors.toList());
    }

}
