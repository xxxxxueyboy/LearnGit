package com.business;
import java.util.List;
import com.dao.RebbsDAO;
import com.entity.Rebbs;
public class RebbsBusiness {
/** Spring IOC DAO 注入 Business * */
private RebbsDAO rebbsDAO;
public RebbsDAO getRebbsDAO() { return rebbsDAO; }
public void setRebbsDAO(RebbsDAO rebbsDAO) { this.rebbsDAO = rebbsDAO; }
/** save * */
public void save(Rebbs rebbs) {this.rebbsDAO.save(rebbs);}
/** update * */
public void update(Rebbs rebbs) {this.rebbsDAO.update(rebbs);}
/** delete * */
public void delete(String id) {this.rebbsDAO.delete(id);}
/** delete * */
public void delete(int id) {this.rebbsDAO.delete(id);}
/** delete * */
public void delete(Rebbs rebbs) {this.rebbsDAO.delete(rebbs);}
/** show * */
public List<Rebbs> show() {return rebbsDAO.show();}
/** check * */
public List<Rebbs> checkUsersid(String name) {return this.rebbsDAO.queryByUsersid(name);}
/** check * */
public List<Rebbs> checkBbsid(String name) {return this.rebbsDAO.queryByBbsid(name);}
/** check * */
public List<Rebbs> checkContents(String name) {return this.rebbsDAO.queryByContents(name);}
/** check * */
public List<Rebbs> checkAddtime(String name) {return this.rebbsDAO.queryByAddtime(name);}
/** check * */
public List<Rebbs> checkByLikeUsersid(String name) {return this.rebbsDAO.queryLikeByUsersid(name);}
/** check * */
public List<Rebbs> checkByLikeBbsid(String name) {return this.rebbsDAO.queryLikeByBbsid(name);}
/** check * */
public List<Rebbs> checkByLikeContents(String name) {return this.rebbsDAO.queryLikeByContents(name);}
/** check * */
public List<Rebbs> checkByLikeAddtime(String name) {return this.rebbsDAO.queryLikeByAddtime(name);}
/** checkId * */
public Rebbs checkId(String id) {return this.rebbsDAO.queryById(id);}

}
