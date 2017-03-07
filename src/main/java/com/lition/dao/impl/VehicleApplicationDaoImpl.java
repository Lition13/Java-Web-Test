package com.lition.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.lition.dao.IVehicleApplicationDao;
import com.lition.po.UseVehicleApplication;
import com.lition.util.BaseDao;
import com.lition.util.PageModel;

@Repository
public class VehicleApplicationDaoImpl extends BaseDao<UseVehicleApplication>
		implements IVehicleApplicationDao {

	@Override
	public void save(UseVehicleApplication uvp) throws RuntimeException {
		// TODO Auto-generated method stub
		getSession().save(uvp);
	}

	@Override
	public void update(UseVehicleApplication uvp) throws RuntimeException {
		// TODO Auto-generated method stub
		getSession().update(uvp);
	}

	@Override
	public void delete(UseVehicleApplication uvp) throws RuntimeException {
		// TODO Auto-generated method stub
		getSession().delete(uvp);
	}

	@Override
	public UseVehicleApplication findById(int id) {
		UseVehicleApplication uvp = (UseVehicleApplication) getSession().get(
				UseVehicleApplication.class, id);
		return uvp;
	}

	@Override
	public PageModel query(UseVehicleApplication uvp, int currentPage,
			int pageSize) {
		StringBuilder queryHql = new StringBuilder(
				"from UseVehicleApplication where 1=1 ");
		StringBuilder countHql = new StringBuilder(
				"select count(*) from UseVehicleApplication where 1=1 ");
		StringBuilder whereHql = new StringBuilder("");

		Map params = new HashMap();
		if (uvp.getState() != null && !"".equals(uvp.getState())) {
			whereHql.append(" and state=:state");
			params.put("state", uvp.getState());
		}

		PageModel pageModel = super.queryPageModel(queryHql, countHql,
				whereHql, currentPage, pageSize, params);
		return pageModel;
	}

	@Override
	public void audit(Integer id, String state) {
		String hql = "update UseVehicleApplication set state=? where id=? ";
		Session session = super.openSession();
		Query q = session.createQuery(hql);
		q.setParameter(0, state);
		q.setParameter(1, id);

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int i = q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}

	}

}
