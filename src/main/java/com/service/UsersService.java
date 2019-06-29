package com.service;

import com.bean.Users;

import java.util.List;

public interface UsersService {
    int insert(Users record);
    int delete(Integer id);
    int update(Users record);
	List<Users> list();
	Users selectByPrimaryKey(Integer id);
 }
