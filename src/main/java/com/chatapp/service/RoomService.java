package com.chatapp.service;

import com.chatapp.entities.Message;
import com.chatapp.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoomService {

    Room createRoom(String roomId);

    Room joinRoom(String roomId);

    Page<Message> getMessagesByRoomId(String roomId, Pageable pageable);




}


//package com.chatapp.service;
//
//import com.chatapp.entities.Message;
//import com.chatapp.entities.Room;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//public interface RoomService {
//
//    Room createRoom(String roomId);
//
//    Room joinRoom(String roomId);
//
//    Page<Message> getMessagesByRoomId(String roomId, Pageable pageable);
//}
//
