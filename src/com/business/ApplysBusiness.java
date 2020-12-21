package com.business;
import java.util.List;
import com.dao.ApplysDAO;
import com.entity.Applys;
public class ApplysBusiness {
/** Spring IOC DAO 注入 Business * */
private ApplysDAO applysDAO;
public ApplysDAO getApplysDAO() { return applysDAO; }
public void setApplysDAO(ApplysDAO applysDAO) { this.applysDAO = applysDAO; }
/** save * */
public void save(Applys applys) {this.applysDAO.save(applys);}
/** update * */
public void update(Applys applys) {this.applysDAO.update(applys);}
/** delete * */
public void delete(String id) {this.applysDAO.delete(id);}
/** delete * */
public void delete(int id) {this.applysDAO.delete(id);}
/** delete * */
public void delete(Applys applys) {this.applysDAO.delete(applys);}
/** show * */
public List<Applys> show() {return applysDAO.show();}
/** check * */
public List<Applys> checkUsersid(String name) {return this.applysDAO.queryByUsersid(name);}
/** check * */
public List<Applys> checkPetid(String name) {return this.applysDAO.queryByPetid(name);}
/** check * */
public List<Applys> checkAddtime(String name) {return this.applysDAO.queryByAddtime(name);}
/** check * */
public List<Applys> checkStatus(String name) {return this.applysDAO.queryByStatus(name);}
/** check * */
public List<Applys> checkMemo(String name) {return this.applysDAO.queryByMemo(name);}
/** check * */
public List<Applys> checkByLikeUsersid(String name) {return this.applysDAO.queryLikeByUsersid(name);}
/** check * */
public List<Applys> checkByLikePetid(String name) {return this.applysDAO.queryLikeByPetid(name);}
/** check * */
public List<Applys> checkByLikeAddtime(String name) {return this.applysDAO.queryLikeByAddtime(name);}
/** check * */
public List<Applys> checkByLikeStatus(String name) {return this.applysDAO.queryLikeByStatus(name);}
/** check * */
public List<Applys> checkByLikeMemo(String name) {return this.applysDAO.queryLikeByMemo(name);}
/** checkId * */
public Applys checkId(String id) {return this.applysDAO.queryById(id);}

}
