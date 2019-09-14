package com.techfinally.example.dao;

import com.techfinally.example.model.Employee;
import java.util.List;

/**
 *
 * @author Tech Finally
 */
public interface EmployeeDAO{

    public List<Employee> findByAll();

    public Employee findById(String id);
    
    public boolean create(Employee employee);
    
    public boolean update(Employee employee);
    
    public boolean delete(Employee employee);

}
