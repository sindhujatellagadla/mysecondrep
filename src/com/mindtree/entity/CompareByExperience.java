package com.mindtree.entity;

import java.util.Comparator;

public class CompareByExperience implements Comparator<Candidates> {

	@Override
	public int compare(Candidates o1, Candidates o2) {
		
		return o1.getExperienceInYears()-o2.getExperienceInYears();
	}

}
