package sg.edu.nus.iss.vttp5b_paf_day21.utils;

public class sql {

    public static final String sql_getAllCustomers = "SELECT * FROM customer";

    public static final String sql_getCustomers_LimitOffset = "SELECT * FROM customer LIMIT ? OFFSET ?";

    public static final String sql_getCustomersById = "SELECT * FROM customer WHERE id = ?";

    public static final String sql_deleteCustomerById = "DELETE FROM customer WHERE id = ?";

    public static final String sql_updateCustomerById = "UPDATE customer set fullname = ?, email = ? WHERE id = ?";

    public static final String sql_getAllRooms = "SELECT * FROM room";

    public static final String sql_getRoomById = "SELECT * FROM room WHERE id = ?";
    
    public static final String sql_deleteRoomById = "DELETE FROM room WHERE id = ?";

    public static final String sql_updateRoomById = "UPDATE room set roomtype = ?, price = ? WHERE id = ?";

}
