package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.business.AsignBusiness;
import com.business.UsersBusiness;
import com.business.ActivitiesBusiness;
import com.entity.Asign;
import com.entity.Users;
import com.entity.Activities;

public class AsignAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Asign asign;
	private List<Asign> list;
	private AsignBusiness asignBusiness;
	private UsersBusiness usersBusiness;
	private ActivitiesBusiness activitiesBusiness;
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
	public String createAsign() {
		List<Users> usersList = this.usersBusiness.show();
		this.map.put("usersList", usersList);
		List<Activities> activitiesList = this.activitiesBusiness.show();
		this.map.put("activitiesList", activitiesList);
		return SUCCESS;
	}

	// 新增数据
	public String addAsign() {
		this.asignBusiness.save(this.asign);
		return SUCCESS;
	}

	// 按主键删除 若存在子表数据 则提示异常
	public String deleteAsign() {
		try {
			this.asignBusiness.delete(asign);
		} catch (Exception e) {
			this.map.put("msg", "存在关联项 不能删除");
		}
		return SUCCESS;
	}

	// 按主键批量删除 若存在子表数据 则提示异常
	public String deleteAsignByIds() {
		try {
			for (String id : this.ids) {
				this.asignBusiness.delete(id);
			}
		} catch (Exception e) {
			this.map.put("msg", "存在关联项 不能删除");
		}
		return SUCCESS;
	}

	// 更新数据
	public String updateAsign() {
		this.asignBusiness.update(asign);
		return SUCCESS;
	}

	// 查询全部数据并输出分页代码
	public String getAllAsign() {
		this.list = new ArrayList<Asign>();
		List<Asign> tempList = new ArrayList<Asign>();
		tempList = this.asignBusiness.show();
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
			Asign u = (Asign) tempList.get(i);
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
			buffer.append("<a href=\"asign/getAllAsign.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append(
					"<a href=\"asign/getAllAsign.action?number=" + (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append(
					"<a href=\"asign/getAllAsign.action?number=" + (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"asign/getAllAsign.action?number=" + (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	// 按主键查询 并做好修改的准备
	public String getAsignById() {
		this.asign = this.asignBusiness.checkId(this.id);
		List<Users> usersList = this.usersBusiness.show();
		this.map.put("usersList", usersList);
		List<Activities> activitiesList = this.activitiesBusiness.show();
		this.map.put("activitiesList", activitiesList);
		return SUCCESS;
	}

	public String accept() {
		this.asign = this.asignBusiness.checkId(this.id);
		this.asign.setStatus("同意");
		this.asignBusiness.update(this.asign);
		return SUCCESS;
	}

	public String refuse() {
		this.asign = this.asignBusiness.checkId(this.id);
		this.asign.setStatus("拒绝");
		this.asignBusiness.update(this.asign);
		return SUCCESS;
	}

	// 按条件查询数据(模糊查询)
	public String queryAsignByCond() {
		this.list = new ArrayList<Asign>();
		if ("usersid".equals(this.cond)) {
			list = this.asignBusiness.checkByLikeUsersid(this.name);
		}
		if ("activitiesid".equals(this.cond)) {
			list = this.asignBusiness.checkByLikeActivitiesid(this.name);
		}
		if ("addtime".equals(this.cond)) {
			list = this.asignBusiness.checkByLikeAddtime(this.name);
		}
		if ("memo".equals(this.cond)) {
			list = this.asignBusiness.checkByLikeMemo(this.name);
		}
		return SUCCESS;
	}

	public Asign getAsign() {
		return asign;
	}

	public void setAsign(Asign asign) {
		this.asign = asign;
	}

	public List<Asign> getList() {
		return list;
	}

	public void setList(List<Asign> list) {
		this.list = list;
	}

	public AsignBusiness getAsignBusiness() {
		return asignBusiness;
	}

	public void setAsignBusiness(AsignBusiness asignBusiness) {
		this.asignBusiness = asignBusiness;
	}

	public UsersBusiness getUsersBusiness() {
		return usersBusiness;
	}

	public void setUsersBusiness(UsersBusiness usersBusiness) {
		this.usersBusiness = usersBusiness;
	}

	public ActivitiesBusiness getActivitiesBusiness() {
		return activitiesBusiness;
	}

	public void setActivitiesBusiness(ActivitiesBusiness activitiesBusiness) {
		this.activitiesBusiness = activitiesBusiness;
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
