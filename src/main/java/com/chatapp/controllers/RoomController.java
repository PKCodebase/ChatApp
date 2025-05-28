package com.chatapp.controllers;

import com.chatapp.entities.Message;
import com.chatapp.entities.Room;
import com.chatapp.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {

    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);


    private final RoomService roomService;


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

//    @PostMapping("/create")
//    public ResponseEntity<?> createRoom(@RequestBody String roomId) {
//        logger.info("Creating room with ID: {}", roomId);
//        try {
//            Room createdRoom = roomService.createRoom(roomId);
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
//        } catch (RuntimeException ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//        }
//    }


        @PostMapping("/create")
    public ResponseEntity<Room> createRoom(@RequestParam String roomId) {
        Room room = roomService.createRoom(roomId);
        return ResponseEntity.ok(room);
    }


//    @GetMapping("/join/{roomId}")
//    public ResponseEntity<?> joinRoom(@RequestParam String roomId) {
//        try {
//            Room joinedRoom = roomService.joinRoom(roomId);
//            return ResponseEntity.status(HttpStatus.OK).body(joinedRoom);
//        } catch (RuntimeException ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//        }
//    }

    @GetMapping("/join/{roomId}")
    public ResponseEntity<Room> joinRoom(@PathVariable String roomId) {
        Room room = roomService.joinRoom(roomId);
        return ResponseEntity.ok(room);
    }
//    @GetMapping("/{roomId}/messages")
//    public ResponseEntity<?> getMessagesByRoomId(
//            @PathVariable String roomId,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size
//    ) {
//        try {
//            Page<Message> messages = roomService.getMessagesByRoomId(roomId, PageRequest.of(page, size));
//            return ResponseEntity.ok(messages);
//        } catch (RuntimeException ex) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//        }
//    }

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<Page<Message>> getMessages(
            @PathVariable String roomId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "timestamp,desc") String[] sort
    ) {
        Sort sortObj = Sort.by(Sort.Order.desc("timestamp")); // default sort
        if (sort.length == 2) {
            String sortField = sort[0];
            String sortDirection = sort[1];
            sortObj = sortDirection.equalsIgnoreCase("asc") ?
                    Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        }

        Pageable pageable = PageRequest.of(page, size, sortObj);
        Page<Message> messages = roomService.getMessagesByRoomId(roomId, pageable);
        return ResponseEntity.ok(messages);
    }

}

//@RestController
//@RequestMapping("/api/rooms")
//public class RoomController {
//
//    @Autowired
//    private RoomService roomService;
//
//    @PostMapping("/create")
//    public ResponseEntity<Room> createRoom(@RequestParam String roomId) {
//        Room room = roomService.createRoom(roomId);
//        return ResponseEntity.ok(room);
//    }
//

//
//}
