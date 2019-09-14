package com.techfinally.example.dao;

import com.techfinally.example.model.Employee;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tech Finally
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> findByAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> list = session.createCriteria(Employee.class).list();
        return list;
    }

    @Override
    public Employee findById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Employee emp = session.get(Employee.class, id);
        return emp;
    }

    @Override
    public boolean create(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return false;
    }

}
