package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Applys;

public class ApplysDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Applys applys) {
		try {
			super.getHibernateTemplate().save(applys);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Applys applys) {
		try {
			super.getHibernateTemplate().update(applys);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Applys applys) {
		try {
			super.getHibernateTemplate().delete(applys);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Applys", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Applys", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Applys> show() {
		try {
			return super.getHibernateTemplate().find("From Applys");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Applys> queryByUsersid(String name) {
		List<Applys> list = new ArrayList<Applys>();
		String hql = "From Applys where usersid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Applys> queryByPetid(String name) {
		List<Applys> list = new ArrayList<Applys>();
		String hql = "From Applys where petid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Applys> queryByAddtime(String name) {
		List<Applys> list = new ArrayList<Applys>();
		String hql = "From Applys where addtime = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Applys> queryByStatus(String name) {
		List<Applys> list = new ArrayList<Applys>();
		String hql = "From Applys where status = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Applys> queryByMemo(String name) {
		List<Applys> list = new ArrayList<Applys>();
		String hql = "From Applys where memo = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Applys> queryLikeByUsersid(String name) {
		List<Applys> list = new ArrayList<Applys>();
		String hql = "From Applys where usersid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Applys> queryLikeByPetid(String name) {
		List<Applys> list = new ArrayList<Applys>();
		String hql = "From Applys where petid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Applys> queryLikeByAddtime(String name) {
		List<Applys> list = new ArrayList<Applys>();
		String hql = "From Applys where addtime like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Applys> queryLikeByStatus(String name) {
		List<Applys> list = new ArrayList<Applys>();
		String hql = "From Applys where status like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Applys> queryLikeByMemo(String name) {
		List<Applys> list = new ArrayList<Applys>();
		String hql = "From Applys where memo like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Applys queryById(int applysid) {
		try {
			Applys applys = (Applys) super.getHibernateTemplate().get("com.entity.Applys", applysid);
			return applys;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Applys queryById(String applysid) {
		try {
			Applys applys = (Applys) super.getHibernateTemplate().get("com.entity.Applys", applysid);
			return applys;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
