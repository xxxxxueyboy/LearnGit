package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Bbs;

public class BbsDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Bbs bbs) {
		try {
			super.getHibernateTemplate().save(bbs);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Bbs bbs) {
		try {
			super.getHibernateTemplate().update(bbs);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Bbs bbs) {
		try {
			super.getHibernateTemplate().delete(bbs);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Bbs", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Bbs", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Bbs> show() {
		try {
			return super.getHibernateTemplate().find("From Bbs");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryByUsersid(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where usersid = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryByTitle(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where title = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryByContents(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where contents = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryByAddtime(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where addtime = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryByHits(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where hits = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryByRepnum(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where repnum = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryLikeByUsersid(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where usersid like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryLikeByTitle(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where title like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryLikeByContents(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where contents like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryLikeByAddtime(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where addtime like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryLikeByHits(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where hits like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Bbs> queryLikeByRepnum(String name) {
		List<Bbs> list = new ArrayList<Bbs>();
		String hql = "From Bbs where repnum like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Bbs queryById(int bbsid) {
		try {
			Bbs bbs = (Bbs) super.getHibernateTemplate().get("com.entity.Bbs", bbsid);
			return bbs;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Bbs queryById(String bbsid) {
		try {
			Bbs bbs = (Bbs) super.getHibernateTemplate().get("com.entity.Bbs", bbsid);
			return bbs;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
