package com.wf.sba.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.wf.sba.interview.entity.User;


@Repository
public interface IUserRepository extends JpaRepository<User, Long>,QueryByExampleExecutor<User> {

}
