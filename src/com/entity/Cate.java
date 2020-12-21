package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Cate {
	private String cateid;

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	private String catename;

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	private List<Pet> petList = new ArrayList<Pet>();

	public List<Pet> getPetList() {
		return petList;
	}

	public void setPetList(List<Pet> petList) {
		this.petList = petList;
	}

}