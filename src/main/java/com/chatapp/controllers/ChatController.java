package com.chatapp.controllers;

import com.chatapp.entities.Message;
import com.chatapp.entities.Room;
import com.chatapp.payload.MessageRequest;
import com.chatapp.repository.MessageRepository;
import com.chatapp.repository.RoomRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {

    private final RoomRepository roomRepository;
    private final MessageRepository messageRepository;

    public ChatController(RoomRepository roomRepository, MessageRepository messageRepository) {
        this.roomRepository = roomRepository;
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(@DestinationVariable String roomId, MessageRequest request) {
        Room room = roomRepository.findByRoomId(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId));

        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimestamp(LocalDateTime.now());
//        message.setRoom(room); // set the room in message
        messageRepository.save(message); // directly save message

        return message;
    }
}