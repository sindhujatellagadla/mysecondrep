package com.mindtree.jobpostclient;

import java.util.ArrayList;
import java.util.Scanner;

import com.mindtree.entity.Candidates;
import com.mindtree.entity.JobPost;
import com.mindtree.exception.ServiceException;
import com.mindtree.jobpostservice.JobPostService;
import com.mindtree.jobpostservice.JobPostServiceImpl;

public class JobPostApp {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		JobPostService serviceobj = new JobPostServiceImpl();
		JobPost jobPost = new JobPost();
		Candidates candidates = new Candidates();
		int option = 0;
		do {
			option = displayMenu();
			switch (option) {
			case 1:
				System.out.println("enter candidate id");
				int candidateid = scanner.nextInt();
				System.out.println("enter jobpost id");
				int jobpostid = scanner.nextInt();
				try {
					serviceobj.mapCandidateToJobpost(candidateid, jobpostid);
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("enter jobpostid");
				int jobid = scanner.nextInt();
				ArrayList<Candidates> candidates1;
				try {
					candidates1=serviceobj.sortCandidateBasedOnExperience(jobid);
					display(candidates1);
				} catch (ServiceException e) {
					System.out.println(e);
				}
				break;
			case 3:
				System.out.println("Exit");
				break;
			default:
				System.out.println("invalid option");
			}
		} while (option != 3);
	}

	private static void display(ArrayList<Candidates> candidates1) {
		for(int i=0;i<candidates1.size();i++)
		{
			System.out.println(candidates1.get(i).getId()+","+candidates1.get(i).getName()+","
		   +candidates1.get(i).getExperienceInYears()+","+candidates1.get(i).getLocation()+","+candidates1.get(i).getJobpostid());
			System.out.println("------------------------------------------");
		}
		
	}

	private static int displayMenu() {
		System.out.println("Enter 1 to map a candidate to the jobpost\n"
				+ "Enter 2 to sort candidates of particular jobpost as per experience\n" + "Enter 3 to exit");
		System.out.println("enter option");
		int option = scanner.nextInt();
		return option;
	}

}
