package com.financial.management.service;

import com.financial.management.entities.User;

public interface LoginService {
	User login(String username, String password) throws IllegalArgumentException;
	public User getUser();
}
