package com.epam.model;

import javax.security.auth.Subject;

public class Email {
    private String subject;
    private String text;
    private String receiver;

    public String getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }

    public String getSubject() {
        return subject;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return receiver+" "+subject+" "+text;
    }
}
