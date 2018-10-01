package com.epam.model;

public class Email {
    private String subject;
    private String text;
    private String receiver;

    public String getReceiver() {
        return receiver;
    }
    public String getText(){
        return text;
    }
    public String getSubject(){
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
}
