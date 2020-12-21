package com.business;
import java.util.List;
import com.dao.BbsDAO;
import com.entity.Bbs;
public class BbsBusiness {
/** Spring IOC DAO 注入 Business * */
private BbsDAO bbsDAO;
public BbsDAO getBbsDAO() { return bbsDAO; }
public void setBbsDAO(BbsDAO bbsDAO) { this.bbsDAO = bbsDAO; }
/** save * */
public void save(Bbs bbs) {this.bbsDAO.save(bbs);}
/** update * */
public void update(Bbs bbs) {this.bbsDAO.update(bbs);}
/** delete * */
public void delete(String id) {this.bbsDAO.delete(id);}
/** delete * */
public void delete(int id) {this.bbsDAO.delete(id);}
/** delete * */
public void delete(Bbs bbs) {this.bbsDAO.delete(bbs);}
/** show * */
public List<Bbs> show() {return bbsDAO.show();}
/** check * */
public List<Bbs> checkUsersid(String name) {return this.bbsDAO.queryByUsersid(name);}
/** check * */
public List<Bbs> checkTitle(String name) {return this.bbsDAO.queryByTitle(name);}
/** check * */
public List<Bbs> checkContents(String name) {return this.bbsDAO.queryByContents(name);}
/** check * */
public List<Bbs> checkAddtime(String name) {return this.bbsDAO.queryByAddtime(name);}
/** check * */
public List<Bbs> checkHits(String name) {return this.bbsDAO.queryByHits(name);}
/** check * */
public List<Bbs> checkRepnum(String name) {return this.bbsDAO.queryByRepnum(name);}
/** check * */
public List<Bbs> checkByLikeUsersid(String name) {return this.bbsDAO.queryLikeByUsersid(name);}
/** check * */
public List<Bbs> checkByLikeTitle(String name) {return this.bbsDAO.queryLikeByTitle(name);}
/** check * */
public List<Bbs> checkByLikeContents(String name) {return this.bbsDAO.queryLikeByContents(name);}
/** check * */
public List<Bbs> checkByLikeAddtime(String name) {return this.bbsDAO.queryLikeByAddtime(name);}
/** check * */
public List<Bbs> checkByLikeHits(String name) {return this.bbsDAO.queryLikeByHits(name);}
/** check * */
public List<Bbs> checkByLikeRepnum(String name) {return this.bbsDAO.queryLikeByRepnum(name);}
/** checkId * */
public Bbs checkId(String id) {return this.bbsDAO.queryById(id);}

}
