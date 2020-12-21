package com.entity;

public class Bbs {
	private String bbsid;

	public String getBbsid() {
		return bbsid;
	}

	public void setBbsid(String bbsid) {
		this.bbsid = bbsid;
	}

	private Users users;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	private String usersid;

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	private String title;

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String contents;

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	private String addtime;

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	private String hits;

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	private String repnum;

	public String getRepnum() {
		return this.repnum;
	}

	public void setRepnum(String repnum) {
		this.repnum = repnum;
	}
}