package com.techfinally.example.service;

import com.techfinally.example.dao.EmployeeDAO;
import com.techfinally.example.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tech Finally
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findByAll() {
        return employeeDAO.findByAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeDAO.findById(id);
    }

    @Override
    public boolean create(Employee employee) {
        return employeeDAO.create(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeDAO.update(employee);
    }

    @Override
    public boolean delete(Employee employee) {
        return employeeDAO.delete(employee);
    }

}
