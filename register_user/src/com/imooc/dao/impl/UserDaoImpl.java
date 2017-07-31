package com.imooc.dao.impl;

import java.sql.ResultSet;

import com.imooc.dao.UserDao;
import com.imooc.domain.User;
import com.imooc.utils.DBHelper;

public class UserDaoImpl implements UserDao {
	
	private DBHelper helper;

	public UserDaoImpl() {
		helper = DBHelper.getInstance();
	}

	@Override
	public void regist(User user) throws Exception {
		
		String sql="insert into e_user(e_id,username,password,nickname,email,state,code) values(seq_euser.nextval,?,?,?,?,?,?)";
		helper.update(sql,user.getUsername(),user.getPassword(),
				user.getNickname(),user.getEmail(),user.getState(),user.getCode());
	}

	@Override
	public User findUserByCode(String code) throws Exception {
		String sql="select * from e_user where code=?";
		ResultSet rs=helper.query(sql, code);
		User user = null;
		if(rs.next()){
			user=new User();
			int e_id = rs.getInt("e_id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String nickname = rs.getString("nickname");
			String email = rs.getString("email");
			int state=rs.getInt("state");
			user.setE_id(e_id);
			user.setUsername(username);
			user.setPassword(password);
			user.setNickname(nickname);
			user.setEmail(email);
			user.setState(state);
			user.setCode(code);
		}
		return user;
	}

	@Override
	public void update(User user) {
		
		String sql="update e_user set state=?,code=? where e_id=?";
		helper.update(sql, user.getState(),user.getCode(),user.getE_id());
	}

}
