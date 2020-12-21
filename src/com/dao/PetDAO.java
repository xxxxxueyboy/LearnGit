package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Pet;

public class PetDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Pet pet) {
		try {
			super.getHibernateTemplate().save(pet);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Pet pet) {
		try {
			super.getHibernateTemplate().update(pet);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Pet pet) {
		try {
			super.getHibernateTemplate().delete(pet);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Pet", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Pet", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Pet> show() {
		try {
			return super.getHibernateTemplate().find("From Pet");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pet> hot() {
		List<Pet> list = new ArrayList<Pet>();
		Session session = this.getSessionFactory().openSession();
		String hql = "From Pet where status = ? order by hits desc";
		Query query = session.createQuery(hql);
		query.setString(0, "未领养");
		query.setFirstResult(0);
		query.setMaxResults(5);
		list = query.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Pet> news() {
		List<Pet> list = new ArrayList<Pet>();
		Session session = this.getSessionFactory().openSession();
		String hql = "From Pet where status = ? order by petid desc";
		Query query = session.createQuery(hql);
		query.setString(0, "未领养");
		query.setFirstResult(0);
		query.setMaxResults(4);
		list = query.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Pet> front(String name) {
		List<Pet> list = new ArrayList<Pet>();
		Session session = this.getSessionFactory().openSession();
		String hql = "From Pet where cateid = ? and status = ? order by hits desc";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		query.setString(1, "未领养");
		query.setFirstResult(0);
		query.setMaxResults(5);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Pet> queryByPno(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where pno = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Pet> queryByPetname(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where petname = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Pet> queryByImage(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where image = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Pet> queryByCateid(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where cateid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Pet> queryByAddtime(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where addtime = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Pet> queryByHits(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where hits = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Pet> queryByStatus(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where status = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Pet> queryByContents(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where contents = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Pet> queryLikeByPno(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where pno like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Pet> queryLikeByPetname(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where petname like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Pet> queryLikeByImage(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where image like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Pet> queryLikeByCateid(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where cateid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Pet> queryLikeByAddtime(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where addtime like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Pet> queryLikeByHits(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where hits like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Pet> queryLikeByStatus(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where status like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Pet> queryLikeByContents(String name) {
		List<Pet> list = new ArrayList<Pet>();
		String hql = "From Pet where contents like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Pet queryById(int petid) {
		try {
			Pet pet = (Pet) super.getHibernateTemplate().get("com.entity.Pet", petid);
			return pet;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Pet queryById(String petid) {
		try {
			Pet pet = (Pet) super.getHibernateTemplate().get("com.entity.Pet", petid);
			return pet;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
