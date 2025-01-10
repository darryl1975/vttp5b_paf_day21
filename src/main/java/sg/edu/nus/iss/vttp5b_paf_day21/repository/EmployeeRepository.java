package sg.edu.nus.iss.vttp5b_paf_day21.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5b_paf_day21.model.Employee;
import sg.edu.nus.iss.vttp5b_paf_day21.model.exception.ResourceNotFoundException;
import sg.edu.nus.iss.vttp5b_paf_day21.utils.sql;

@Repository
public class EmployeeRepository {
    @Autowired
    JdbcTemplate template;

    // paf day 21 - slide 26 / 27
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees = template.query(sql.sql_selectAllEmployees, BeanPropertyRowMapper.newInstance(Employee.class));

        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("No record in Employee table");
        }

        return employees;
    }

    // public List<Employee> getEmployees(int limit, int offset) {
    //     List<Employee> Employees = new ArrayList<>();

    //     SqlRowSet sqlRowSet = template.queryForRowSet(sql.sql_getEmployees_LimitOffset, limit, offset);

    //     while (sqlRowSet.next()) {
    //         Employee Employee = new Employee();
    //         Employee.setId(sqlRowSet.getInt("id"));;
    //         Employee.setFullname(sqlRowSet.getString("fullname"));
    //         Employee.setEmail(sqlRowSet.getString("email"));
    //         Employees.add(Employee);
    //     }

    //     if (Employees.isEmpty()) {
    //         throw new ResourceNotFoundException("No record in Employee table");
    //     }

    //     return Employees;
    // }

    public Employee getEmployeeById(int id) {

        Employee c = null;
        try {
            c = template.queryForObject(sql.sql_selectEmployeeById, BeanPropertyRowMapper.newInstance(Employee.class), id);
        } catch (DataAccessException ex) {
            throw new ResourceNotFoundException("Employee with Id " + id + " not found.");
        }

        return c;
    }

    public Boolean deleteEmployeeById(int id) {

        int employeeDeleted = template.update(sql.sql_deleteEmployee, id);

        if (employeeDeleted > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateEmployeeById(Employee employee) {
        int employeeUpdated = template.update(sql.sql_updateEmployee, employee.getFirst_name(), employee.getEmail(), employee.getJob_title(), employee.getDepartment(), employee.getEmployement_date(), employee.getSalary());

        if (employeeUpdated > 0) {
            return true;
        }
        return false;
    }

    public Boolean insertNewEmployee(Employee employee) {
        int EmployeeCreated = template.update(sql.sql_insertEmployee, employee.getFirst_name(), employee.getLast_name(), employee.getEmail(), employee.getJob_title(), employee.getDepartment(), employee.getEmployement_date(), employee.getSalary(), true);

        if (EmployeeCreated > 0) {
            return true;
        }
        return false;

    }
}
