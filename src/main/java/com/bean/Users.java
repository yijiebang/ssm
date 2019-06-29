package com.bean;


import cn.afterturn.easypoi.excel.annotation.Excel;

public class Users {
    @Excel(name = "id", width = 25)
    private Integer id;
    @Excel(name = "username", width = 25)
    private String username;
    @Excel(name = "email", width = 25)
    private String email;
    @Excel(name = "age", width = 25)
    private int age;
    @Excel(name = "phone", width = 25)
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}