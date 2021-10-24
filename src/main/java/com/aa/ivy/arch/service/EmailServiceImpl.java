package com.aa.ivy.arch.service;

import com.aa.ivy.arch.dao.EmailDao;
import com.aa.ivy.arch.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailDao emailDao;

    @Override
    public void addEmail(Email email) {
        emailDao.addEmail(email);
    }

    @Override
    public List<Email> getAllEmails() {
        return emailDao.getAllEmails();
    }

    @Override
    public void deleteEmail(Integer emailId) {
        emailDao.deleteEmail(emailId);
    }

    @Override
    public Email getEmail(int emailid) {
        return emailDao.getEmail(emailid);
    }

    @Override
    public Email updateEmail(Email email) {
        return emailDao.updateEmail(email);
    }
}
