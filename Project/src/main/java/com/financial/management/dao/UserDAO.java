package com.financial.management.dao;

import com.financial.management.entities.User;

public interface UserDAO extends GenericDAO<User, Long>{
	User login(String username, String password);
}
