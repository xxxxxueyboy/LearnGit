package com.business;
import java.util.List;
import com.dao.ActivitiesDAO;
import com.entity.Activities;
public class ActivitiesBusiness {
/** Spring IOC DAO 注入 Business * */
private ActivitiesDAO activitiesDAO;
public ActivitiesDAO getActivitiesDAO() { return activitiesDAO; }
public void setActivitiesDAO(ActivitiesDAO activitiesDAO) { this.activitiesDAO = activitiesDAO; }
/** save * */
public void save(Activities activities) {this.activitiesDAO.save(activities);}
/** update * */
public void update(Activities activities) {this.activitiesDAO.update(activities);}
/** delete * */
public void delete(String id) {this.activitiesDAO.delete(id);}
/** delete * */
public void delete(int id) {this.activitiesDAO.delete(id);}
/** delete * */
public void delete(Activities activities) {this.activitiesDAO.delete(activities);}
/** show * */
public List<Activities> show() {return activitiesDAO.show();}
/** check * */
public List<Activities> checkTitle(String name) {return this.activitiesDAO.queryByTitle(name);}
/** check * */
public List<Activities> checkContents(String name) {return this.activitiesDAO.queryByContents(name);}
/** check * */
public List<Activities> checkAddtime(String name) {return this.activitiesDAO.queryByAddtime(name);}
/** check * */
public List<Activities> checkHits(String name) {return this.activitiesDAO.queryByHits(name);}
/** check * */
public List<Activities> checkNum(String name) {return this.activitiesDAO.queryByNum(name);}
/** check * */
public List<Activities> checkByLikeTitle(String name) {return this.activitiesDAO.queryLikeByTitle(name);}
/** check * */
public List<Activities> checkByLikeContents(String name) {return this.activitiesDAO.queryLikeByContents(name);}
/** check * */
public List<Activities> checkByLikeAddtime(String name) {return this.activitiesDAO.queryLikeByAddtime(name);}
/** check * */
public List<Activities> checkByLikeHits(String name) {return this.activitiesDAO.queryLikeByHits(name);}
/** check * */
public List<Activities> checkByLikeNum(String name) {return this.activitiesDAO.queryLikeByNum(name);}
/** checkId * */
public Activities checkId(String id) {return this.activitiesDAO.queryById(id);}

}
