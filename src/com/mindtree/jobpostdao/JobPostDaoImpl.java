package com.mindtree.jobpostdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mindtree.entity.Candidates;
import com.mindtree.entity.JobPost;
import com.mindtree.exception.ConnectionUtilityException;
import com.mindtree.exception.DaoException;
import com.mindtree.utility.ConnectionUtility;

public class JobPostDaoImpl implements JobPostDao {

	static Scanner scanner = new Scanner(System.in);
	static ConnectionUtility connection = new ConnectionUtility();

	public void mapCandidateToJobPost(int candidateid, int jobpostid) throws DaoException {
		Connection con = null;
		try {
			con = connection.getMyConnection();
		} catch (ConnectionUtilityException e) {
			throw new DaoException(e);
		}
		String query = "update candidates set jobpostid=? where id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, jobpostid);
			preparedStatement.setInt(2, candidateid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public ArrayList<JobPost> getAllDetailsAboutJobPost() throws DaoException {
		Connection con = null;
		ArrayList<JobPost> jobpost = new ArrayList();
		try {
			con = connection.getMyConnection();
		} catch (ConnectionUtilityException e) {
			throw new DaoException(e);
		}
		String query = "select * from jobpost";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(query);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				String title = resultset.getString(3);
				int openposition = resultset.getInt(4);
				JobPost jobPost = new JobPost(id, name, title, openposition);
				jobpost.add(jobPost);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return jobpost;
	}

	
	public void updatePostions(int updatePositionsCount, int jobpostid) throws DaoException {
		Connection con = null;
		try {
			con = connection.getMyConnection();
		} catch (ConnectionUtilityException e) {
			throw new DaoException(e);
		}
		String query = "update jobpost set openpositions=? where id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setInt(1, updatePositionsCount);
			preparedStatement.setInt(2, jobpostid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		
	}

	@Override
	public ArrayList<Candidates> getAllDetailsAboutCandidate() throws DaoException {
		Connection con = null;
		ArrayList<Candidates> candidates = new ArrayList();
		try {
			con = connection.getMyConnection();
		} catch (ConnectionUtilityException e) {
			throw new DaoException(e);
		}
		String query = "select * from candidates";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(query);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				int experienceinyears = resultset.getInt(3);
				String location=resultset.getString(4);
				int jobpostid = resultset.getInt(5);
				Candidates candidates1 = new Candidates(id, name, experienceinyears, location,jobpostid);
				candidates.add(candidates1);
			}
		} catch (SQLException e) {
			throw new DaoException(e);
		}
		return candidates;

	}



}
