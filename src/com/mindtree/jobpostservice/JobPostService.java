package com.mindtree.jobpostservice;

import java.util.ArrayList;

import com.mindtree.entity.Candidates;
import com.mindtree.exception.ServiceException;

public interface JobPostService {

	void mapCandidateToJobpost(int candidateid, int jobpostid)throws ServiceException;

	ArrayList<Candidates> sortCandidateBasedOnExperience(int jobid) throws ServiceException;

}
