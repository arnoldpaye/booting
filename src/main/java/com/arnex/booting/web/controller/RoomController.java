package com.arnex.booting.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arnex.booting.service.RoomService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public String getRoomsPage(Model model) {
        model.addAttribute("rooms", this.roomService.getAllRooms());
        return "rooms";
    }
}
