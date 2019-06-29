package com.service.impl;

import com.bean.Users;
import com.dao.UsersMapper;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service

public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersMapper userMapper;



	@Override
	public int insert(Users record) {
		 
		return userMapper.insert(record);
	}

	@Override
	public int delete(Integer id) {
		return userMapper.delete(id);
	}

	@Override
	public int update(Users record) {

		return userMapper.update(record);
	}

	@Override
	public Users selectByPrimaryKey(Integer id) {

		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Users> list() {
		return userMapper.list();
	}


}
