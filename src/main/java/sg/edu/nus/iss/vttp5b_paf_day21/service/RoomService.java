package sg.edu.nus.iss.vttp5b_paf_day21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5b_paf_day21.model.Room;
import sg.edu.nus.iss.vttp5b_paf_day21.repository.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;
 
    public List<Room> getAllRooms() {
        return roomRepository.getRooms();
    }

    public Room getRoomById(int id) {
        return roomRepository.getRoomById(id);
    }

    public Boolean deleteRoomById(int id) {
        return roomRepository.deleteRoomById(id);
    }

    public Boolean updatedRoomById(Room room) {
        return roomRepository.updateRoomById(room);
    }
}
