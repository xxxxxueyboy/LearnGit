package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.business.ActivitiesBusiness;
import com.business.ApplysBusiness;
import com.business.ArticleBusiness;
import com.business.AsignBusiness;
import com.business.BbsBusiness;
import com.business.CateBusiness;
import com.business.PetBusiness;
import com.business.RebbsBusiness;
import com.business.UsersBusiness;
import com.entity.Activities;
import com.entity.Applys;
import com.entity.Article;
import com.entity.Asign;
import com.entity.Bbs;
import com.entity.Cate;
import com.entity.Pet;
import com.entity.Rebbs;
import com.entity.Users;
import com.util.VeDate;

public class IndexAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private String id;
	private String msg;
	private String name;
	private String cond;
	private String num;
	private int pageNumber;
	private int maxPage;
	private String html;
	private String number;
	private String username;
	private String password;
	private String repassword;
	private String newpassword;
	private String title = "流浪动物救助信息分享平台";
	private String code;

	private Users users;
	private Applys applys;
	private Rebbs rebbs;
	private Bbs bbs;

	private Map<String, Object> map = new HashMap<String, Object>();

	private ActivitiesBusiness activitiesBusiness;
	private ApplysBusiness applysBusiness;
	private ArticleBusiness articleBusiness;
	private AsignBusiness asignBusiness;
	private UsersBusiness usersBusiness;
	private CateBusiness cateBusiness;
	private PetBusiness petBusiness;
	private RebbsBusiness rebbsBusiness;
	private BbsBusiness bbsBusiness;

	private void init() {
		List<Cate> cateList = this.cateBusiness.show();
		this.map.put("cateList", cateList);
		List<Pet> hotList = this.petBusiness.hot();
		this.map.put("hotList", hotList);
	}

	public String index() {
		this.init();
		List<Cate> CateList = this.cateBusiness.front();
		List<Cate> frontList = new ArrayList<Cate>();
		for (Cate cate : CateList) {
			List<Pet> petList = this.petBusiness.front(cate.getCateid());
			cate.setPetList(petList);
			frontList.add(cate);
		}
		this.map.put("frontList", frontList);
		List<Article> articleList = this.articleBusiness.front();
		this.map.put("articleList", articleList);
		List<Pet> newsList = this.petBusiness.news();
		this.map.put("newsList", newsList);
		return SUCCESS;
	}

	public String cate() {
		this.init();
		List<Pet> petList = this.petBusiness.checkCateid(this.id);
		this.map.put("petList", petList);
		return SUCCESS;
	}

	public String all() {
		this.init();
		List<Pet> petList = this.petBusiness.show();
		this.map.put("petList", petList);
		return SUCCESS;
	}

	public String query() {
		this.init();
		List<Pet> petList = this.petBusiness.checkByLikePetname(this.name);
		this.map.put("petList", petList);
		return SUCCESS;
	}

	public String detail() {
		this.init();
		Pet pet = this.petBusiness.checkId(this.id);
		pet.setHits("" + (Integer.parseInt(pet.getHits()) + 1));
		this.petBusiness.update(pet);
		this.map.put("pet", pet);
		return SUCCESS;
	}

	// 新闻公告
	public String article() {
		this.init();
		List<Article> articleList = this.articleBusiness.show();
		this.map.put("articleList", articleList);
		return SUCCESS;
	}

	public String read() {
		this.init();
		Article article = this.articleBusiness.checkId(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleBusiness.update(article);
		this.map.put("article", article);
		return SUCCESS;
	}

	public String activities() {
		this.init();
		List<Activities> aList = this.activitiesBusiness.show();
		this.map.put("aList", aList);
		return SUCCESS;
	}

	public String readActivities() {
		this.init();
		Activities article = this.activitiesBusiness.checkId(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.activitiesBusiness.update(article);
		this.map.put("article", article);
		return SUCCESS;
	}

	public String asign() {
		this.init();
		String userid = (String) this.session.get("userid");
		Asign asign = new Asign();
		asign.setActivitiesid(this.id);
		asign.setAddtime(VeDate.getStringDateShort());
		asign.setUsersid(userid);
		this.asignBusiness.save(asign);
		Activities activities = this.activitiesBusiness.checkId(asign.getActivitiesid());
		activities.setNum("" + (Integer.parseInt(activities.getNum()) + 1));
		this.activitiesBusiness.update(activities);
		return SUCCESS;
	}

	public String myasign() {
		this.init();
		String userid = (String) this.session.get("userid");
		List<Asign> aList = this.asignBusiness.checkUsersid(userid);
		this.map.put("aList", aList);
		return SUCCESS;
	}

	public String preApply() {
		this.init();
		Pet pet = this.petBusiness.checkId(this.id);
		this.map.put("pet", pet);
		return SUCCESS;
	}

	public String addApply() {
		this.init();
		String userid = (String) this.session.get("userid");
		this.applys.setAddtime(VeDate.getStringDateShort());
		this.applys.setStatus("未批准");
		this.applys.setUsersid(userid);
		this.applysBusiness.save(this.applys);
		return SUCCESS;
	}

	public String myApply() {
		this.init();
		String userid = (String) this.session.get("userid");
		List<Applys> applysList = this.applysBusiness.checkUsersid(userid);
		this.map.put("applysList", applysList);
		return SUCCESS;
	}

	public String preLogin() {
		this.init();
		return SUCCESS;
	}

	public String login() {
		this.init();
		List<Users> usersList = this.usersBusiness.checkUsername(this.users.getUsername());
		if (usersList.size() == 0) {
			return "usererror";
		} else {
			Users user = usersList.get(0);
			if (user.getPassword().equals(this.users.getPassword())) {
				session.put("userid", user.getUsersid());
				session.put("username", user.getUsername());
				session.put("realname", user.getRealname());
				session.put("users", user);
				this.msg = "登录成功";
			} else {
				this.msg = "密码错误";
				return "usererror";
			}
		}
		return "success";
	}

	public String prePwd() {
		this.init();
		return SUCCESS;
	}

	public String editPwd() {
		List<Users> usersList = this.usersBusiness.checkUsername(this.users.getUsername());
		if (usersList.size() == 0) {

		} else {
			Users users1 = usersList.get(0);
			if (users1.getPassword().equals(this.users.getPassword())) {
				users1.setPassword(this.repassword);
				this.usersBusiness.update(users1);
				this.msg = "修改成功";
			} else {
				this.msg = "密码错误";
			}
		}
		return SUCCESS;
	}

	public String preReg() {
		this.init();
		return SUCCESS;
	}

	public String reg() {
		this.init();
		this.users.setRegdate(VeDate.getStringDateShort());
		this.usersBusiness.save(this.users);
		return SUCCESS;
	}

	public String usercenter() {
		this.init();
		this.map.put("msg", null);
		return SUCCESS;
	}

	public String personal() {
		this.init();
		this.usersBusiness.update(users);
		session.put("users", users);
		return SUCCESS;
	}

	public String exit() {
		session.clear();
		return SUCCESS;
	}

	public String allbbs() {
		this.init();
		List<Bbs> bbsList = this.bbsBusiness.show();
		this.map.put("bbsList", bbsList);
		return SUCCESS;
	}

	public String addbbs() {
		this.init();
		String userid = (String) this.session.get("userid");
		this.bbs.setUsersid(userid);
		this.bbs.setAddtime(VeDate.getStringDateShort());
		this.bbs.setHits("0");
		this.bbs.setRepnum("0");
		this.bbsBusiness.save(this.bbs);
		return SUCCESS;
	}

	public String readbbs() {
		this.init();
		Bbs bbs = this.bbsBusiness.checkId(this.id);
		bbs.setHits("" + (Integer.parseInt(bbs.getHits()) + 1));
		this.bbsBusiness.update(bbs);
		List<Rebbs> rebbsList = this.rebbsBusiness.checkBbsid(this.id);
		this.map.put("bbs", bbs);
		this.map.put("rebbsList", rebbsList);
		return SUCCESS;
	}

	public String repeat() {
		this.init();
		String userid = (String) this.session.get("userid");
		this.rebbs.setAddtime(VeDate.getStringDateShort());
		this.rebbs.setUsersid(userid);
		this.rebbsBusiness.save(this.rebbs);
		this.bbs = this.bbsBusiness.checkId(this.rebbs.getBbsid());
		this.bbs.setRepnum("" + (Integer.parseInt(this.bbs.getRepnum()) + 1));
		this.bbsBusiness.update(this.bbs);
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Applys getApplys() {
		return applys;
	}

	public void setApplys(Applys applys) {
		this.applys = applys;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public ApplysBusiness getApplysBusiness() {
		return applysBusiness;
	}

	public void setApplysBusiness(ApplysBusiness applysBusiness) {
		this.applysBusiness = applysBusiness;
	}

	public ArticleBusiness getArticleBusiness() {
		return articleBusiness;
	}

	public void setArticleBusiness(ArticleBusiness articleBusiness) {
		this.articleBusiness = articleBusiness;
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

	public CateBusiness getCateBusiness() {
		return cateBusiness;
	}

	public void setCateBusiness(CateBusiness cateBusiness) {
		this.cateBusiness = cateBusiness;
	}

	public PetBusiness getPetBusiness() {
		return petBusiness;
	}

	public void setPetBusiness(PetBusiness petBusiness) {
		this.petBusiness = petBusiness;
	}

	public RebbsBusiness getRebbsBusiness() {
		return rebbsBusiness;
	}

	public void setRebbsBusiness(RebbsBusiness rebbsBusiness) {
		this.rebbsBusiness = rebbsBusiness;
	}

	public BbsBusiness getBbsBusiness() {
		return bbsBusiness;
	}

	public void setBbsBusiness(BbsBusiness bbsBusiness) {
		this.bbsBusiness = bbsBusiness;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Rebbs getRebbs() {
		return rebbs;
	}

	public void setRebbs(Rebbs rebbs) {
		this.rebbs = rebbs;
	}

	public Bbs getBbs() {
		return bbs;
	}

	public void setBbs(Bbs bbs) {
		this.bbs = bbs;
	}

	public ActivitiesBusiness getActivitiesBusiness() {
		return activitiesBusiness;
	}

	public void setActivitiesBusiness(ActivitiesBusiness activitiesBusiness) {
		this.activitiesBusiness = activitiesBusiness;
	}

}
