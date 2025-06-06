package com.chatapp.repository;

import com.chatapp.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long>{
    Optional<Room> findByRoomId(String roomId);
}

