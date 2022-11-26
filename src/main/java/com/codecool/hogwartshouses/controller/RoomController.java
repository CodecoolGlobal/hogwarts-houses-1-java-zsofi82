package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("rooms")
public class RoomController {
    @Autowired
    protected RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // produces = {
    //        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE }
    @GetMapping()
    public String rooms(Model model) {
        Set<Room> rooms = roomService.getAllRooms();
        List<Room> orderedRooms = new ArrayList<>(rooms);
        model.addAttribute("rooms", orderedRooms);
        return "rooms";
    }

    @PostMapping
    public String addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
        return "rooms";
    }

    @GetMapping("/{roomId}")
    @ResponseBody
    public Room getRoomById(@PathVariable Long roomId) {
        return roomService.getRoomById(roomId);
    }

    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
    }

    @PutMapping("{roomId}")
    public String updateRoom(@PathVariable Long roomId, @RequestBody Room room) {
        roomService.updateRoom(roomId, room);
        return "rooms";
    }
}
