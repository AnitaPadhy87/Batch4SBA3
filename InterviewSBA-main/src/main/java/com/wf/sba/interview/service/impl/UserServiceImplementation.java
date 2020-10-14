package com.wf.sba.interview.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.sba.interview.dto.Userdto;
import com.wf.sba.interview.entity.User;
import com.wf.sba.interview.exception.RecordNotFoundException;
import com.wf.sba.interview.repository.IUserRepository;
import com.wf.sba.interview.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	IUserRepository repository;

	@Override
	public Userdto createUser(Userdto user) {

		User userEntity = repository.save(dtoToEntity(user));
		return convertToDTO(userEntity);

	}

	@Override
	public Userdto deleteUser(Long id) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent()) {
			repository.deleteById(id);
			return convertToDTO(user.get());
		} else {
			throw new RecordNotFoundException("No user record exist for given id", String.valueOf(id));
		}
	}

	@Override
	public List<Userdto> getAllUser() {
		List<User> UserList = repository.findAll();
		if(UserList.size()!=0)
		return convertToDTO(UserList);
		else
			throw new RecordNotFoundException("Number of user present", String.valueOf(UserList.size()));
	}

	@Override
	public Userdto getUserById(Long id) {
		Optional<User> User = repository.findById(id);
		if (User.isPresent()) {
			return convertToDTO(User.get());
		} else {
			throw new RecordNotFoundException("No user record exist for given id", String.valueOf(id));
		}
	}

	private Userdto convertToDTO(User user) {
		Userdto userDto = new Userdto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setMobile(user.getMobile());
		return userDto;
	}

	private List<Userdto> convertToDTO(List<User> user) {
		return user.stream().map(x -> convertToDTO(x)).collect(Collectors.toList());
	}

	private User dtoToEntity(Userdto dto) {
		User userEntity = new User();
		userEntity.setFirstName(dto.getFirstName());
		userEntity.setLastName(dto.getLastName());
		userEntity.setEmail(dto.getEmail());
		userEntity.setMobile(dto.getMobile());
		return userEntity;
	}

}
