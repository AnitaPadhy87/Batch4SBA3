package com.wf.sba.interview.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wf.sba.interview.entity.Attend;

@Repository
public interface IAttendRepository extends JpaRepository<Attend, Long> {
	
	@Query(value = "select * from Attend at where user_id=?1 and interview_id = ?2",nativeQuery = true)
	Optional<Attend> findAttendeByUserIDIntervciewID(Long userId,Long InterviewID);
	
	@Query(value = "select * from Attend at where interview_id = ?1",nativeQuery = true)
	List<Attend> findAttendeByInterviewID(Long id);
			
}
