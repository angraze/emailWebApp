package com.aa.ivy.arch.dao;

import com.aa.ivy.arch.model.Email;

import java.util.List;

public interface EmailDao {

    public void addEmail(Email email);

    public List<Email> getAllEmails();

    public void deleteEmail(Integer emailId);

    public Email updateEmail(Email email);

    public Email getEmail(int emailId);
}
