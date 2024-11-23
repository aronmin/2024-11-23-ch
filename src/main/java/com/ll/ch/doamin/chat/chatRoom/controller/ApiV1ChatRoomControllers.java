package com.ll.ch.doamin.chat.chatRoom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // 외부에서 오는 http와 상호작용 가능
@RequestMapping("/api/vq/chat/rooms")
public class ApiV1ChatRoomControllers {
    @GetMapping
    public List<String> getChatRooms(){
        return List.of(
                "room1",
                "room2",
                "room3"
        );
    }
}
