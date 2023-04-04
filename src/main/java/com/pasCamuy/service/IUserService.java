package com.pasCamuy.service;

import java.util.List;
import java.util.Optional;

import com.pasCamuy.model.User;

public interface IUserService {
	public Optional <User> findById(Integer id);
	public User save(User user);
	public Optional<User>findByEmail(String email);
	public List<User>findAll();
	public void update (User user);
	public void delete(Integer id);

}
