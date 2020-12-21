package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Asign;

public class AsignDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Asign asign) {
		try {
			super.getHibernateTemplate().save(asign);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Asign asign) {
		try {
			super.getHibernateTemplate().update(asign);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Asign asign) {
		try {
			super.getHibernateTemplate().delete(asign);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Asign", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Asign", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Asign> show() {
		try {
			return super.getHibernateTemplate().find("From Asign");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Asign> queryByUsersid(String name) {
		List<Asign> list = new ArrayList<Asign>();
		String hql = "From Asign where usersid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Asign> queryByActivitiesid(String name) {
		List<Asign> list = new ArrayList<Asign>();
		String hql = "From Asign where activitiesid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Asign> queryByAddtime(String name) {
		List<Asign> list = new ArrayList<Asign>();
		String hql = "From Asign where addtime = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Asign> queryByMemo(String name) {
		List<Asign> list = new ArrayList<Asign>();
		String hql = "From Asign where memo = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Asign> queryLikeByUsersid(String name) {
		List<Asign> list = new ArrayList<Asign>();
		String hql = "From Asign where usersid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Asign> queryLikeByActivitiesid(String name) {
		List<Asign> list = new ArrayList<Asign>();
		String hql = "From Asign where activitiesid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Asign> queryLikeByAddtime(String name) {
		List<Asign> list = new ArrayList<Asign>();
		String hql = "From Asign where addtime like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Asign> queryLikeByMemo(String name) {
		List<Asign> list = new ArrayList<Asign>();
		String hql = "From Asign where memo like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Asign queryById(int asignid) {
		try {
			Asign asign = (Asign) super.getHibernateTemplate().get("com.entity.Asign", asignid);
			return asign;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Asign queryById(String asignid) {
		try {
			Asign asign = (Asign) super.getHibernateTemplate().get("com.entity.Asign", asignid);
			return asign;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
