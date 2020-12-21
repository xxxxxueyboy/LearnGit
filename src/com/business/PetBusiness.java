package com.business;
import java.util.List;
import com.dao.PetDAO;
import com.entity.Pet;
public class PetBusiness {
/** Spring IOC DAO 注入 Business * */
private PetDAO petDAO;
public PetDAO getPetDAO() { return petDAO; }
public void setPetDAO(PetDAO petDAO) { this.petDAO = petDAO; }
/** save * */
public void save(Pet pet) {this.petDAO.save(pet);}
/** update * */
public void update(Pet pet) {this.petDAO.update(pet);}
/** delete * */
public void delete(String id) {this.petDAO.delete(id);}
/** delete * */
public void delete(int id) {this.petDAO.delete(id);}
/** delete * */
public void delete(Pet pet) {this.petDAO.delete(pet);}
/** show * */
public List<Pet> show() {return petDAO.show();}
/** show * */
public List<Pet> hot() {return petDAO.hot();}
public List<Pet> news() {return petDAO.news();}
/** show * */
/** show * */
public List<Pet> front(String name) {return petDAO.front(name);}
/** check * */
public List<Pet> checkPno(String name) {return this.petDAO.queryByPno(name);}
/** check * */
public List<Pet> checkPetname(String name) {return this.petDAO.queryByPetname(name);}
/** check * */
public List<Pet> checkImage(String name) {return this.petDAO.queryByImage(name);}
/** check * */
public List<Pet> checkCateid(String name) {return this.petDAO.queryByCateid(name);}
/** check * */
public List<Pet> checkAddtime(String name) {return this.petDAO.queryByAddtime(name);}
/** check * */
public List<Pet> checkHits(String name) {return this.petDAO.queryByHits(name);}
/** check * */
public List<Pet> checkStatus(String name) {return this.petDAO.queryByStatus(name);}
/** check * */
public List<Pet> checkContents(String name) {return this.petDAO.queryByContents(name);}
/** check * */
public List<Pet> checkByLikePno(String name) {return this.petDAO.queryLikeByPno(name);}
/** check * */
public List<Pet> checkByLikePetname(String name) {return this.petDAO.queryLikeByPetname(name);}
/** check * */
public List<Pet> checkByLikeImage(String name) {return this.petDAO.queryLikeByImage(name);}
/** check * */
public List<Pet> checkByLikeCateid(String name) {return this.petDAO.queryLikeByCateid(name);}
/** check * */
public List<Pet> checkByLikeAddtime(String name) {return this.petDAO.queryLikeByAddtime(name);}
/** check * */
public List<Pet> checkByLikeHits(String name) {return this.petDAO.queryLikeByHits(name);}
/** check * */
public List<Pet> checkByLikeStatus(String name) {return this.petDAO.queryLikeByStatus(name);}
/** check * */
public List<Pet> checkByLikeContents(String name) {return this.petDAO.queryLikeByContents(name);}
/** checkId * */
public Pet checkId(String id) {return this.petDAO.queryById(id);}

}
