package sg.edu.nus.iss.vttp5b_paf_day21.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.vttp5b_paf_day21.model.Room;
import sg.edu.nus.iss.vttp5b_paf_day21.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;

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
    
}
