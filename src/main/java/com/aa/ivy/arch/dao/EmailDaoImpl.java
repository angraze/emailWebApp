package com.aa.ivy.arch.dao;

import com.aa.ivy.arch.model.Email;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmailDaoImpl implements EmailDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addEmail(Email email) {
        sessionFactory.getCurrentSession().saveOrUpdate(email);
    }

    @Override
    public List<Email> getAllEmails() {
        return sessionFactory.getCurrentSession().createQuery("from Email").list();
    }

    @Override
    public void deleteEmail(Integer emailId) {
        Email email = (Email) sessionFactory.getCurrentSession().load(
                Email.class, emailId);
        if (null != email) {
            this.sessionFactory.getCurrentSession().delete(email);
        }
    }

    @Override
    public Email updateEmail(Email email) {
        sessionFactory.getCurrentSession().update(email);
        return email;
    }

    @Override
    public Email getEmail(int emailId) {
        return (Email) sessionFactory.getCurrentSession().get(Email.class, emailId);
    }
}
