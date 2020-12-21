package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.business.BbsBusiness;
import com.business.UsersBusiness;
import com.entity.Bbs;
import com.entity.Users;

public class BbsAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Bbs bbs;
	private List<Bbs> list;
	private BbsBusiness bbsBusiness;
	private UsersBusiness usersBusiness;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String id;
	private String[] ids;
	private String name;
	private String cond;
	private Map<String, Object> map = new HashMap<String, Object>();

	// 准备新增数据 Struts2需要由Action跳转到JSP 判断是否需要查询数据并放入下拉菜单
	public String createBbs() {
		List<Users> usersList = this.usersBusiness.show();
		this.map.put("usersList", usersList);
		return SUCCESS;
	}

	// 新增数据
	public String addBbs() {
		this.bbsBusiness.save(this.bbs);
		return SUCCESS;
	}

	// 按主键删除 若存在子表数据 则提示异常
	public String deleteBbs() {
		try {
			this.bbsBusiness.delete(bbs);
		} catch (Exception e) {
			this.map.put("msg", "存在关联项 不能删除");
		}
		return SUCCESS;
	}

	// 按主键批量删除 若存在子表数据 则提示异常
	public String deleteBbsByIds() {
		try {
			for (String id : this.ids) {
				this.bbsBusiness.delete(id);
			}
		} catch (Exception e) {
			this.map.put("msg", "存在关联项 不能删除");
		}
		return SUCCESS;
	}

	// 更新数据
	public String updateBbs() {
		this.bbsBusiness.update(bbs);
		return SUCCESS;
	}

	// 查询全部数据并输出分页代码
	public String getAllBbs() {
		this.list = new ArrayList<Bbs>();
		List<Bbs> tempList = new ArrayList<Bbs>();
		tempList = this.bbsBusiness.show();
		this.pageNumber = tempList.size();
		this.maxPage = this.pageNumber;
		if (this.maxPage % 10 == 0) {
			this.maxPage = this.maxPage / 10;
		} else {
			this.maxPage = this.maxPage / 10 + 1;
		}
		if (this.number == null) {
			this.number = "0";
		}
		int start = Integer.parseInt(this.number) * 10;
		int over = (Integer.parseInt(this.number) + 1) * 10;
		int count = pageNumber - over;
		if (count <= 0) {
			over = pageNumber;
		}
		for (int i = start; i < over; i++) {
			Bbs u = (Bbs) tempList.get(i);
			this.list.add(u);
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append("&nbsp;&nbsp;共为");
		buffer.append(maxPage);
		buffer.append("页&nbsp; 共有");
		buffer.append(pageNumber);
		buffer.append("条&nbsp; 当前为第");
		buffer.append((Integer.parseInt(this.number) + 1));
		buffer.append("页 &nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("首页");
		} else {
			buffer.append("<a href=\"bbs/getAllBbs.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append(
					"<a href=\"bbs/getAllBbs.action?number=" + (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append(
					"<a href=\"bbs/getAllBbs.action?number=" + (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"bbs/getAllBbs.action?number=" + (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	// 按主键查询 并做好修改的准备
	public String getBbsById() {
		this.bbs = this.bbsBusiness.checkId(this.id);
		List<Users> usersList = this.usersBusiness.show();
		this.map.put("usersList", usersList);
		return SUCCESS;
	}

	// 按条件查询数据(模糊查询)
	public String queryBbsByCond() {
		this.list = new ArrayList<Bbs>();
		if ("usersid".equals(this.cond)) {
			list = this.bbsBusiness.checkByLikeUsersid(this.name);
		}
		if ("title".equals(this.cond)) {
			list = this.bbsBusiness.checkByLikeTitle(this.name);
		}
		if ("contents".equals(this.cond)) {
			list = this.bbsBusiness.checkByLikeContents(this.name);
		}
		if ("addtime".equals(this.cond)) {
			list = this.bbsBusiness.checkByLikeAddtime(this.name);
		}
		if ("hits".equals(this.cond)) {
			list = this.bbsBusiness.checkByLikeHits(this.name);
		}
		if ("repnum".equals(this.cond)) {
			list = this.bbsBusiness.checkByLikeRepnum(this.name);
		}
		return SUCCESS;
	}

	public Bbs getBbs() {
		return bbs;
	}

	public void setBbs(Bbs bbs) {
		this.bbs = bbs;
	}

	public List<Bbs> getList() {
		return list;
	}

	public void setList(List<Bbs> list) {
		this.list = list;
	}

	public BbsBusiness getBbsBusiness() {
		return bbsBusiness;
	}

	public void setBbsBusiness(BbsBusiness bbsBusiness) {
		this.bbsBusiness = bbsBusiness;
	}

	public UsersBusiness getUsersBusiness() {
		return usersBusiness;
	}

	public void setUsersBusiness(UsersBusiness usersBusiness) {
		this.usersBusiness = usersBusiness;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

}
