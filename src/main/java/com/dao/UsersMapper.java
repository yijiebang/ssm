package com.dao;

import com.bean.Users;

import java.util.List;



public interface UsersMapper {

    int insert(Users record);
    int delete(Integer id);
    int update(Users record);
    List<Users> list();
    Users selectByPrimaryKey(Integer id);
}