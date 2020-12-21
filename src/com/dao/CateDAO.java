package com.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.entity.Cate;

public class CateDAO extends HibernateDaoSupport {
	// 调用HibernateDaoSupport中的save方法保存数据
	public void save(Cate cate) {
		try {
			super.getHibernateTemplate().save(cate);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用update方法更新数据
	public void update(Cate cate) {
		try {
			super.getHibernateTemplate().update(cate);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按照Entity删除数据
	public void delete(Cate cate) {
		try {
			super.getHibernateTemplate().delete(cate);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键删除数据
	public void delete(int id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Cate", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 调用Find方法查询全部数据
	public void delete(String id) {
		try {
			super.getHibernateTemplate().delete(getHibernateTemplate().get("com.entity.Cate", id));
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 通过条件使用HQL语句精确查询
	@SuppressWarnings("unchecked")
	public List<Cate> show() {
		try {
			return super.getHibernateTemplate().find("From Cate");
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cate> front() {
		List<Cate> list = new ArrayList<Cate>();
		String hql = "From Cate";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(4);
		list = query.list();
		session.close();
		return list;
	}

	// 通过HQL语句模糊查询数据)
	@SuppressWarnings("unchecked")
	public List<Cate> queryByCatename(String name) {
		List<Cate> list = new ArrayList<Cate>();
		String hql = "From Cate where catename = ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, name);
		list = query.list();
		session.close();
		return list;
	}

	// 按条件查询数据(模糊查询)
	@SuppressWarnings("unchecked")
	public List<Cate> queryLikeByCatename(String name) {
		List<Cate> list = new ArrayList<Cate>();
		String hql = "From Cate where catename like ?";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + name + "%");
		list = query.list();
		session.close();
		return list;
	}

	// 按主键查询 返回的是Entity的实例
	public Cate queryById(int cateid) {
		try {
			Cate cate = (Cate) super.getHibernateTemplate().get("com.entity.Cate", cateid);
			return cate;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	// 按主键查询 返回的是Entity的实例
	public Cate queryById(String cateid) {
		try {
			Cate cate = (Cate) super.getHibernateTemplate().get("com.entity.Cate", cateid);
			return cate;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
