package com.wf.sba.interview.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wf.sba.interview.entity.Interview;


@Repository
public interface IInterviewRepository extends JpaRepository<Interview, Long> {

	@Query("select k from Interview k where k.interviewerName = :interviewerName")
	List<Interview> getInterviewByInterviewerName(@Param("interviewerName") String interviewerName);

	@Query("select k from Interview k where k.interviewName = :interviewName")
	List<Interview> getInterviewByInterviewName(@Param("interviewName") String interviewName);	
}
