package com.customer_tracker.spring_demo.dao;

import com.customer_tracker.spring_demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        //execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        //return the result
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        Session currentSesion = sessionFactory.getCurrentSession();

        Customer theCustomer = currentSesion.get(Customer.class, theId);

        currentSesion.delete(theCustomer);

    }
}
