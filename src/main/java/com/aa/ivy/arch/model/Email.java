package com.aa.ivy.arch.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "email")
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String toAddress;

    @Column
    private String subject;

    @Column
    private String body;

    @Column
    private boolean mailSent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isMailSent() {
        return mailSent;
    }

    public void setMailSent(boolean mailSent) {
        this.mailSent = mailSent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return id == email.id &&
                mailSent == email.mailSent &&
                Objects.equals(toAddress, email.toAddress) &&
                Objects.equals(subject, email.subject) &&
                Objects.equals(body, email.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, toAddress, subject, body, mailSent);
    }
}
