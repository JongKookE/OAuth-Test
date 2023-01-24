package com.example.OAuth.controller;

public class MemberForm {
    private String name;
    private String email_1;
    private String email_2;

    public String getEmail_1() {
        return this.email_1;
    }

    public void setEmail_1(String email_1) {
        this.email_1 = email_1;
    }

    public String getEmail_2() {
        return this.email_2;
    }

    public void setEmail_2(String email_2) {
        this.email_2 = email_2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}