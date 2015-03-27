package com.ehm.db.impl;

import java.sql.SQLException;

import com.ehm.db.model.Patient;


public interface LoginDao {

	Patient validate(String userName, String password) throws ClassNotFoundException, SQLException;
	
}
