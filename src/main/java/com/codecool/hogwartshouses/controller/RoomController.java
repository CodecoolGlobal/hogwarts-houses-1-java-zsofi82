package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("rooms")
public class RoomController {

    protected RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // produces = {
    //        MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE }
    @GetMapping()
    public String rooms(Model model) {
        Set<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @PostMapping
    public String createRoom(@ModelAttribute("room") Room room) {
        roomService.createRoom(room);
        return "redirect:";
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
