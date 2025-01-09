package sg.edu.nus.iss.vttp5b_paf_day21.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5b_paf_day21.model.Room;
import sg.edu.nus.iss.vttp5b_paf_day21.utils.sql;

@Repository
public class RoomRepository {
    
    @Autowired
    JdbcTemplate template;

    // paf day 21 - slide 26 / 27
    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();

        SqlRowSet sqlRowSet = template.queryForRowSet(sql.sql_getAllRooms);
        while (sqlRowSet.next()) {
            Room rm = new Room(sqlRowSet.getInt("id"), sqlRowSet.getString("roomtype"), sqlRowSet.getFloat("price"));
            rooms.add(rm);
        }

        return rooms;
    }
}
