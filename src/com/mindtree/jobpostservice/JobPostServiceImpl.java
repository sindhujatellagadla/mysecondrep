package com.mindtree.jobpostservice;

import java.util.ArrayList;
import java.util.Collections;

import com.mindtree.entity.Candidates;
import com.mindtree.entity.CompareByExperience;
import com.mindtree.entity.JobPost;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.NoPositionsFoundException;
import com.mindtree.exception.ServiceException;
import com.mindtree.jobpostdao.JobPostDao;
import com.mindtree.jobpostdao.JobPostDaoImpl;

public class JobPostServiceImpl implements JobPostService {
	JobPostDao daoobj = new JobPostDaoImpl();

	public void mapCandidateToJobpost(int candidateid, int jobpostid) throws ServiceException {
		ArrayList<JobPost> jobdetails = new ArrayList();
		int updatePositionsCount = 0;
		try {
			jobdetails = daoobj.getAllDetailsAboutJobPost();
			for (int i = 0; i < jobdetails.size(); i++) {
				if (jobdetails.get(i).getId() == jobpostid) {
					if (jobdetails.get(i).getOpenpositions() > 0) {
						daoobj.mapCandidateToJobPost(candidateid, jobpostid);
						updatePositionsCount = jobdetails.get(i).getOpenpositions() - 1;
						daoobj.updatePostions(updatePositionsCount, jobpostid);
						;
					} else {
						throw new NoPositionsFoundException("No Positions Found");
					}
				}
			}

		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public ArrayList<Candidates> sortCandidateBasedOnExperience(int jobid) throws ServiceException {
		ArrayList<Candidates> candidates = new ArrayList();
		ArrayList<Candidates> candidates1 = new ArrayList();
		CompareByExperience experience = new CompareByExperience();
		try {
			candidates = daoobj.getAllDetailsAboutCandidate();
			for (int i = 0; i < candidates.size(); i++) {
				if (candidates.get(i).getJobpostid() == jobid) {
					Candidates candidates3 = new Candidates(candidates.get(i).getId(), candidates.get(i).getName(),
							candidates.get(i).getExperienceInYears(), candidates.get(i).getLocation(),
							candidates.get(i).getJobpostid());
					candidates1.add(candidates3);

				}
			}
			Collections.sort(candidates1, experience);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return candidates1;
	}

}
