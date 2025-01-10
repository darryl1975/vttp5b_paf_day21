package sg.edu.nus.iss.vttp5b_paf_day21.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.vttp5b_paf_day21.model.Room;
import sg.edu.nus.iss.vttp5b_paf_day21.service.RoomService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {
    
    @Autowired
    RoomService roomService;

    @GetMapping("")
    public ResponseEntity<List<Room>> getAllRoom() {
        List<Room> rooms = roomService.getAllRooms();

        return ResponseEntity.ok().body(rooms);
    }

    @GetMapping("/{room-id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("room-id") Integer id) {
        Room room = roomService.getRoomById(id);
        return ResponseEntity.ok().body(room);
    }

    @PutMapping("/{room-id}")
    public ResponseEntity<Boolean> updateRoomById(@PathVariable("room-id") Integer id, @RequestBody Room room) {
        Boolean roomUpdated = roomService.updatedRoomById(room);
        
        return ResponseEntity.ok().body(roomUpdated);
    }
    
    @DeleteMapping("/{room-id}")
    public ResponseEntity<Boolean> deleteRoomById(@PathVariable("room-id") Integer id) {
        Boolean roomUpdated = roomService.deleteRoomById(id);
        
        return ResponseEntity.ok().body(roomUpdated);
    }
    
}
