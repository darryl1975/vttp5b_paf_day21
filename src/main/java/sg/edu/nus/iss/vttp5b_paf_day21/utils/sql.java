package sg.edu.nus.iss.vttp5b_paf_day21.utils;

public class sql {

    public static final String sql_getAllCustomers = "SELECT * FROM customer";

    public static final String sql_getCustomers_LimitOffset = "SELECT * FROM customer LIMIT ? OFFSET ?";

    public static final String sql_getCustomersById = "SELECT * FROM customer WHERE id = ?";

    public static final String sql_deleteCustomerById = "DELETE FROM customer WHERE id = ?";

    public static final String sql_updateCustomerById = "UPDATE customer set fullname = ?, email = ? WHERE id = ?";

    public static final String sql_insertCustomer = "INSERT into customer (fullname, email) VALUES (?, ?)";

    public static final String sql_getAllRooms = "SELECT * FROM room";

    public static final String sql_getRoomById = "SELECT * FROM room WHERE id = ?";
    
    public static final String sql_deleteRoomById = "DELETE FROM room WHERE id = ?";

    public static final String sql_updateRoomById = "UPDATE room set roomtype = ?, price = ? WHERE id = ?";

    public static final String sql_insertRoom = "INSERT into room (roomtype, price) VALUES (?, ?)";

    public static final String sql_insertEmployee = "insert into employee (first_name, last_name, email, job_title, department, employment_date, salary, active) values (?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String sql_deleteEmployee = "update employee set active = false where id = ?";

    public static final String sql_updateEmployee = "update employee set " + 
                "first_name = ?," + 
                "email = ?," + 
                "job_title = ?," + //
                "department = ?," + 
                "employment_date = ?," + 
                "salary = ?" + 
                "where id = ?";

    public static final String sql_selectEmployeeById = "select * from employee where id = ?";

    public static final String sql_selectAllEmployees = "select * from employee";

    
}
