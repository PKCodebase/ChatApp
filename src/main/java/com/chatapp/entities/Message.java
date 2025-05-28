package com.chatapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;

    private String content;

    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    private Message(String sender,String content){

        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

}

//package com.chatapp.entities;
//
//import jakarta.persistence.*;
//        import lombok.*;
//
//        import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "messages")
//public class Message {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String sender;
//
//    private String content;
//
//    private LocalDateTime timestamp;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "room_id")
//    private Room room;
//
//    public Message(String sender, String content) {
//        this.sender = sender;
//        this.content = content;
//        this.timestamp = LocalDateTime.now();
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getSender() {
//        return sender;
//    }
//
//    public void setSender(String sender) {
//        this.sender = sender;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public LocalDateTime getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(LocalDateTime timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public Room getRoom() {
//        return room;
//    }
//
//    public void setRoom(Room room) {
//        this.room = room;
//    }
//}
