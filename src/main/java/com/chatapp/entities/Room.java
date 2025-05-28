package com.chatapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message ="Room Id cannot be blank")
    @Column(name = "room_id", unique = true, nullable = false)
    private String roomId;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}

//package com.chatapp.entities;
//
//import jakarta.persistence.*;
//        import jakarta.validation.constraints.NotBlank;
//import lombok.*;
//
//        import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "rooms")
//public class Room {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "Room Id cannot be blank")
//    @Column(unique = true)
//    private String roomId;
//
//    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Message> messages = new ArrayList<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getRoomId() {
//        return roomId;
//    }
//
//    public void setRoomId(String roomId) {
//        this.roomId = roomId;
//    }
//
//    public List<Message> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<Message> messages) {
//        this.messages = messages;
//    }
//}

