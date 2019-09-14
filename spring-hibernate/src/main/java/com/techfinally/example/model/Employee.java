package com.techfinally.example.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Tech Finally
 */
@Entity(name = "employee")
public class Employee implements Serializable {

    @Id
    private String employee_id;
    private String employee_name;
    private String employee_mail;
    private String employee_phone;

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_mail() {
        return employee_mail;
    }

    public void setEmployee_mail(String employee_mail) {
        this.employee_mail = employee_mail;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

}
