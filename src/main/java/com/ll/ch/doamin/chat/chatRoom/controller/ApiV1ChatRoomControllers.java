package com.ll.ch.doamin.chat.chatRoom.controller;

import com.ll.ch.doamin.chat.chatRoom.entity.ChatRoom;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // 외부에서 오는 http와 상호작용 가능
@RequestMapping("/api/vq/chat/rooms")
public class ApiV1ChatRoomControllers {
    private final List<ChatRoom> chatRooms = new ArrayList<>(){{
        add(
                ChatRoom
                    .builder()
                    .id(1)
                    .createDate(LocalDateTime.now())
                    .modifyDate(LocalDateTime.now())
                    .name("풋살 하실 분?")
                    .build()
        );

        add(
                ChatRoom
                        .builder()
                        .id(2)
                        .createDate(LocalDateTime.now())
                        .modifyDate(LocalDateTime.now())
                        .name("농구 하실 분?")
                        .build()
        );

        add(
                ChatRoom
                        .builder()
                        .id(3)
                        .createDate(LocalDateTime.now())
                        .modifyDate(LocalDateTime.now())
                        .name("야구 하실 분?")
                        .build()
        );
    }};

    @GetMapping
    public List<ChatRoom> getChatRooms(){
        return chatRooms;
    }

    @GetMapping("/{id}")
    public ChatRoom getChatRoom(
            @PathVariable long id
    ) {
        Optional<ChatRoom> opChatRoom = findById(id);

        return opChatRoom.get();
    }

    private Optional<ChatRoom> findById(long id) {
        return chatRooms.stream()
                .filter(chatRoom -> chatRoom.getId() == id)
                .findFirst();
    }
}
