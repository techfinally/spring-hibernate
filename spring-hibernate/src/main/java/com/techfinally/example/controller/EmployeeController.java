package com.techfinally.example.controller;

import com.techfinally.example.bean.ResponseData;
import com.techfinally.example.model.Employee;
import com.techfinally.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tech Finally
 */
@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> findByAll() {
        ResponseData response = new ResponseData();
        response.setCode(200);
        response.setData(employeeService.findByAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> findById(@PathVariable String id) {
        Employee employee = employeeService.findById(id);
        ResponseData response = new ResponseData();
        if (employee == null) {
            response.setCode(100);
            response.setData("NOT_FOUND");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.setCode(200);
        response.setData(employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> create(@RequestBody Employee employee) {
        boolean temp = employeeService.create(employee);
        ResponseData response = new ResponseData();
        if (!temp) {
            response.setCode(100);
            response.setData("nok");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.setCode(200);
        response.setData("ok");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> update(@RequestBody Employee employee) {
        boolean temp = employeeService.update(employee);
        ResponseData response = new ResponseData();
        if (!temp) {
            response.setCode(100);
            response.setData("NOT_FOUND");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.setCode(200);
        response.setData("OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData> delete(@PathVariable String id) {
        Employee employee = employeeService.findById(id);
        ResponseData response = new ResponseData();
        if (employee == null) {
            response.setCode(100);
            response.setData("NOT_FOUND");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        employeeService.delete(employee);
        response.setCode(200);
        response.setData("OK");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
