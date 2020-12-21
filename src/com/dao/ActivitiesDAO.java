package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Activities;

public class ActivitiesDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Activities activities) {
		try {
			super.getHibernateTemplate().save(activities);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Activities activities) {
		try {
			super.getHibernateTemplate().update(activities);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Activities activities) {
		try {
			super.getHibernateTemplate().delete(activities);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Activities", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Activities", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Activities> show() {
		try {
			return super.getHibernateTemplate().find("From Activities");
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Activities> queryByTitle(String name) {
		List<Activities> list = new ArrayList<Activities>();
		String hql = "From Activities where title = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Activities> queryByContents(String name) {
		List<Activities> list = new ArrayList<Activities>();
		String hql = "From Activities where contents = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Activities> queryByAddtime(String name) {
		List<Activities> list = new ArrayList<Activities>();
		String hql = "From Activities where addtime = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Activities> queryByHits(String name) {
		List<Activities> list = new ArrayList<Activities>();
		String hql = "From Activities where hits = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Activities> queryByNum(String name) {
		List<Activities> list = new ArrayList<Activities>();
		String hql = "From Activities where num = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Activities> queryLikeByTitle(String name) {
		List<Activities> list = new ArrayList<Activities>();
		String hql = "From Activities where title like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Activities> queryLikeByContents(String name) {
		List<Activities> list = new ArrayList<Activities>();
		String hql = "From Activities where contents like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Activities> queryLikeByAddtime(String name) {
		List<Activities> list = new ArrayList<Activities>();
		String hql = "From Activities where addtime like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Activities> queryLikeByHits(String name) {
		List<Activities> list = new ArrayList<Activities>();
		String hql = "From Activities where hits like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Activities> queryLikeByNum(String name) {
		List<Activities> list = new ArrayList<Activities>();
		String hql = "From Activities where num like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Activities queryById(int activitiesid) {
		try {
			Activities activities = (Activities) super.getHibernateTemplate().get("com.entity.Activities",
					activitiesid);
			return activities;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Activities queryById(String activitiesid) {
		try {
			Activities activities = (Activities) super.getHibernateTemplate().get("com.entity.Activities",
					activitiesid);
			return activities;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
