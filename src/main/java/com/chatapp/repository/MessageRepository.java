package com.chatapp.repository;

import com.chatapp.entities.Message;
import com.chatapp.entities.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long>{
    Page<Message> findByRoom(Room room, Pageable pageable);
}


