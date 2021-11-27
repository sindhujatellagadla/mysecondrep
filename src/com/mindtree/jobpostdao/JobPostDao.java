package com.mindtree.jobpostdao;

import java.util.ArrayList;

import com.mindtree.entity.Candidates;
import com.mindtree.entity.JobPost;
import com.mindtree.exception.DaoException;

public interface JobPostDao {

	void mapCandidateToJobPost(int candidateid, int jobpostid) throws DaoException;

	ArrayList<JobPost> getAllDetailsAboutJobPost() throws DaoException;

	void updatePostions(int updatePositionsCount, int jobpostid) throws  DaoException;

	ArrayList<Candidates> getAllDetailsAboutCandidate() throws DaoException;

}
