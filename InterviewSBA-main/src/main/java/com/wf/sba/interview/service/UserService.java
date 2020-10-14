package com.wf.sba.interview.service;

import java.util.List;

import com.wf.sba.interview.dto.Userdto;

public interface UserService {
	
	public abstract Userdto createUser(Userdto User);

	public abstract Userdto deleteUser(Long id);

	public abstract List<Userdto> getAllUser();

	public abstract Userdto getUserById(Long id);
}