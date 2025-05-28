package com.chatapp.service.impl;

import com.chatapp.entities.Message;
import com.chatapp.entities.Room;
import com.chatapp.repository.MessageRepository;
import com.chatapp.repository.RoomRepository;
import com.chatapp.service.RoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final MessageRepository messageRepository;

    public RoomServiceImpl(RoomRepository roomRepository, MessageRepository messageRepository) {
        this.roomRepository = roomRepository;
        this.messageRepository = messageRepository;
    }

//    @Override
//    public Room createRoom(String roomId) {
//        // Check if room already exists
//        if (roomRepository.findByRoomId(roomId).isPresent()) {
//            throw new RuntimeException("Room already exists with ID: " + roomId);
//        }
//
//        // Create and save new room
//        Room room = new Room();
//        room.setRoomId(roomId);
//        return roomRepository.save(room);
//    }
    @Override
    public Room createRoom(String roomId) {
        if (roomRepository.findByRoomId(roomId).isPresent()) {
            throw new RuntimeException("Room already exists with ID: " + roomId);
        }
        Room room = new Room();
        room.setRoomId(roomId);
        return roomRepository.save(room);
    }

    @Override
    public Room joinRoom(String roomId) {
        return roomRepository.findByRoomId(roomId)
                .orElseThrow(() -> new RuntimeException("Room does not exist with ID: " + roomId));
    }

    @Override
    public Page<Message> getMessagesByRoomId(String roomId, Pageable pageable) {
        Room room = roomRepository.findByRoomId(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + roomId));
        return messageRepository.findByRoom(room, pageable);
    }



}

