
package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.Login;

@Repository
public class LoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String signUp(Login login) {
		try {
		int result = jdbcTemplate.update("insert into login values(?,?)",login.getEmailid(),login.getPassword());
		if(result>0) {
			return "account created successfully";
		}else {
			return "Account didn't create";
		}
		}catch(Exception e) {
			return e.toString();
		}
	}
	
	public String signIn(Login login) {
		try {
		//int result = jdbcTemplate.
		//queryForList("select * from login where emailid = ? and password = ?", login.getEmailid(),login.getPassword()).size();
		int result = jdbcTemplate.queryForMap("select * from login where emailid = ? and password = ?",new Object[] {login.getEmailid(),login.getPassword()}).size();	
		if(result>0) {
			return "success";
		}else {
			return "failure";
		}
		}catch(Exception e) {
			return e.toString();
		}
	}
}
