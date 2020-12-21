package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.business.PetBusiness;
import com.business.CateBusiness;
import com.entity.Pet;
import com.util.VeDate;
import com.entity.Cate;

public class PetAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Pet pet;
	private List<Pet> list;
	private PetBusiness petBusiness;
	private CateBusiness cateBusiness;
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
	public String createPet() {
		List<Cate> cateList = this.cateBusiness.show();
		this.map.put("cateList", cateList);
		this.id = "P" + VeDate.getStringDatex();
		return SUCCESS;
	}

	// 新增数据
	public String addPet() {
		this.pet.setAddtime(VeDate.getStringDateShort());
		this.pet.setHits("0");
		this.pet.setStatus("未领养");
		this.petBusiness.save(this.pet);
		return SUCCESS;
	}

	// 按主键删除 若存在子表数据 则提示异常
	public String deletePet() {
		try {
			this.petBusiness.delete(pet);
		} catch (Exception e) {
			this.map.put("msg", "存在关联项 不能删除");
		}
		return SUCCESS;
	}

	// 按主键批量删除 若存在子表数据 则提示异常
	public String deletePetByIds() {
		try {
			for (String id : this.ids) {
				this.petBusiness.delete(id);
			}
		} catch (Exception e) {
			this.map.put("msg", "存在关联项 不能删除");
		}
		return SUCCESS;
	}

	// 更新数据
	public String updatePet() {
		this.petBusiness.update(pet);
		return SUCCESS;
	}

	// 查询全部数据并输出分页代码
	public String getAllPet() {
		this.list = new ArrayList<Pet>();
		List<Pet> tempList = new ArrayList<Pet>();
		tempList = this.petBusiness.show();
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
			Pet u = (Pet) tempList.get(i);
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
			buffer.append("<a href=\"pet/getAllPet.action?number=0\">首页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if ((Integer.parseInt(this.number) + 1) == 1) {
			buffer.append("上一页");
		} else {
			buffer.append(
					"<a href=\"pet/getAllPet.action?number=" + (Integer.parseInt(this.number) - 1) + "\">上一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("下一页");
		} else {
			buffer.append(
					"<a href=\"pet/getAllPet.action?number=" + (Integer.parseInt(this.number) + 1) + "\">下一页</a>");
		}
		buffer.append("&nbsp;&nbsp;");
		if (this.maxPage <= (Integer.parseInt(this.number) + 1)) {
			buffer.append("尾页");
		} else {
			buffer.append("<a href=\"pet/getAllPet.action?number=" + (this.maxPage - 1) + "\">尾页</a>");
		}
		this.html = buffer.toString();
		return SUCCESS;
	}

	// 按主键查询 并做好修改的准备
	public String getPetById() {
		this.pet = this.petBusiness.checkId(this.id);
		List<Cate> cateList = this.cateBusiness.show();
		this.map.put("cateList", cateList);
		return SUCCESS;
	}

	// 按条件查询数据(模糊查询)
	public String queryPetByCond() {
		this.list = new ArrayList<Pet>();
		if ("pno".equals(this.cond)) {
			list = this.petBusiness.checkByLikePno(this.name);
		}
		if ("petname".equals(this.cond)) {
			list = this.petBusiness.checkByLikePetname(this.name);
		}
		if ("image".equals(this.cond)) {
			list = this.petBusiness.checkByLikeImage(this.name);
		}
		if ("cateid".equals(this.cond)) {
			list = this.petBusiness.checkByLikeCateid(this.name);
		}
		if ("addtime".equals(this.cond)) {
			list = this.petBusiness.checkByLikeAddtime(this.name);
		}
		if ("hits".equals(this.cond)) {
			list = this.petBusiness.checkByLikeHits(this.name);
		}
		if ("status".equals(this.cond)) {
			list = this.petBusiness.checkByLikeStatus(this.name);
		}
		if ("contents".equals(this.cond)) {
			list = this.petBusiness.checkByLikeContents(this.name);
		}
		return SUCCESS;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public List<Pet> getList() {
		return list;
	}

	public void setList(List<Pet> list) {
		this.list = list;
	}

	public PetBusiness getPetBusiness() {
		return petBusiness;
	}

	public void setPetBusiness(PetBusiness petBusiness) {
		this.petBusiness = petBusiness;
	}

	public CateBusiness getCateBusiness() {
		return cateBusiness;
	}

	public void setCateBusiness(CateBusiness cateBusiness) {
		this.cateBusiness = cateBusiness;
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
