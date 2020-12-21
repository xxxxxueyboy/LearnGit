package com.business;
import java.util.List;
import com.dao.CateDAO;
import com.entity.Cate;
public class CateBusiness {
/** Spring IOC DAO 注入 Business * */
private CateDAO cateDAO;
public CateDAO getCateDAO() { return cateDAO; }
public void setCateDAO(CateDAO cateDAO) { this.cateDAO = cateDAO; }
/** save * */
public void save(Cate cate) {this.cateDAO.save(cate);}
/** update * */
public void update(Cate cate) {this.cateDAO.update(cate);}
/** delete * */
public void delete(String id) {this.cateDAO.delete(id);}
/** delete * */
public void delete(int id) {this.cateDAO.delete(id);}
/** delete * */
public void delete(Cate cate) {this.cateDAO.delete(cate);}
/** show * */
public List<Cate> show() {return cateDAO.show();}
/** show * */
public List<Cate> front() { return cateDAO.front();}
/** check * */
public List<Cate> checkCatename(String name) {return this.cateDAO.queryByCatename(name);}
/** check * */
public List<Cate> checkByLikeCatename(String name) {return this.cateDAO.queryLikeByCatename(name);}
/** checkId * */
public Cate checkId(String id) {return this.cateDAO.queryById(id);}

}
