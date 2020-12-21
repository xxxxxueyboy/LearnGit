package com.business;
import java.util.List;
import com.dao.AsignDAO;
import com.entity.Asign;
public class AsignBusiness {
/** Spring IOC DAO 注入 Business * */
private AsignDAO asignDAO;
public AsignDAO getAsignDAO() { return asignDAO; }
public void setAsignDAO(AsignDAO asignDAO) { this.asignDAO = asignDAO; }
/** save * */
public void save(Asign asign) {this.asignDAO.save(asign);}
/** update * */
public void update(Asign asign) {this.asignDAO.update(asign);}
/** delete * */
public void delete(String id) {this.asignDAO.delete(id);}
/** delete * */
public void delete(int id) {this.asignDAO.delete(id);}
/** delete * */
public void delete(Asign asign) {this.asignDAO.delete(asign);}
/** show * */
public List<Asign> show() {return asignDAO.show();}
/** check * */
public List<Asign> checkUsersid(String name) {return this.asignDAO.queryByUsersid(name);}
/** check * */
public List<Asign> checkActivitiesid(String name) {return this.asignDAO.queryByActivitiesid(name);}
/** check * */
public List<Asign> checkAddtime(String name) {return this.asignDAO.queryByAddtime(name);}
/** check * */
public List<Asign> checkMemo(String name) {return this.asignDAO.queryByMemo(name);}
/** check * */
public List<Asign> checkByLikeUsersid(String name) {return this.asignDAO.queryLikeByUsersid(name);}
/** check * */
public List<Asign> checkByLikeActivitiesid(String name) {return this.asignDAO.queryLikeByActivitiesid(name);}
/** check * */
public List<Asign> checkByLikeAddtime(String name) {return this.asignDAO.queryLikeByAddtime(name);}
/** check * */
public List<Asign> checkByLikeMemo(String name) {return this.asignDAO.queryLikeByMemo(name);}
/** checkId * */
public Asign checkId(String id) {return this.asignDAO.queryById(id);}

}
